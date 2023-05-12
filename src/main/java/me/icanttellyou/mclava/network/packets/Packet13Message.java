package me.icanttellyou.mclava.network.packets;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Packet13Message implements Packet {
    public byte playerID;
    public String message;

    @SuppressWarnings("unused")
    public Packet13Message() {}

    public Packet13Message(String msg, byte unusedID) {
        message = msg;
        playerID = unusedID;
    }

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        playerID = stream.readByte();
        message = Packet.readString(stream);
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
        stream.writeByte(playerID);
        stream.write(message.concat(" ".repeat(64 - message.length())).getBytes(StandardCharsets.US_ASCII));
    }

    @Override
    public void packetReceived(NetHandler client) {
        //TODO
    }
}
