package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;
import bin.nbt.NBTTagCompound;

public class S49PacketUpdateEntityNBT implements Packet
{
	public int entityId;
	public NBTTagCompound tagCompound;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.tagCompound = buf.readNBTTagCompoundFromBuffer();
    }

    public NBTTagCompound getTagCompound()
    {
        return this.tagCompound;
    }

    public int getEntity()
    {
        return (this.entityId);
    }
}