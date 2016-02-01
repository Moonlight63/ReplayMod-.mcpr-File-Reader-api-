package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S1DPacketEntityEffect implements Packet
{
	public int entityId;
	public byte effectId;
	public byte amplifier;
	public int duration;
	public byte hideParticles;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.effectId = buf.readByte();
        this.amplifier = buf.readByte();
        this.duration = buf.readVarIntFromBuffer();
        this.hideParticles = buf.readByte();
    }

    public boolean func_149429_c()
    {
        return this.duration == 32767;
    }

    public int getEntityId()
    {
        return this.entityId;
    }

    public byte getEffectId()
    {
        return this.effectId;
    }

    public byte getAmplifier()
    {
        return this.amplifier;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public boolean func_179707_f()
    {
        return this.hideParticles != 0;
    }
}