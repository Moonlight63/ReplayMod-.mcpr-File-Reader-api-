package bin;

import bin.nbt.NBTTagCompound;

public class ItemStack {

	public int itemID;
	public int amount;
	public int meta;
	public NBTTagCompound nbt;
	
	public ItemStack(int item, int count, int meta){
		this.itemID = item;
		this.amount = count;
		this.meta = meta;
		
	}
	
	public void setCompoundTag(NBTTagCompound tag){
		this.nbt = tag;
	}
}
