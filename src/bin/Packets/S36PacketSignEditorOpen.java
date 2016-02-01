package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

public class S36PacketSignEditorOpen implements Packet
{
	public BlockPos signPosition;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.signPosition = buf.readBlockPos();
    }

    public BlockPos getSignPosition()
    {
        return this.signPosition;
    }
}