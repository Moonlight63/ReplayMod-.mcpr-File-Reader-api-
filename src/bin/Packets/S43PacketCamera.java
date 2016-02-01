package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S43PacketCamera implements Packet
{
    public int entityId;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
    }

    public int getEntity()
    {
        return this.entityId;
    }
}