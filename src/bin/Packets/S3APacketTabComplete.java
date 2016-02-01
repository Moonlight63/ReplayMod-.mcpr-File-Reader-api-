package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S3APacketTabComplete implements Packet
{
	public String[] matches;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.matches = new String[buf.readVarIntFromBuffer()];

        for (int i = 0; i < this.matches.length; ++i)
        {
            this.matches[i] = buf.readStringFromBuffer(32767);
        }
    }

    public String[] func_149630_c()
    {
        return this.matches;
    }
}