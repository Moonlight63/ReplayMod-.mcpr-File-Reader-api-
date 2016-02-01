package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S0FPacketSpawnMob implements Packet
{
	public int entityId;
	public int type;
	public int x;
	public int y;
	public int z;
	public int velocityX;
	public int velocityY;
	public int velocityZ;
	public byte yaw;
    public byte pitch;
    public byte headPitch;
//    private DataWatcher field_149043_l;
//    private List<DataWatcher.WatchableObject> watcher;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.type = buf.readByte() & 255;
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.yaw = buf.readByte();
        this.pitch = buf.readByte();
        this.headPitch = buf.readByte();
        this.velocityX = buf.readShort();
        this.velocityY = buf.readShort();
        this.velocityZ = buf.readShort();
    }

    public int getEntityID()
    {
        return this.entityId;
    }

    public int getEntityType()
    {
        return this.type;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getZ()
    {
        return this.z;
    }

    public int getVelocityX()
    {
        return this.velocityX;
    }

    public int getVelocityY()
    {
        return this.velocityY;
    }

    public int getVelocityZ()
    {
        return this.velocityZ;
    }

    public byte getYaw()
    {
        return this.yaw;
    }

    public byte getPitch()
    {
        return this.pitch;
    }

    public byte getHeadPitch()
    {
        return this.headPitch;
    }
}