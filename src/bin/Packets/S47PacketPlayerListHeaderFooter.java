package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S47PacketPlayerListHeaderFooter implements Packet
{
	public String header;
	public String footer;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.header = buf.readStringFromBuffer(32767);
        this.footer = buf.readStringFromBuffer(32767);
    }

    public String getHeader()
    {
        return this.header;
    }

    public String getFooter()
    {
        return this.footer;
    }
}