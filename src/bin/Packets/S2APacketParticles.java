package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S2APacketParticles implements Packet
{
	public int particleType;
	public float xCoord;
	public float yCoord;
	public float zCoord;
	public float xOffset;
	public float yOffset;
	public float zOffset;
	public float particleSpeed;
	public int particleCount;
	public boolean longDistance;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.particleType = buf.readInt();
        this.longDistance = buf.readBoolean();
        this.xCoord = buf.readFloat();
        this.yCoord = buf.readFloat();
        this.zCoord = buf.readFloat();
        this.xOffset = buf.readFloat();
        this.yOffset = buf.readFloat();
        this.zOffset = buf.readFloat();
        this.particleSpeed = buf.readFloat();
        this.particleCount = buf.readInt();
    }

    public int getParticleType()
    {
        return this.particleType;
    }

    public boolean isLongDistance()
    {
        return this.longDistance;
    }

    /**
     * Gets the x coordinate to spawn the particle.
     */
    public double getXCoordinate()
    {
        return (double)this.xCoord;
    }

    /**
     * Gets the y coordinate to spawn the particle.
     */
    public double getYCoordinate()
    {
        return (double)this.yCoord;
    }

    /**
     * Gets the z coordinate to spawn the particle.
     */
    public double getZCoordinate()
    {
        return (double)this.zCoord;
    }

    /**
     * Gets the x coordinate offset for the particle. The particle may use the offset for particle spread.
     */
    public float getXOffset()
    {
        return this.xOffset;
    }

    /**
     * Gets the y coordinate offset for the particle. The particle may use the offset for particle spread.
     */
    public float getYOffset()
    {
        return this.yOffset;
    }

    /**
     * Gets the z coordinate offset for the particle. The particle may use the offset for particle spread.
     */
    public float getZOffset()
    {
        return this.zOffset;
    }

    /**
     * Gets the speed of the particle animation (used in client side rendering).
     */
    public float getParticleSpeed()
    {
        return this.particleSpeed;
    }

    /**
     * Gets the amount of particles to spawn
     */
    public int getParticleCount()
    {
        return this.particleCount;
    }

}