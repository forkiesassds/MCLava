package me.icanttellyou.mclava.network.packets.cpe;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Packet16CPEExtInfo implements Packet {
    public String softwareName;
    public short extCount;


    @SuppressWarnings("unused")
    public Packet16CPEExtInfo() {}

    public Packet16CPEExtInfo(String software, short count) {
        softwareName = software;
        extCount = count;
    }

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        softwareName = Packet.readString(stream);
        extCount = stream.readShort();
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
        stream.write(softwareName.concat(" ".repeat(64 - softwareName.length())).getBytes(StandardCharsets.US_ASCII));
        stream.writeShort(extCount);
    }

    @Override
    public void packetReceived(NetHandler handler) throws IOException {
        //TODO
    }
}
