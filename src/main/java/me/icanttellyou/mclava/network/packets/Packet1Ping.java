package me.icanttellyou.mclava.network.packets;

import me.icanttellyou.mclava.network.Packet;
import me.icanttellyou.mclava.network.NetHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Packet1Ping implements Packet {
    public Packet1Ping() {}

    @Override
    public void readPacket(DataInputStream stream) {
    }

    @Override
    public void writePacket(DataOutputStream stream) {
    }

    @Override
    public void packetReceived(NetHandler handler) {
    }
}
