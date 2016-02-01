package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S14PacketEntity implements Packet
{
	public int entityId;
	public byte posX;
	public byte posY;
	public byte posZ;
	public byte yaw;
	public byte pitch;
	public boolean onGround;
	public boolean field_149069_g;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
    }

    public String toString()
    {
        return "Entity_" + super.toString();
    }

    public int getEntity()
    {
        return this.entityId;
    }

    public byte func_149062_c()
    {
        return this.posX;
    }

    public byte func_149061_d()
    {
        return this.posY;
    }

    public byte func_149064_e()
    {
        return this.posZ;
    }

    public byte func_149066_f()
    {
        return this.yaw;
    }

    public byte func_149063_g()
    {
        return this.pitch;
    }

    public boolean func_149060_h()
    {
        return this.field_149069_g;
    }

    public boolean getOnGround()
    {
        return this.onGround;
    }

    public static class S15PacketEntityRelMove extends S14PacketEntity
        {
            /**
             * Reads the raw packet data from the data stream.
             */
            public void readPacketData(PacketBuffer buf) throws IOException
            {
                super.readPacketData(buf);
                this.posX = buf.readByte();
                this.posY = buf.readByte();
                this.posZ = buf.readByte();
                this.onGround = buf.readBoolean();
            }

        }

    public static class S16PacketEntityLook extends S14PacketEntity
        {
           
            /**
             * Reads the raw packet data from the data stream.
             */
            public void readPacketData(PacketBuffer buf) throws IOException
            {
                super.readPacketData(buf);
                this.yaw = buf.readByte();
                this.pitch = buf.readByte();
                this.onGround = buf.readBoolean();
            }

        }

    public static class S17PacketEntityLookMove extends S14PacketEntity
        {
          
            /**
             * Reads the raw packet data from the data stream.
             */
            public void readPacketData(PacketBuffer buf) throws IOException
            {
                super.readPacketData(buf);
                this.posX = buf.readByte();
                this.posY = buf.readByte();
                this.posZ = buf.readByte();
                this.yaw = buf.readByte();
                this.pitch = buf.readByte();
                this.onGround = buf.readBoolean();
            }
            
        }
}