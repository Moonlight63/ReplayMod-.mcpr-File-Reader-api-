package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

public class S05PacketSpawnPosition implements Packet
{
	public BlockPos spawnBlockPos;
    
    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.spawnBlockPos = buf.readBlockPos();
    }

    public BlockPos getSpawnPos()
    {
        return this.spawnBlockPos;
    }
}