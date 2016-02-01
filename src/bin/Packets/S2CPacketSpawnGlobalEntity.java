package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S2CPacketSpawnGlobalEntity implements Packet
{
	public int entityId;
	public int x;
	public int y;
	public int z;
	public int type;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.type = buf.readByte();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    public int func_149052_c()
    {
        return this.entityId;
    }

    public int func_149051_d()
    {
        return this.x;
    }

    public int func_149050_e()
    {
        return this.y;
    }

    public int func_149049_f()
    {
        return this.z;
    }

    public int func_149053_g()
    {
        return this.type;
    }
}