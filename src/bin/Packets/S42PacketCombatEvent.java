package bin.Packets;

import java.io.IOException;

import bin.Packet;
import bin.PacketBuffer;

public class S42PacketCombatEvent implements Packet
{
    public S42PacketCombatEvent.Event eventType;
    public int field_179774_b;
    public int field_179775_c;
    public int field_179772_d;
    public String deathMessage;

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.eventType = (S42PacketCombatEvent.Event)buf.readEnumValue(S42PacketCombatEvent.Event.class);

        if (this.eventType == S42PacketCombatEvent.Event.END_COMBAT)
        {
            this.field_179772_d = buf.readVarIntFromBuffer();
            this.field_179775_c = buf.readInt();
        }
        else if (this.eventType == S42PacketCombatEvent.Event.ENTITY_DIED)
        {
            this.field_179774_b = buf.readVarIntFromBuffer();
            this.field_179775_c = buf.readInt();
            this.deathMessage = buf.readStringFromBuffer(32767);
        }
    }

    public static enum Event
    {
        ENTER_COMBAT,
        END_COMBAT,
        ENTITY_DIED;
    }
}