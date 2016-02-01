package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;
import bin.Vec4b;

public class S34PacketMaps implements Packet
{
    public int mapId;
    public byte mapScale;
    public Vec4b[] mapVisiblePlayersVec4b;
    public int mapMinX;
    public int mapMinY;
    public int mapMaxX;
    public int mapMaxY;
    public byte[] mapDataBytes;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.mapId = buf.readVarIntFromBuffer();
        this.mapScale = buf.readByte();
        this.mapVisiblePlayersVec4b = new Vec4b[buf.readVarIntFromBuffer()];

        for (int i = 0; i < this.mapVisiblePlayersVec4b.length; ++i)
        {
            short short1 = (short)buf.readByte();
            this.mapVisiblePlayersVec4b[i] = new Vec4b((byte)(short1 >> 4 & 15), buf.readByte(), buf.readByte(), (byte)(short1 & 15));
        }

        this.mapMaxX = buf.readUnsignedByte();

        if (this.mapMaxX > 0)
        {
            this.mapMaxY = buf.readUnsignedByte();
            this.mapMinX = buf.readUnsignedByte();
            this.mapMinY = buf.readUnsignedByte();
            this.mapDataBytes = buf.readByteArray();
        }
    }

    public int getMapId()
    {
        return this.mapId;
    }

}