package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S26PacketMapChunkBulk implements Packet
{
	public int[] xPositions;
	public int[] zPositions;
	public S21PacketChunkData.Extracted[] chunksData;
	public boolean isOverworld;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.isOverworld = buf.readBoolean();
        int i = buf.readVarIntFromBuffer();
        this.xPositions = new int[i];
        this.zPositions = new int[i];
        this.chunksData = new S21PacketChunkData.Extracted[i];

        for (int j = 0; j < i; ++j)
        {
            this.xPositions[j] = buf.readInt();
            this.zPositions[j] = buf.readInt();
            this.chunksData[j] = new S21PacketChunkData.Extracted();
            this.chunksData[j].dataSize = buf.readShort() & 65535;
            this.chunksData[j].data = new byte[S21PacketChunkData.func_180737_a(Integer.bitCount(this.chunksData[j].dataSize), this.isOverworld, true)];
        }

        for (int k = 0; k < i; ++k)
        {
            buf.readBytes(this.chunksData[k].data);
        }
    }

    /**
     * Writes the raw packet data to the data stream.
     */
    public void writePacketData(PacketBuffer buf) throws IOException
    {
        buf.writeBoolean(this.isOverworld);
        buf.writeVarIntToBuffer(this.chunksData.length);

        for (int i = 0; i < this.xPositions.length; ++i)
        {
            buf.writeInt(this.xPositions[i]);
            buf.writeInt(this.zPositions[i]);
            buf.writeShort((short)(this.chunksData[i].dataSize & 65535));
        }

        for (int j = 0; j < this.xPositions.length; ++j)
        {
            buf.writeBytes(this.chunksData[j].data);
        }
    }

    public int getChunkX(int p_149255_1_)
    {
        return this.xPositions[p_149255_1_];
    }

    public int getChunkZ(int p_149253_1_)
    {
        return this.zPositions[p_149253_1_];
    }

    public int getChunkCount()
    {
        return this.xPositions.length;
    }

    public byte[] getChunkBytes(int p_149256_1_)
    {
        return this.chunksData[p_149256_1_].data;
    }

    public int getChunkSize(int p_179754_1_)
    {
        return this.chunksData[p_179754_1_].dataSize;
    }
}