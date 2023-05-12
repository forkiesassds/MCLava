package me.icanttellyou.mclava.network.packets.cpe;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Packet17CPEExtEntry implements Packet {
    public String extName;
    public int extVer;

    @SuppressWarnings("unused")
    public Packet17CPEExtEntry() {}

    public Packet17CPEExtEntry(String name, int ver) {
        extName = name;
        extVer = ver;
    }

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        extName = Packet.readString(stream);
        extVer = stream.readInt();
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
        stream.write(extName.concat(" ".repeat(64 - extName.length())).getBytes(StandardCharsets.US_ASCII));
        stream.writeInt(extVer);
    }

    @Override
    public void packetReceived(NetHandler handler) throws IOException {
        //TODO
    }
}
