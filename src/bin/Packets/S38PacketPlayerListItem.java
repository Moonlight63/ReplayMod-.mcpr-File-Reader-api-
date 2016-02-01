package bin.Packets;

import bin.Packet;
import bin.PacketBuffer;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class S38PacketPlayerListItem implements Packet
{
	public S38PacketPlayerListItem.Action action;
	public final List<S38PacketPlayerListItem.AddPlayerData> players = Lists.<S38PacketPlayerListItem.AddPlayerData>newArrayList();

    /**
     * Reads the raw packet data from the data stream.
     */
    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.action = (S38PacketPlayerListItem.Action)buf.readEnumValue(S38PacketPlayerListItem.Action.class);
        int i = buf.readVarIntFromBuffer();

        for (int j = 0; j < i; ++j)
        {
            GameProfile gameprofile = null;
            int k = 0;
            int worldsettings$gametype = 0;
            String ichatcomponent = null;

            switch (this.action)
            {
                case ADD_PLAYER:
                    gameprofile = new GameProfile(buf.readUuid(), buf.readStringFromBuffer(16));
                    int l = buf.readVarIntFromBuffer();
                    int i1 = 0;

                    for (; i1 < l; ++i1)
                    {
                        String s = buf.readStringFromBuffer(32767);
                        String s1 = buf.readStringFromBuffer(32767);

                        if (buf.readBoolean())
                        {
                            gameprofile.getProperties().put(s, new Property(s, s1, buf.readStringFromBuffer(32767)));
                        }
                        else
                        {
                            gameprofile.getProperties().put(s, new Property(s, s1));
                        }
                    }

                    worldsettings$gametype = (buf.readVarIntFromBuffer());
                    k = buf.readVarIntFromBuffer();

                    if (buf.readBoolean())
                    {
                        ichatcomponent = buf.readStringFromBuffer(32767);
                    }

                    break;
                case UPDATE_GAME_MODE:
                    gameprofile = new GameProfile(buf.readUuid(), (String)null);
                    worldsettings$gametype = buf.readVarIntFromBuffer();
                    break;
                case UPDATE_LATENCY:
                    gameprofile = new GameProfile(buf.readUuid(), (String)null);
                    k = buf.readVarIntFromBuffer();
                    break;
                case UPDATE_DISPLAY_NAME:
                    gameprofile = new GameProfile(buf.readUuid(), (String)null);

                    if (buf.readBoolean())
                    {
                        ichatcomponent = buf.readStringFromBuffer(32767);
                    }

                    break;
                case REMOVE_PLAYER:
                    gameprofile = new GameProfile(buf.readUuid(), (String)null);
            }

            this.players.add(new S38PacketPlayerListItem.AddPlayerData(gameprofile, k, worldsettings$gametype, ichatcomponent));
        }
    }

    public List<S38PacketPlayerListItem.AddPlayerData> func_179767_a()
    {
        return this.players;
    }

    public S38PacketPlayerListItem.Action func_179768_b()
    {
        return this.action;
    }

    public String toString()
    {
        return Objects.toStringHelper(this).add("action", this.action).add("entries", this.players).toString();
    }
    
    public class GameProfile{
    	public UUID uuid;
    	public String name;
    	
    	public Map<String, Property> props;
    	public GameProfile(UUID uuid, String name){
    		this.uuid = uuid;
    		this.name = name;
    		this.props = Maps.newHashMap();
    	}
    	
    	public Map<String, Property> getProperties(){
			return props;
    	}
    	
    	
    }
    
    public class Property {
			public String s1;
			public String s2;
			public String value;
			public Property(String s, String ss, String v){
				this.s1 = s;
				this.s2 = ss;
				this.value = v;
			}
			
			public Property(String s, String ss){
				this.s1 = s;
				this.s2 = ss;
				this.value = "";
			}
		}

    public static enum Action
    {
        ADD_PLAYER,
        UPDATE_GAME_MODE,
        UPDATE_LATENCY,
        UPDATE_DISPLAY_NAME,
        REMOVE_PLAYER;
    }

    public class AddPlayerData
    {
        public final int ping;
        public final int gamemode;
        public final GameProfile profile;
        public final String displayName;

        public AddPlayerData(GameProfile profile, int pingIn, int gamemodeIn, String displayNameIn)
        {
            this.profile = profile;
            this.ping = pingIn;
            this.gamemode = gamemodeIn;
            this.displayName = displayNameIn;
        }

        public GameProfile getProfile()
        {
            return this.profile;
        }

        public int getPing()
        {
            return this.ping;
        }

        public int getGameMode()
        {
            return this.gamemode;
        }

        public String getDisplayName()
        {
            return this.displayName;
        }

        public String toString()
        {
            return Objects.toStringHelper(this).add("latency", this.ping).add("gameMode", this.gamemode).add("profile", this.profile).add("displayName", this.displayName == null ? null : this.displayName).toString();
        }
    }
}