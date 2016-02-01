package bin.Packets;

import java.io.IOException;

import bin.ItemStack;
import bin.Packet;
import bin.PacketBuffer;

public class S2FPacketSetSlot implements Packet
{
	public int windowId;
	public int slot;
	public ItemStack item;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.windowId = buf.readByte();
        this.slot = buf.readShort();
        this.item = buf.readItemStackFromBuffer();
    }

    public int func_149175_c()
    {
        return this.windowId;
    }

    public int func_149173_d()
    {
        return this.slot;
    }

    public ItemStack func_149174_e()
    {
        return this.item;
    }
}