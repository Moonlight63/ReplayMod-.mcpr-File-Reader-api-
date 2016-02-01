package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S22PacketMultiBlockChange implements Packet
{
    //private ChunkCoordIntPair chunkPosCoord;
	public int chunkX;
	public int chunkZ;
	public S22PacketMultiBlockChange.BlockUpdateData[] changedBlocks;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
    	chunkX = buf.readInt();
    	chunkZ = buf.readInt();
        //this.chunkPosCoord = new ChunkCoordIntPair(buf.readInt(), buf.readInt());
        this.changedBlocks = new S22PacketMultiBlockChange.BlockUpdateData[buf.readVarIntFromBuffer()];

        for (int i = 0; i < this.changedBlocks.length; ++i)
        {
            this.changedBlocks[i] = new S22PacketMultiBlockChange.BlockUpdateData(buf.readShort(), buf.readVarIntFromBuffer());
        }
    }

    public S22PacketMultiBlockChange.BlockUpdateData[] getChangedBlocks()
    {
        return this.changedBlocks;
    }

    public class BlockUpdateData
    {
        /** contains the bitshifted location of the block in the chunk */
        private final short chunkPosCrammed;
        private final int blockState;
        private final int x;
        private final int y;
        private final int z;
        
        public BlockUpdateData(short p_i45984_2_, int state)
        {
            this.chunkPosCrammed = p_i45984_2_;
            this.blockState = state;
            
            this.x = this.chunkPosCrammed >> 12 & 15;
        	this.y = this.chunkPosCrammed & 255;
        	this.z = this.chunkPosCrammed >> 8 & 15;
        }

        public short func_180089_b()
        {
            return this.chunkPosCrammed;
        }

        public int getBlockState()
        {
            return this.blockState;
        }
        
        public int getX(){
        	return this.x;
        }
        public int getY(){
        	return this.y;
        }
        public int getZ(){
        	return this.z;
        }
    }
}