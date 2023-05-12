package me.icanttellyou.mclava.network.packets;

import me.icanttellyou.mclava.network.Packet;
import me.icanttellyou.mclava.network.NetHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet5PlaceBlock implements Packet {
    private short x, y, z;
    private byte mode, blockID;

    @SuppressWarnings("unused")
    public Packet5PlaceBlock() {}

    @SuppressWarnings("unused")
    public Packet5PlaceBlock(short X, short Y, short Z, byte m, byte ID) {
        x = X;
        y = Y;
        z = Z;
        mode = m;
        blockID = ID;
    }

    @Override
    public void readPacket(DataInputStream stream) {
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
    }

    @Override
    public void packetReceived(NetHandler handler) {
    }
}
