package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

public class S25PacketBlockBreakAnim implements Packet
{
	public int breakerId;
	public BlockPos position;
	public int progress;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.breakerId = buf.readVarIntFromBuffer();
        this.position = buf.readBlockPos();
        this.progress = buf.readUnsignedByte();
    }

    public int getBreakerId()
    {
        return this.breakerId;
    }

    public BlockPos getPosition()
    {
        return this.position;
    }

    public int getProgress()
    {
        return this.progress;
    }
}