package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S03PacketTimeUpdate implements Packet
{
	public long totalWorldTime;
	public long worldTime;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.totalWorldTime = buf.readLong();
        this.worldTime = buf.readLong();
    }

    public long getTotalWorldTime()
    {
        return this.totalWorldTime;
    }

    public long getWorldTime()
    {
        return this.worldTime;
    }
}