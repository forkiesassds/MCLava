package me.icanttellyou.mclava.network.packets;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet11YawPitchUpdate implements Packet {
    public byte id;
    public int yaw, pitch;

    public Packet11YawPitchUpdate() {}

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
    }

    @Override
    public void writePacket(DataOutputStream stream) {
    }

    @Override
    public void packetReceived(NetHandler client) {
    }
}
