package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S01PacketJoinGame implements Packet
{
	public int entityId;
	public boolean hardcoreMode;
	public Integer gameType;
	public int dimension;
	public short difficulty;
	public int maxPlayers;
	public String worldType;
	public boolean reducedDebugInfo;


    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readInt();
        int i = buf.readUnsignedByte();
        this.hardcoreMode = (i & 8) == 8;
        i = i & -9;
        this.gameType = i;
        this.dimension = buf.readByte();
        this.difficulty = (buf.readUnsignedByte());
        this.maxPlayers = buf.readUnsignedByte();
        this.worldType = buf.readStringFromBuffer(16);

        if (this.worldType == null)
        {
            this.worldType = "DEFAULT";
        }

        this.reducedDebugInfo = buf.readBoolean();
    }

    public int getEntityId()
    {
        return this.entityId;
    }

    public boolean isHardcoreMode()
    {
        return this.hardcoreMode;
    }

    public int getGameType()
    {
        return this.gameType;
    }

    public int getDimension()
    {
        return this.dimension;
    }

    public short getDifficulty()
    {
        return this.difficulty;
    }

    public int getMaxPlayers()
    {
        return this.maxPlayers;
    }

    public String getWorldType()
    {
        return this.worldType;
    }

    public boolean isReducedDebugInfo()
    {
        return this.reducedDebugInfo;
    }
}