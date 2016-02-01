package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;
public class S06PacketUpdateHealth implements Packet
{
	public float health;
	public int foodLevel;
	public float saturationLevel;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.health = buf.readFloat();
        this.foodLevel = buf.readVarIntFromBuffer();
        this.saturationLevel = buf.readFloat();
    }

    public float getHealth()
    {
        return this.health;
    }

    public int getFoodLevel()
    {
        return this.foodLevel;
    }

    public float getSaturationLevel()
    {
        return this.saturationLevel;
    }
}