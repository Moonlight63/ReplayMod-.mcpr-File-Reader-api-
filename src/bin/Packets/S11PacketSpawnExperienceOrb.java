package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S11PacketSpawnExperienceOrb implements Packet
{
	public int entityID;
    public int posX;
    public int posY;
    public int posZ;
    public int xpValue;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityID = buf.readVarIntFromBuffer();
        this.posX = buf.readInt();
        this.posY = buf.readInt();
        this.posZ = buf.readInt();
        this.xpValue = buf.readShort();
    }

    public int getEntityID()
    {
        return this.entityID;
    }

    public int getX()
    {
        return this.posX;
    }

    public int getY()
    {
        return this.posY;
    }

    public int getZ()
    {
        return this.posZ;
    }

    public int getXPValue()
    {
        return this.xpValue;
    }
}