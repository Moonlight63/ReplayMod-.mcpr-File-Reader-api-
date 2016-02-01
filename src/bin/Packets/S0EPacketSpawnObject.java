package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S0EPacketSpawnObject implements Packet
{
	public int entityId;
	public int x;
	public int y;
	public int z;
	public int speedX;
	public int speedY;
	public int speedZ;
	public int pitch;
	public int yaw;
	public int type;
	public int field_149020_k;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.type = buf.readByte();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.pitch = buf.readByte();
        this.yaw = buf.readByte();
        this.field_149020_k = buf.readInt();

        if (this.field_149020_k > 0)
        {
            this.speedX = buf.readShort();
            this.speedY = buf.readShort();
            this.speedZ = buf.readShort();
        }
    }

    public int getEntityID()
    {
        return this.entityId;
    }

    public void setX(int newX)
    {
        this.x = newX;
    }

    public int getX()
    {
        return this.x;
    }

    public void setY(int newY)
    {
        this.y = newY;
    }

    public int getY()
    {
        return this.y;
    }

    public void setZ(int newZ)
    {
        this.z = newZ;
    }

    public int getZ()
    {
        return this.z;
    }

    public void setSpeedX(int newSpeedX)
    {
        this.speedX = newSpeedX;
    }

    public int getSpeedX()
    {
        return this.speedX;
    }

    public void setSpeedY(int newSpeedY)
    {
        this.speedY = newSpeedY;
    }

    public int getSpeedY()
    {
        return this.speedY;
    }

    public void setSpeedZ(int newSpeedZ)
    {
        this.speedZ = newSpeedZ;
    }

    public int getSpeedZ()
    {
        return this.speedZ;
    }

    public int getPitch()
    {
        return this.pitch;
    }

    public int getYaw()
    {
        return this.yaw;
    }

    public int getType()
    {
        return this.type;
    }

    public int func_149009_m()
    {
        return this.field_149020_k;
    }

    public void func_149002_g(int p_149002_1_)
    {
        this.field_149020_k = p_149002_1_;
    }
}