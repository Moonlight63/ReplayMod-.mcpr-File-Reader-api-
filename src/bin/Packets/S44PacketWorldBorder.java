package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S44PacketWorldBorder implements Packet
{
	public S44PacketWorldBorder.Action action;
	public int size;
	public double centerX;
	public double centerZ;
	public double targetSize;
	public double diameter;
	public long timeUntilTarget;
	public int warningTime;
	public int warningDistance;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.action = (S44PacketWorldBorder.Action)buf.readEnumValue(S44PacketWorldBorder.Action.class);

        switch (this.action)
        {
            case SET_SIZE:
                this.targetSize = buf.readDouble();
                break;
            case LERP_SIZE:
                this.diameter = buf.readDouble();
                this.targetSize = buf.readDouble();
                this.timeUntilTarget = buf.readVarLong();
                break;
            case SET_CENTER:
                this.centerX = buf.readDouble();
                this.centerZ = buf.readDouble();
                break;
            case SET_WARNING_BLOCKS:
                this.warningDistance = buf.readVarIntFromBuffer();
                break;
            case SET_WARNING_TIME:
                this.warningTime = buf.readVarIntFromBuffer();
                break;
            case INITIALIZE:
                this.centerX = buf.readDouble();
                this.centerZ = buf.readDouble();
                this.diameter = buf.readDouble();
                this.targetSize = buf.readDouble();
                this.timeUntilTarget = buf.readVarLong();
                this.size = buf.readVarIntFromBuffer();
                this.warningDistance = buf.readVarIntFromBuffer();
                this.warningTime = buf.readVarIntFromBuffer();
        }
    }

    public static enum Action
    {
        SET_SIZE,
        LERP_SIZE,
        SET_CENTER,
        INITIALIZE,
        SET_WARNING_TIME,
        SET_WARNING_BLOCKS;
    }
}