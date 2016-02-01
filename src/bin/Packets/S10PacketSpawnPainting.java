package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;

public class S10PacketSpawnPainting implements Packet
{
	public int entityID;
	public BlockPos position;
	public short facing;
	public String title;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityID = buf.readVarIntFromBuffer();
        //this.title = buf.readStringFromBuffer(EntityPainting.EnumArt.field_180001_A);
        this.position = buf.readBlockPos();
        this.facing = buf.readUnsignedByte();
    }

    public int getEntityID()
    {
        return this.entityID;
    }

    public BlockPos getPosition()
    {
        return this.position;
    }

    public short getFacing()
    {
        return this.facing;
    }

    public String getTitle()
    {
        return this.title;
    }
}