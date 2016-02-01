package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S31PacketWindowProperty implements Packet
{
	public int windowId;
	public int varIndex;
	public int varValue;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.windowId = buf.readUnsignedByte();
        this.varIndex = buf.readShort();
        this.varValue = buf.readShort();
    }

    public int getWindowId()
    {
        return this.windowId;
    }

    public int getVarIndex()
    {
        return this.varIndex;
    }

    public int getVarValue()
    {
        return this.varValue;
    }
}