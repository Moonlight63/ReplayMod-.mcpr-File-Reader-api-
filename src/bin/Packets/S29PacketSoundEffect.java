package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S29PacketSoundEffect implements Packet
{
	public String soundName;
	public int posX;
	public int posY = Integer.MAX_VALUE;
	public int posZ;
	public float soundVolume;
    public int soundPitch;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.soundName = buf.readStringFromBuffer(256);
        this.posX = buf.readInt();
        this.posY = buf.readInt();
        this.posZ = buf.readInt();
        this.soundVolume = buf.readFloat();
        this.soundPitch = buf.readUnsignedByte();
    }

    public String getSoundName()
    {
        return this.soundName;
    }

    public double getX()
    {
        return (double)((float)this.posX / 8.0F);
    }

    public double getY()
    {
        return (double)((float)this.posY / 8.0F);
    }

    public double getZ()
    {
        return (double)((float)this.posZ / 8.0F);
    }

    public float getVolume()
    {
        return this.soundVolume;
    }

    public float getPitch()
    {
        return (float)this.soundPitch / 63.0F;
    }
}