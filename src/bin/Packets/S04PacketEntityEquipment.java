package bin.Packets;

import java.io.IOException;

import bin.ItemStack;
import bin.Packet;
import bin.PacketBuffer;

public class S04PacketEntityEquipment implements Packet
{
	public int entityID;
	public int equipmentSlot;
	public ItemStack itemStack;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityID = buf.readVarIntFromBuffer();
        this.equipmentSlot = buf.readShort();
        this.itemStack = buf.readItemStackFromBuffer();
    }

    public ItemStack getItemStack()
    {
        return this.itemStack;
    }

    public int getEntityID()
    {
        return this.entityID;
    }

    public int getEquipmentSlot()
    {
        return this.equipmentSlot;
    }
}