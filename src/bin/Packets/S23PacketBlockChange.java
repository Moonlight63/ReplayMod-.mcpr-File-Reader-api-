package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

public class S23PacketBlockChange implements Packet
{
	public BlockPos blockPosition;
    public int blockState;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.blockPosition = buf.readBlockPos();
        this.blockState = buf.readVarIntFromBuffer();
    }

    public int getBlockState()
    {
        return this.blockState;
    }

    public BlockPos getBlockPosition()
    {
        return this.blockPosition;
    }
}