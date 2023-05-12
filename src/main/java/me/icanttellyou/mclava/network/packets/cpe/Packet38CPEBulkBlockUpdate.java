package me.icanttellyou.mclava.network.packets.cpe;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet38CPEBulkBlockUpdate implements Packet {
    int count;
    byte[] indices, blocks;

    public Packet38CPEBulkBlockUpdate() {}

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        count = stream.readUnsignedByte();
        stream.readFully(indices, 0, 1024);
        stream.readFully(blocks, 0, 256);
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
    }

    @Override
    public void packetReceived(NetHandler client) throws IOException {
        //TODO
    }
}
