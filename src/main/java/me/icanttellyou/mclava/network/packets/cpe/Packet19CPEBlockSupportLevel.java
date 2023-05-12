package me.icanttellyou.mclava.network.packets.cpe;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet19CPEBlockSupportLevel implements Packet {
    public int supportLevel;

    @SuppressWarnings("unused")
    public Packet19CPEBlockSupportLevel() {}

    public Packet19CPEBlockSupportLevel(int level) {
        supportLevel = level;
    }

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        supportLevel = stream.readUnsignedByte();
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
        stream.writeByte(supportLevel);
    }

    @Override
    public void packetReceived(NetHandler client) throws IOException {
        //TODO
    }
}
