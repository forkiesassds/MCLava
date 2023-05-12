package me.icanttellyou.mclava.network.packets;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet6SetBlock implements Packet {
    public short x, y, z;
    public byte blockID;

    public Packet6SetBlock() {}

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        x = stream.readShort();
        y = stream.readShort();
        z = stream.readShort();
        blockID = stream.readByte();
    }

    @Override
    public void writePacket(DataOutputStream stream) {
    }

    @Override
    public void packetReceived(NetHandler handler) {
    }
}
