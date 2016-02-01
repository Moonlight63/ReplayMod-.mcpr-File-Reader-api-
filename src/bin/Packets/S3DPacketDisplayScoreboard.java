package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S3DPacketDisplayScoreboard implements Packet
{
	public int position;
	public String scoreName;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.position = buf.readByte();
        this.scoreName = buf.readStringFromBuffer(16);
    }

    public int func_149371_c()
    {
        return this.position;
    }

    public String func_149370_d()
    {
        return this.scoreName;
    }
}