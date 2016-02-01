package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S0BPacketAnimation implements Packet
{
	public int entityId;
	public int type;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.type = buf.readUnsignedByte();
    }

    public int getEntityID()
    {
        return this.entityId;
    }

    public int getAnimationType()
    {
        return this.type;
    }
}