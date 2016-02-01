package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S02PacketChat implements Packet
{
	public byte type;
    public String json;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
    	this.json = buf.readStringFromBuffer(32767);
        //this.chatComponent = buf.readChatComponent();
        this.type = buf.readByte();
    }

    public boolean isChat()
    {
        return this.type == 1 || this.type == 2;
    }

    /**
     * Returns the id of the area to display the text, 2 for above the action bar, anything else currently for the chat
     * window
     */
    public byte getType()
    {
        return this.type;
    }
}