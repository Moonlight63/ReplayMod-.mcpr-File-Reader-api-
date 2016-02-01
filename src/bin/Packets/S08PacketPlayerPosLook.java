package bin.Packets;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import bin.Packet;
import bin.PacketBuffer;

public class S08PacketPlayerPosLook implements Packet
{
	public double x;
	public double y;
	public double z;
	public float yaw;
	public float pitch;
	public Set<S08PacketPlayerPosLook.EnumFlags> field_179835_f;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
        this.yaw = buf.readFloat();
        this.pitch = buf.readFloat();
        this.field_179835_f = S08PacketPlayerPosLook.EnumFlags.func_180053_a(buf.readUnsignedByte());
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double getZ()
    {
        return this.z;
    }

    public float getYaw()
    {
        return this.yaw;
    }

    public float getPitch()
    {
        return this.pitch;
    }

    public Set<S08PacketPlayerPosLook.EnumFlags> func_179834_f()
    {
        return this.field_179835_f;
    }

    public static enum EnumFlags
    {
        X(0),
        Y(1),
        Z(2),
        Y_ROT(3),
        X_ROT(4);

        private int field_180058_f;

        private EnumFlags(int p_i45992_3_)
        {
            this.field_180058_f = p_i45992_3_;
        }

        private int func_180055_a()
        {
            return 1 << this.field_180058_f;
        }

        private boolean func_180054_b(int p_180054_1_)
        {
            return (p_180054_1_ & this.func_180055_a()) == this.func_180055_a();
        }

        public static Set<S08PacketPlayerPosLook.EnumFlags> func_180053_a(int p_180053_0_)
        {
            Set<S08PacketPlayerPosLook.EnumFlags> set = EnumSet.<S08PacketPlayerPosLook.EnumFlags>noneOf(S08PacketPlayerPosLook.EnumFlags.class);

            for (S08PacketPlayerPosLook.EnumFlags s08packetplayerposlook$enumflags : values())
            {
                if (s08packetplayerposlook$enumflags.func_180054_b(p_180053_0_))
                {
                    set.add(s08packetplayerposlook$enumflags);
                }
            }

            return set;
        }

        public static int func_180056_a(Set<S08PacketPlayerPosLook.EnumFlags> p_180056_0_)
        {
            int i = 0;

            for (S08PacketPlayerPosLook.EnumFlags s08packetplayerposlook$enumflags : p_180056_0_)
            {
                i |= s08packetplayerposlook$enumflags.func_180055_a();
            }

            return i;
        }
    }
}