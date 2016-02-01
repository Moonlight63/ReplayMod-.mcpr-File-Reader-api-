package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S41PacketServerDifficulty implements Packet
{
	public int difficulty;
	public boolean difficultyLocked;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.difficulty = buf.readUnsignedByte();
    }

    public boolean isDifficultyLocked()
    {
        return this.difficultyLocked;
    }

    public int getDifficulty()
    {
        return this.difficulty;
    }
}