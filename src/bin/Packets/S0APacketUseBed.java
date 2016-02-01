package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

public class S0APacketUseBed implements Packet
{
	public int playerID;
    /** Block location of the head part of the bed */
	public BlockPos bedPos;


    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.playerID = buf.readVarIntFromBuffer();
        this.bedPos = buf.readBlockPos();
    }

    public int getPlayer()
    {
        return this.playerID;
    }

    public BlockPos getBedPosition()
    {
        return this.bedPos;
    }
}