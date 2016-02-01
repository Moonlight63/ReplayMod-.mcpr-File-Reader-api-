package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

public class S33PacketUpdateSign implements Packet
{
	public BlockPos blockPos;
	public String[] lines;


    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.blockPos = buf.readBlockPos();
        this.lines = new String[4];

        for (int i = 0; i < 4; ++i)
        {
            this.lines[i] = buf.readStringFromBuffer(32767);
        }
    }

    public BlockPos getPos()
    {
        return this.blockPos;
    }

    public String[] getLines()
    {
        return this.lines;
    }
}