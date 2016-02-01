package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S19PacketEntityHeadLook implements Packet
{
	public int entityId;
	public byte yaw;


    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.yaw = buf.readByte();
    }


    public int getEntity()
    {
        return this.entityId;
    }

    public byte getYaw()
    {
        return this.yaw;
    }
}