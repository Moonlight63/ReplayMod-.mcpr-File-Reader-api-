package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S45PacketTitle implements Packet
{
	public S45PacketTitle.Type type;
    public String message;
    public int fadeInTime;
    public int displayTime;
    public int fadeOutTime;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.type = (S45PacketTitle.Type)buf.readEnumValue(S45PacketTitle.Type.class);

        if (this.type == S45PacketTitle.Type.TITLE || this.type == S45PacketTitle.Type.SUBTITLE)
        {
            this.message = buf.readStringFromBuffer(32767);
        }

        if (this.type == S45PacketTitle.Type.TIMES)
        {
            this.fadeInTime = buf.readInt();
            this.displayTime = buf.readInt();
            this.fadeOutTime = buf.readInt();
        }
    }

    public S45PacketTitle.Type getType()
    {
        return this.type;
    }

    public String getMessage()
    {
        return this.message;
    }

    public int getFadeInTime()
    {
        return this.fadeInTime;
    }

    public int getDisplayTime()
    {
        return this.displayTime;
    }

    public int getFadeOutTime()
    {
        return this.fadeOutTime;
    }

    public static enum Type
    {
        TITLE,
        SUBTITLE,
        TIMES,
        CLEAR,
        RESET;

        public static S45PacketTitle.Type byName(String name)
        {
            for (S45PacketTitle.Type s45packettitle$type : values())
            {
                if (s45packettitle$type.name().equalsIgnoreCase(name))
                {
                    return s45packettitle$type;
                }
            }

            return TITLE;
        }

        public static String[] getNames()
        {
            String[] astring = new String[values().length];
            int i = 0;

            for (S45PacketTitle.Type s45packettitle$type : values())
            {
                astring[i++] = s45packettitle$type.name().toLowerCase();
            }

            return astring;
        }
    }
}