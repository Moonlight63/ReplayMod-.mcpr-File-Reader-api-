package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S3CPacketUpdateScore implements Packet
{
	public String name = "";
	public String objective = "";
	public int value;
	public S3CPacketUpdateScore.Action action;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.name = buf.readStringFromBuffer(40);
        this.action = (S3CPacketUpdateScore.Action)buf.readEnumValue(S3CPacketUpdateScore.Action.class);
        this.objective = buf.readStringFromBuffer(16);

        if (this.action != S3CPacketUpdateScore.Action.REMOVE)
        {
            this.value = buf.readVarIntFromBuffer();
        }
    }

    public String getPlayerName()
    {
        return this.name;
    }

    public String getObjectiveName()
    {
        return this.objective;
    }

    public int getScoreValue()
    {
        return this.value;
    }

    public S3CPacketUpdateScore.Action getScoreAction()
    {
        return this.action;
    }

    public static enum Action
    {
        CHANGE,
        REMOVE;
    }
}