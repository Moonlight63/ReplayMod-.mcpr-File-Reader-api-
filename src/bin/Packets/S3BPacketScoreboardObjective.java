package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;


public class S3BPacketScoreboardObjective implements Packet
{
	public String objectiveName;
	public String objectiveValue;
	public String type;
	public int field_149342_c;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.objectiveName = buf.readStringFromBuffer(16);
        this.field_149342_c = buf.readByte();

        if (this.field_149342_c == 0 || this.field_149342_c == 2)
        {
            this.objectiveValue = buf.readStringFromBuffer(32);
            this.type = (buf.readStringFromBuffer(16));
        }
    }

    public String func_149339_c()
    {
        return this.objectiveName;
    }

    public String func_149337_d()
    {
        return this.objectiveValue;
    }

    public int func_149338_e()
    {
        return this.field_149342_c;
    }

    public String func_179817_d()
    {
        return this.type;
    }
}