package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S48PacketResourcePackSend implements Packet
{
	public String url;
	public String hash;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.url = buf.readStringFromBuffer(32767);
        this.hash = buf.readStringFromBuffer(40);
    }

    public String getURL()
    {
        return this.url;
    }

    public String getHash()
    {
        return this.hash;
    }
}