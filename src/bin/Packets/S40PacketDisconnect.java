package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S40PacketDisconnect implements Packet
{
	public String reason;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.reason = buf.readStringFromBuffer(32767);
    }

    public String getReason()
    {
        return this.reason;
    }
}