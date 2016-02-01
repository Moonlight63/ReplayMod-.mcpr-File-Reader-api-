package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S2DPacketOpenWindow implements Packet
{
	public int windowId;
	public String inventoryType;
	public String windowTitle;
	public int slotCount;
	public int entityId;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.windowId = buf.readUnsignedByte();
        this.inventoryType = buf.readStringFromBuffer(32);
        this.windowTitle = buf.readStringFromBuffer(32767);
        this.slotCount = buf.readUnsignedByte();

        if (this.inventoryType.equals("EntityHorse"))
        {
            this.entityId = buf.readInt();
        }
    }

    public int getWindowId()
    {
        return this.windowId;
    }

    public String getGuiId()
    {
        return this.inventoryType;
    }

    public String getWindowTitle()
    {
        return this.windowTitle;
    }
    
    public int getSlotCount()
    {
        return this.slotCount;
    }

    public int getEntityId()
    {
        return this.entityId;
    }

    public boolean hasSlots()
    {
        return this.slotCount > 0;
    }
}