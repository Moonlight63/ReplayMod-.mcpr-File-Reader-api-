package bin;

import java.io.IOException;

public interface Packet {
	 /**
     * Reads the raw packet data from the data stream.
     */
    void readPacketData(PacketBuffer buf) throws IOException;

}
