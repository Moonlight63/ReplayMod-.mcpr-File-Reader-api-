package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S2BPacketChangeGameState implements Packet
{
    public static final String[] MESSAGE_NAMES = new String[] {"tile.bed.notValid"};
    public int state;
    public float field_149141_c;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.state = buf.readUnsignedByte();
        this.field_149141_c = buf.readFloat();
    }

    public int getGameState()
    {
        return this.state;
    }

    public float func_149137_d()
    {
        return this.field_149141_c;
    }
}