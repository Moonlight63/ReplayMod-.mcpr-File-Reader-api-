package bin.Packets;

import java.io.IOException;

import bin.BlockPos;
import bin.Packet;
import bin.PacketBuffer;
import bin.nbt.NBTTagCompound;

public class S35PacketUpdateTileEntity implements Packet
{
	public BlockPos blockPos;
    /** Used only for vanilla tile entities */
	public int metadata;
	public NBTTagCompound nbt;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.blockPos = buf.readBlockPos();
        this.metadata = buf.readUnsignedByte();
        this.nbt = buf.readNBTTagCompoundFromBuffer();
    }

    public BlockPos getPos()
    {
        return this.blockPos;
    }

    public int getTileEntityType()
    {
        return this.metadata;
    }
    
    public NBTTagCompound getNbtCompound()
    {
        return this.nbt;
    }
}