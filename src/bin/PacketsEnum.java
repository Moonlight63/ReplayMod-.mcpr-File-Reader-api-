package bin;

import java.util.Map;

import bin.Packets.S00PacketKeepAlive;
import bin.Packets.S01PacketJoinGame;
import bin.Packets.S02PacketChat;
import bin.Packets.S03PacketTimeUpdate;
import bin.Packets.S04PacketEntityEquipment;
import bin.Packets.S05PacketSpawnPosition;
import bin.Packets.S06PacketUpdateHealth;
import bin.Packets.S07PacketRespawn;
import bin.Packets.S08PacketPlayerPosLook;
import bin.Packets.S09PacketHeldItemChange;
import bin.Packets.S0APacketUseBed;
import bin.Packets.S0BPacketAnimation;
import bin.Packets.S0CPacketSpawnPlayer;
import bin.Packets.S0DPacketCollectItem;
import bin.Packets.S0EPacketSpawnObject;
import bin.Packets.S0FPacketSpawnMob;
import bin.Packets.S10PacketSpawnPainting;
import bin.Packets.S11PacketSpawnExperienceOrb;
import bin.Packets.S12PacketEntityVelocity;
import bin.Packets.S13PacketDestroyEntities;
import bin.Packets.S14PacketEntity;
import bin.Packets.S18PacketEntityTeleport;
import bin.Packets.S19PacketEntityHeadLook;
import bin.Packets.S19PacketEntityStatus;
import bin.Packets.S1BPacketEntityAttach;
import bin.Packets.S1CPacketEntityMetadata;
import bin.Packets.S1DPacketEntityEffect;
import bin.Packets.S1EPacketRemoveEntityEffect;
import bin.Packets.S1FPacketSetExperience;
import bin.Packets.S20PacketEntityProperties;
import bin.Packets.S21PacketChunkData;
import bin.Packets.S22PacketMultiBlockChange;
import bin.Packets.S23PacketBlockChange;
import bin.Packets.S24PacketBlockAction;
import bin.Packets.S25PacketBlockBreakAnim;
import bin.Packets.S26PacketMapChunkBulk;
import bin.Packets.S27PacketExplosion;
import bin.Packets.S28PacketEffect;
import bin.Packets.S29PacketSoundEffect;
import bin.Packets.S2APacketParticles;
import bin.Packets.S2BPacketChangeGameState;
import bin.Packets.S2CPacketSpawnGlobalEntity;
import bin.Packets.S2DPacketOpenWindow;
import bin.Packets.S2EPacketCloseWindow;
import bin.Packets.S2FPacketSetSlot;
import bin.Packets.S30PacketWindowItems;
import bin.Packets.S31PacketWindowProperty;
import bin.Packets.S32PacketConfirmTransaction;
import bin.Packets.S33PacketUpdateSign;
import bin.Packets.S34PacketMaps;
import bin.Packets.S35PacketUpdateTileEntity;
import bin.Packets.S36PacketSignEditorOpen;
import bin.Packets.S37PacketStatistics;
import bin.Packets.S38PacketPlayerListItem;
import bin.Packets.S39PacketPlayerAbilities;
import bin.Packets.S3APacketTabComplete;
import bin.Packets.S3BPacketScoreboardObjective;
import bin.Packets.S3CPacketUpdateScore;
import bin.Packets.S3DPacketDisplayScoreboard;
import bin.Packets.S3EPacketTeams;
import bin.Packets.S3FPacketCustomPayload;
import bin.Packets.S40PacketDisconnect;
import bin.Packets.S41PacketServerDifficulty;
import bin.Packets.S42PacketCombatEvent;
import bin.Packets.S43PacketCamera;
import bin.Packets.S44PacketWorldBorder;
import bin.Packets.S45PacketTitle;
import bin.Packets.S46PacketSetCompressionLevel;
import bin.Packets.S47PacketPlayerListHeaderFooter;
import bin.Packets.S48PacketResourcePackSend;
import bin.Packets.S49PacketUpdateEntityNBT;

import com.google.common.collect.Maps;


public enum PacketsEnum {
	
	CLIENTPLAY{
		{
		
			this.registerPacket(S00PacketKeepAlive.class);
		    this.registerPacket(S01PacketJoinGame.class);
		    this.registerPacket(S02PacketChat.class);
		    this.registerPacket(S03PacketTimeUpdate.class);
		    this.registerPacket(S04PacketEntityEquipment.class);
		    this.registerPacket(S05PacketSpawnPosition.class);
		    this.registerPacket(S06PacketUpdateHealth.class);
		    this.registerPacket(S07PacketRespawn.class);
		    this.registerPacket(S08PacketPlayerPosLook.class);
		    this.registerPacket(S09PacketHeldItemChange.class);
		    this.registerPacket(S0APacketUseBed.class);
		    this.registerPacket(S0BPacketAnimation.class);
		    this.registerPacket(S0CPacketSpawnPlayer.class);
		    this.registerPacket(S0DPacketCollectItem.class);
		    this.registerPacket(S0EPacketSpawnObject.class);
		    this.registerPacket(S0FPacketSpawnMob.class);
		    this.registerPacket(S10PacketSpawnPainting.class);
		    this.registerPacket(S11PacketSpawnExperienceOrb.class);
		    this.registerPacket(S12PacketEntityVelocity.class);
		    this.registerPacket(S13PacketDestroyEntities.class);
		    this.registerPacket(S14PacketEntity.class);
		    this.registerPacket(S14PacketEntity.S15PacketEntityRelMove.class);
		    this.registerPacket(S14PacketEntity.S16PacketEntityLook.class);
		    this.registerPacket(S14PacketEntity.S17PacketEntityLookMove.class);
		    this.registerPacket(S18PacketEntityTeleport.class);
		    this.registerPacket(S19PacketEntityHeadLook.class);
		    this.registerPacket(S19PacketEntityStatus.class);
		    this.registerPacket(S1BPacketEntityAttach.class);
		    this.registerPacket(S1CPacketEntityMetadata.class);
		    this.registerPacket(S1DPacketEntityEffect.class);
		    this.registerPacket(S1EPacketRemoveEntityEffect.class);
		    this.registerPacket(S1FPacketSetExperience.class);
		    this.registerPacket(S20PacketEntityProperties.class);
		    this.registerPacket(S21PacketChunkData.class);
		    this.registerPacket(S22PacketMultiBlockChange.class);
		    this.registerPacket(S23PacketBlockChange.class);
		    this.registerPacket(S24PacketBlockAction.class);
		    this.registerPacket(S25PacketBlockBreakAnim.class);
		    this.registerPacket(S26PacketMapChunkBulk.class);
		    this.registerPacket(S27PacketExplosion.class);
		    this.registerPacket(S28PacketEffect.class);
		    this.registerPacket(S29PacketSoundEffect.class);
		    this.registerPacket(S2APacketParticles.class);
		    this.registerPacket(S2BPacketChangeGameState.class);
		    this.registerPacket(S2CPacketSpawnGlobalEntity.class);
		    this.registerPacket(S2DPacketOpenWindow.class);
		    this.registerPacket(S2EPacketCloseWindow.class);
		    this.registerPacket(S2FPacketSetSlot.class);
		    this.registerPacket(S30PacketWindowItems.class);
		    this.registerPacket(S31PacketWindowProperty.class);
		    this.registerPacket(S32PacketConfirmTransaction.class);
		    this.registerPacket(S33PacketUpdateSign.class);
		    this.registerPacket(S34PacketMaps.class);
		    this.registerPacket(S35PacketUpdateTileEntity.class);
		    this.registerPacket(S36PacketSignEditorOpen.class);
		    this.registerPacket(S37PacketStatistics.class);
		    this.registerPacket(S38PacketPlayerListItem.class);
		    this.registerPacket(S39PacketPlayerAbilities.class);
		    this.registerPacket(S3APacketTabComplete.class);
		    this.registerPacket(S3BPacketScoreboardObjective.class);
		    this.registerPacket(S3CPacketUpdateScore.class);
		    this.registerPacket(S3DPacketDisplayScoreboard.class);
		    this.registerPacket(S3EPacketTeams.class);
		    this.registerPacket(S3FPacketCustomPayload.class);
		    this.registerPacket(S40PacketDisconnect.class);
		    this.registerPacket(S41PacketServerDifficulty.class);
		    this.registerPacket(S42PacketCombatEvent.class);
		    this.registerPacket(S43PacketCamera.class);
		    this.registerPacket(S44PacketWorldBorder.class);
		    this.registerPacket(S45PacketTitle.class);
		    this.registerPacket(S46PacketSetCompressionLevel.class);
		    this.registerPacket(S47PacketPlayerListHeaderFooter.class);
		    this.registerPacket(S48PacketResourcePackSend.class);
		    this.registerPacket(S49PacketUpdateEntityNBT.class);
		}
	};
	
	
	public Map<Integer, Class<? extends Packet>> allPackets = Maps.newHashMap();
	
	
	protected PacketsEnum registerPacket(Class<? extends Packet> packetClass) {
		
		if (allPackets.containsValue(packetClass))
        {
            String s = " packet " + packetClass + " is already known to ID " + allPackets.get(packetClass);
            throw new IllegalArgumentException(s);
        }
        else
        {
        	allPackets.put(Integer.valueOf(allPackets.size()), packetClass);
            return this;
        }
		
	}
	
	public Packet getPacket(int packetId) throws InstantiationException, IllegalAccessException
    {
		//return (Packet)allPackets.get(Integer.valueOf(0)).newInstance();
        Class <? extends Packet > oclass = allPackets.get(Integer.valueOf(packetId));
        return oclass == null ? null : (Packet)oclass.newInstance();
    }

}
