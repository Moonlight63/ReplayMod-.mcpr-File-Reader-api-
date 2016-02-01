package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S1EPacketRemoveEntityEffect implements Packet
{
	public int entityId;
	public int effectId;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.effectId = buf.readUnsignedByte();
    }

    public int getEntityId()
    {
        return this.entityId;
    }

    public int getEffectId()
    {
        return this.effectId;
    }
}