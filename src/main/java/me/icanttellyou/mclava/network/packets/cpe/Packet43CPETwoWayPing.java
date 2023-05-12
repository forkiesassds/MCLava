package me.icanttellyou.mclava.network.packets.cpe;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet43CPETwoWayPing implements Packet {
    public byte pingDirection;
    public short pingData;


    @SuppressWarnings("unused")
    public Packet43CPETwoWayPing() {}

    public Packet43CPETwoWayPing(byte dir, short data) {
        pingDirection = dir;
        pingData = data;
    }

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        pingDirection = stream.readByte();
        pingData = stream.readShort();
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
        stream.writeByte(pingDirection);
        stream.writeShort(pingData);
    }

    @Override
    public void packetReceived(NetHandler client) throws IOException {
        //TODO
    }
}
