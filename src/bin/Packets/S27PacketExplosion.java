package bin.Packets;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

public class S27PacketExplosion implements Packet
{
	public double posX;
	public double posY;
	public double posZ;
	public float strength;
	public List<BlockPos> affectedBlockPositions;
	public float field_149152_f;
	public float field_149153_g;
	public float field_149159_h;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.posX = (double)buf.readFloat();
        this.posY = (double)buf.readFloat();
        this.posZ = (double)buf.readFloat();
        this.strength = buf.readFloat();
        int i = buf.readInt();
        this.affectedBlockPositions = Lists.<BlockPos>newArrayListWithCapacity(i);
        int j = (int)this.posX;
        int k = (int)this.posY;
        int l = (int)this.posZ;

        for (int i1 = 0; i1 < i; ++i1)
        {
            int j1 = buf.readByte() + j;
            int k1 = buf.readByte() + k;
            int l1 = buf.readByte() + l;
            this.affectedBlockPositions.add(new BlockPos(j1, k1, l1));
        }

        this.field_149152_f = buf.readFloat();
        this.field_149153_g = buf.readFloat();
        this.field_149159_h = buf.readFloat();
    }

    public float func_149149_c()
    {
        return this.field_149152_f;
    }

    public float func_149144_d()
    {
        return this.field_149153_g;
    }

    public float func_149147_e()
    {
        return this.field_149159_h;
    }

    public double getX()
    {
        return this.posX;
    }

    public double getY()
    {
        return this.posY;
    }

    public double getZ()
    {
        return this.posZ;
    }

    public float getStrength()
    {
        return this.strength;
    }

    public List<BlockPos> getAffectedBlockPositions()
    {
        return this.affectedBlockPositions;
    }
}