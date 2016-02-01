package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S07PacketRespawn implements Packet
{
	public int dimensionID;
	public short difficulty;
	public int gameType;
	public String worldType;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.dimensionID = buf.readInt();
        this.difficulty = buf.readUnsignedByte();
        this.gameType = buf.readUnsignedByte();
        this.worldType = buf.readStringFromBuffer(16);

        if (this.worldType == null)
        {
            this.worldType = "DEFAULT";
        }
    }

 
    public int getDimensionID()
    {
        return this.dimensionID;
    }

    public short getDifficulty()
    {
        return this.difficulty;
    }

    public int getGameType()
    {
        return this.gameType;
    }

    public String getWorldType()
    {
        return this.worldType;
    }
}