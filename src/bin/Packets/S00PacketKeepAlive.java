package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S00PacketKeepAlive implements Packet
{
    public int id;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.id = buf.readVarIntFromBuffer();
    }

    public int getID()
    {
        return this.id;
    }
}