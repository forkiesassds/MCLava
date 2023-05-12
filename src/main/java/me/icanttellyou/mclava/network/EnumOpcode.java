package me.icanttellyou.mclava.network;

import me.icanttellyou.mclava.network.packets.*;
import me.icanttellyou.mclava.network.packets.cpe.*;

public enum EnumOpcode {
    ID(0x00, true, true, Packet0Identification.class),
    PING(0x01, false, true, Packet1Ping.class),
    LEVEL_INIT(0x02, false, true, Packet2LevelInit.class),
    LEVEL_CHUNK(0x03, false, true, Packet3LevelChunk.class),
    LEVEL_FINISH(0x04, false, true, Packet4LevelFinish.class),
    SET_BLOCK(0x05, true, false, Packet5PlaceBlock.class),
    SET_CLIENT_BLOCK(0x06, false, true, Packet6SetBlock.class),
    SPAWN_PLAYER(0x07, false, true, Packet7SpawnPlayer.class),
    SET_POS_YAW_PITCH(0x08, true, true, Packet8SetPosYawPitch.class),
    POS_YAW_PITCH_UPDATE(0x09, false, true, Packet9PosYawPitchUpdate.class),
    POS_UPDATE(0x0a, false, true, Packet10PosUpdate.class),
    YAW_PITCH_UPDATE(0x0b, false, true, Packet11YawPitchUpdate.class),
    REMOVE_PLAYER(0x0c, false, true, Packet12RemovePlayer.class),
    MESSAGE(0x0d, true, true, Packet13Message.class),
    KICK_PLAYER(0x0e, false, true, Packet14KickPlayer.class),
    UPDATE_OP_STATUS(0x0f, false, true, Packet15UpdateOPStatus.class),
    CPE_EXT_INFO(0x10, true, true, Packet16CPEExtInfo.class),
    CPE_EXT_ENTRY(0x11, true, true, Packet17CPEExtEntry.class),
    CPE_SET_CLICK_DISTANCE(0x12, false, true, null),
    CPE_CUSTOM_BLOCK_SUPPORT_LEVEL(0x13, true, true, Packet19CPEBlockSupportLevel.class),
    CPE_HOLD_THIS(0x14, false, true, null),
    CPE_SET_TEXT_HOTKEY(0x15, false, true, null),
    CPE_EXT_ADD_PLAYER_NAME(0x16, false, true, null),
    CPE_EXT_ADD_ENTITY_LEGACY(0x17, false, true, null),
    CPE_EXT_REMOVE_PLAYER_NAME(0x18, false, true, null),
    CPE_ENV_SET_COLOR(0x19, false, true, null),
    CPE_MAKE_SELECTION(0x1a, false, true, null),
    CPE_REMOVE_SELECTION(0x1b, false, true, null),
    CPE_SET_BLOCK_PERMISSION(0x1c, false, true, null),
    CPE_CHANGE_MODEL(0x1d, false, true, null),
    CPE_ENV_SET_MAP_APPEARANCE_LEGACY(0x1e, false, true, null),
    CPE_ENV_WEATHER_TYPE(0x1f, false, true, null),
    CPE_HACK_CONTROL(0x20, false, true, null),
    CPE_EXT_ADD_ENTITY_2(0x21, false, true, null),
    CPE_PLAYER_CLICKED(0x22, true, false, null),
    CPE_DEFINE_BLOCK(0x23, false, true, null),
    CPE_REMOVE_BLOCK_DEFINITION(0x24, false, true, null),
    CPE_DEFINE_BLOCK_EXT(0x25, false, true, null),
    CPE_BULK_BLOCK_UPDATE(0x26, false, true, Packet38CPEBulkBlockUpdate.class),
    CPE_SET_TEXT_COLOR(0x27, false, true, Packet39CPESetTextColor.class),
    CPE_SET_MAP_ENV_URL(0x28, false, true, null),
    CPE_SET_MAP_ENV_PROPERTY(0x29, false, true, null),
    CPE_SET_ENTITY_PROPERTY(0x2a, false, true, null),
    CPE_TWO_WAY_PING(0x2b, true, true, Packet43CPETwoWayPing.class),
    CPE_SET_INVENTORY_ORDER(0x2c, false, true, null),
    CPE_SET_HOTBAR(0x2d, false, true, null),
    CPE_SET_SPAWNPOINT(0x2e, false, true, null),
    CPE_VELOCITY_CONTROL(0x2f, false, true, null),
    CPE_DEFINE_EFFECT(0x30, false, true, null),
    CPE_SPAWN_EFFECT(0x31, false, true, null),
    CPE_DEFINE_MODEL(0x32, false, true, null),
    CPE_DEFINE_MODEL_PART(0x33, false, true, null),
    CPE_UNDEFINE_MODEL(0x34, false, true, null),
    CPE_PLUGIN_MESSAGE(0x35, true, true, Packet53CPEPluginMessage.class),
    CPE_EXT_ENTITY_TELEPORT(0x36, false, true, null);

    public final int packetID;
    public final boolean isClientToServer;
    public final boolean isServerToClient;
    public final Class<? extends Packet> packetClass;

    EnumOpcode(int pID, boolean cTos, boolean sToc, Class<? extends Packet> clazz) {
        packetID = pID;
        isClientToServer = cTos;
        isServerToClient = sToc;
        packetClass = clazz;

        Packet.classToIdMap.put(clazz, pID);
        Packet.idToClassMap.put(pID, clazz);
    }
}
