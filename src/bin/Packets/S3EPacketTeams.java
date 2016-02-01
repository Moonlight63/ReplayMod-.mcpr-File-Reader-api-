package bin.Packets;

import java.io.IOException;
import java.util.Collection;

import bin.Packet;
import bin.PacketBuffer;

public class S3EPacketTeams implements Packet
{
	public String field_149320_a = "";
	public String field_149318_b = "";
	public String field_149319_c = "";
	public String field_149316_d = "";
	public String field_179816_e;
	public int field_179815_f;
	public Collection<String> field_149317_e;
	public int field_149314_f;
	public int field_149315_g;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.field_149320_a = buf.readStringFromBuffer(16);
        this.field_149314_f = buf.readByte();

        if (this.field_149314_f == 0 || this.field_149314_f == 2)
        {
            this.field_149318_b = buf.readStringFromBuffer(32);
            this.field_149319_c = buf.readStringFromBuffer(16);
            this.field_149316_d = buf.readStringFromBuffer(16);
            this.field_149315_g = buf.readByte();
            this.field_179816_e = buf.readStringFromBuffer(32);
            this.field_179815_f = buf.readByte();
        }

        if (this.field_149314_f == 0 || this.field_149314_f == 3 || this.field_149314_f == 4)
        {
            int i = buf.readVarIntFromBuffer();

            for (int j = 0; j < i; ++j)
            {
                this.field_149317_e.add(buf.readStringFromBuffer(40));
            }
        }
    }

    public String func_149312_c()
    {
        return this.field_149320_a;
    }

    public String func_149306_d()
    {
        return this.field_149318_b;
    }

    public String func_149311_e()
    {
        return this.field_149319_c;
    }

    public String func_149309_f()
    {
        return this.field_149316_d;
    }

    public Collection<String> func_149310_g()
    {
        return this.field_149317_e;
    }

    public int func_149307_h()
    {
        return this.field_149314_f;
    }

    public int func_149308_i()
    {
        return this.field_149315_g;
    }

    public int func_179813_h()
    {
        return this.field_179815_f;
    }

    public String func_179814_i()
    {
        return this.field_179816_e;
    }
}