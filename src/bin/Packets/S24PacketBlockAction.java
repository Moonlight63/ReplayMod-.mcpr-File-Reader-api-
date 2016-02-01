package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

public class S24PacketBlockAction implements Packet
{
	public BlockPos blockPosition;
	public int instrument;
	public int pitch;
	public int block;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.blockPosition = buf.readBlockPos();
        this.instrument = buf.readUnsignedByte();
        this.pitch = buf.readUnsignedByte();
        this.block = buf.readVarIntFromBuffer() & 4095;
    }

    public BlockPos getBlockPosition()
    {
        return this.blockPosition;
    }

    /**
     * instrument data for noteblocks
     */
    public int getData1()
    {
        return this.instrument;
    }

    /**
     * pitch data for noteblocks
     */
    public int getData2()
    {
        return this.pitch;
    }

    public int getBlockType()
    {
        return this.block;
    }
}