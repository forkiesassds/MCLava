package me.icanttellyou.mclava.network.packets.cpe;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet39CPESetTextColor implements Packet {
    public int r, g, b, a, code;

    public Packet39CPESetTextColor() {}

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        r = stream.readUnsignedByte();
        g = stream.readUnsignedByte();
        b = stream.readUnsignedByte();
        a = stream.readUnsignedByte();
        code = stream.readUnsignedByte();
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
    }

    @Override
    public void packetReceived(NetHandler client) throws IOException {
    }
}
