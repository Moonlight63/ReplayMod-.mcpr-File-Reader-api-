package bin.Packets;

import java.io.IOException;
import java.util.UUID;

import bin.Packet;
import bin.PacketBuffer;

public class S0CPacketSpawnPlayer implements Packet
{
	public int entityId;
	public UUID playerId;
	public int x;
	public int y;
	public int z;
	public byte yaw;
	public byte pitch;
	public int currentItem;
//    private DataWatcher watcher;
//    private List<DataWatcher.WatchableObject> field_148958_j;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.entityId = buf.readVarIntFromBuffer();
        this.playerId = buf.readUuid();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.yaw = buf.readByte();
        this.pitch = buf.readByte();
        this.currentItem = buf.readShort();
//        this.field_148958_j = DataWatcher.readWatchedListFromPacketBuffer(buf);
    }

//    public List<DataWatcher.WatchableObject> func_148944_c()
//    {
//        if (this.field_148958_j == null)
//        {
//            this.field_148958_j = this.watcher.getAllWatched();
//        }
//
//        return this.field_148958_j;
//    }

    public int getEntityID()
    {
        return this.entityId;
    }

    public UUID getPlayer()
    {
        return this.playerId;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getZ()
    {
        return this.z;
    }

    public byte getYaw()
    {
        return this.yaw;
    }

    public byte getPitch()
    {
        return this.pitch;
    }

    public int getCurrentItemID()
    {
        return this.currentItem;
    }
}