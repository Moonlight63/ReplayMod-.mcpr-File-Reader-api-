package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S46PacketSetCompressionLevel implements Packet
{
	public int field_179761_a;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.field_179761_a = buf.readVarIntFromBuffer();
    }

    public int func_179760_a()
    {
        return this.field_179761_a;
    }
}