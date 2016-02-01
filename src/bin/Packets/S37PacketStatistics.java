package bin.Packets;

import java.io.IOException;
import java.util.Map;

import bin.Packet;
import bin.PacketBuffer;

import com.google.common.collect.Maps;

public class S37PacketStatistics implements Packet
{
	public Map<String, Integer> field_148976_a;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        int i = buf.readVarIntFromBuffer();
        this.field_148976_a = Maps.<String, Integer>newHashMap();

        for (int j = 0; j < i; ++j)
        {
            String statbase = (buf.readStringFromBuffer(32767));
            int k = buf.readVarIntFromBuffer();

            if (statbase != null)
            {
                this.field_148976_a.put(statbase, Integer.valueOf(k));
            }
        }
    }

    public Map<String, Integer> func_148974_c()
    {
        return this.field_148976_a;
    }
}