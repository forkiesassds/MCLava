package me.icanttellyou.mclava.network.packets.cpe;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet53CPEPluginMessage implements Packet {
    public int channel;
    public byte[] data;

    @SuppressWarnings("unused")
    public Packet53CPEPluginMessage() {}

    @SuppressWarnings("unused")
    public Packet53CPEPluginMessage(int c, byte[] d) {
        channel = c;
        data = d;
    }

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        channel = stream.readUnsignedByte();
        stream.readFully(data, 0, 64);
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
        stream.writeByte(channel);
        stream.write(data, 0, 64);
    }

    @Override
    public void packetReceived(NetHandler client) throws IOException {
        //TODO
    }
}
