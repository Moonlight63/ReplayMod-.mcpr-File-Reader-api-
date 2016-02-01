package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S19PacketEntityStatus implements Packet
{
	public int entityId;
	public byte logicOpcode;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readInt();
        this.logicOpcode = buf.readByte();
    }

    public int getEntity()
    {
        return this.entityId;
    }

    public byte getOpCode()
    {
        return this.logicOpcode;
    }
}