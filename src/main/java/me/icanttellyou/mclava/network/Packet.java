package me.icanttellyou.mclava.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface Packet {
    Map<Class<? extends Packet>, Integer> classToIdMap = new HashMap<>();
    Map<Integer, Class<? extends Packet>> idToClassMap = new HashMap<>();

    void readPacket(DataInputStream stream) throws NotC2SPacketException, IOException;
    void writePacket(DataOutputStream stream) throws IOException;
    void packetReceived(NetHandler handler) throws NotC2SPacketException, IOException;
    default int getID() {
    	return classToIdMap.getOrDefault(this.getClass(), -1);
    }
    
    static String readString(DataInputStream stream) throws IOException {
        byte[] b = new byte[64];
        stream.readFully(b, 0, 64);
        return new String(b);
    }
}
