package bin.Packets;

import java.io.IOException;

import bin.ItemStack;
import bin.Packet;
import bin.PacketBuffer;

public class S30PacketWindowItems implements Packet
{
	public int windowId;
	public ItemStack[] itemStacks;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.windowId = buf.readUnsignedByte();
        int i = buf.readShort();
        this.itemStacks = new ItemStack[i];

        for (int j = 0; j < i; ++j)
        {
            this.itemStacks[j] = buf.readItemStackFromBuffer();
        }
    }

    public int func_148911_c()
    {
        return this.windowId;
    }
    
    public ItemStack[] getItemStacks()
    {
        return this.itemStacks;
    }
}