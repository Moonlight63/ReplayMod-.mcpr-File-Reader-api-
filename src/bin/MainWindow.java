package bin;

import io.netty.buffer.ByteBuf;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MainWindow {

	private JFrame frame;
	private JTextField textFilePathField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {e.printStackTrace();     }
		
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textFilePathField = new JTextField();
		textFilePathField.setColumns(10);
		
		JButton buttonBrowseLocation = new JButton("...");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnAnalyze = new JButton("Analyze");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textFilePathField, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonBrowseLocation)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAnalyze)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFilePathField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnalyze)
						.addComponent(buttonBrowseLocation))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Data") {
				{
					
				}
			}
		));
		scrollPane.setViewportView(tree);
		frame.getContentPane().setLayout(groupLayout);
		
		
		
		buttonBrowseLocation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(new File(getMinecraftDir(), "replay_recordings"));
				jfc.setDialogType(JFileChooser.OPEN_DIALOG);
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if(jfc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION){
					textFilePathField.setText(jfc.getSelectedFile().getAbsolutePath());
				}
				
			}
		});
		
		btnAnalyze.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//textContentArea.setText(ReadFile());
				
				
				DefaultMutableTreeNode root = ((DefaultMutableTreeNode)((DefaultTreeModel)tree.getModel()).getRoot());
				
				for (PacketContainer packet : ReadFile()) {
					
					ByteBuf bb = io.netty.buffer.Unpooled.wrappedBuffer(packet.bb);
					
					PacketBuffer pb = new PacketBuffer(bb);
					
					int i = pb.readVarIntFromBuffer();
					
					Packet p;
					try {
						p = PacketsEnum.CLIENTPLAY.getPacket(i);
						
						if(p != null){
							p.readPacketData(pb);
							
							DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(packet.timestamp);
							((DefaultTreeModel)tree.getModel()).insertNodeInto(node1, root, root.getChildCount());
							
							DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(p.getClass().getName());
							((DefaultTreeModel)tree.getModel()).insertNodeInto(node2, node1, 0);
							
							Field[] fields = p.getClass().getDeclaredFields();
							for (Field field : fields) {
								DefaultMutableTreeNode node3 = new DefaultMutableTreeNode(field.getName());
								((DefaultTreeModel)tree.getModel()).insertNodeInto(node3, node2, node2.getChildCount());
								
								if(field.isAccessible()){
									DefaultMutableTreeNode node4 = new DefaultMutableTreeNode(field.get(p));
									((DefaultTreeModel)tree.getModel()).insertNodeInto(node4, node3, 0);
								}
							}								
						}
					} catch (InstantiationException | IllegalAccessException | IOException e2) {
						e2.printStackTrace();
					}
					
				}
			
			}
		});
		
	}
	
	protected List<PacketContainer> ReadFile() {
		try {
			ZipFile zipFile = new ZipFile(textFilePathField.getText());
			
			ZipEntry recordingData = zipFile.getEntry("recording.tmcpr");
			
			DataInputStream dis = new DataInputStream((InputStream) zipFile.getInputStream(recordingData));
			
			List<PacketContainer> packets = new LinkedList<PacketContainer>();
			
			try {
				for (;;) {
					
					int timestamp = dis.readInt();
				    int bytes = dis.readInt();
				    byte[] bb = new byte[bytes];
				    dis.readFully(bb);
				    
				    PacketContainer packet = new PacketContainer(timestamp, bytes, bb);
					
					packets.add(packet);
					
				}
			} catch (EOFException e) {
				zipFile.close();
				//e.printStackTrace();
				return packets;
				
			}
			
			//return Integer.toString(dis.readInt());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	class PacketContainer{
		public int timestamp = 2;
		public int bytes = 0;
		public byte[] bb = new byte[bytes];
		
		public PacketContainer(int time, int bytecount, byte[] bytes) throws IOException{
			this.timestamp = time;
			this.bytes = bytecount;
			this.bb = bytes;
		}
	}
	
	/**
     * Reads a compressed int from the buffer. To do so it maximally reads 5 byte-sized chunks whose most significant
     * bit dictates whether another byte should be read.
     */
    public int readVarIntFromBuffer(ByteBuf buf)
    {
        int i = 0;
        int j = 0;

        while (true)
        {
            byte b0 = buf.readByte();
            i |= (b0 & 127) << j++ * 7;

            if (j > 5)
            {
                throw new RuntimeException("VarInt too big");
            }

            if ((b0 & 128) != 128)
            {
                break;
            }
        }

        return i;
    }

	public static File getMinecraftDir() {
		String minecraft = "minecraft";
		String osname = System.getProperty("os.name").toLowerCase();
		String default_home = System.getProperty("user.home", ".");

		if (osname.contains("solaris") || osname.contains("sunos") || osname.contains("linux")
				|| osname.contains("unix")) {
			return new File(default_home, "." + minecraft);
		}

		if (osname.contains("win")) {
			String win_home = System.getenv("APPDATA");
			if (win_home != null)
				return new File(win_home, "." + minecraft);
			else
				return new File(default_home, "." + minecraft);
		}

		if (osname.contains("mac")) {
			return new File(default_home, "Library/Application Support/" + minecraft);
		}

		return null;
	}
}
