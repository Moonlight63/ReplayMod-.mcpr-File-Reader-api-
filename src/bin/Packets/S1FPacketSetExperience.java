package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S1FPacketSetExperience implements Packet
{
	public float field_149401_a;
	public int totalExperience;
	public int level;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.field_149401_a = buf.readFloat();
        this.level = buf.readVarIntFromBuffer();
        this.totalExperience = buf.readVarIntFromBuffer();
    }

    public float func_149397_c()
    {
        return this.field_149401_a;
    }

    public int getTotalExperience()
    {
        return this.totalExperience;
    }

    public int getLevel()
    {
        return this.level;
    }
}