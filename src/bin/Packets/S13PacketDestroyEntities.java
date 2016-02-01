package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S13PacketDestroyEntities implements Packet
{
	public int[] entityIDs;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityIDs = new int[buf.readVarIntFromBuffer()];

        for (int i = 0; i < this.entityIDs.length; ++i)
        {
            this.entityIDs[i] = buf.readVarIntFromBuffer();
        }
    }

    public int[] getEntityIDs()
    {
        return this.entityIDs;
    }
}