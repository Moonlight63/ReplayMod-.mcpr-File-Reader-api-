package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S09PacketHeldItemChange implements Packet
{
	public int heldItemHotbarIndex;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.heldItemHotbarIndex = buf.readByte();
    }

    public int getHeldItemHotbarIndex()
    {
        return this.heldItemHotbarIndex;
    }
}