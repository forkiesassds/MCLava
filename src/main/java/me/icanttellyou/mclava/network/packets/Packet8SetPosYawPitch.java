package me.icanttellyou.mclava.network.packets;

import me.icanttellyou.mclava.network.NetHandler;
import me.icanttellyou.mclava.network.Packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet8SetPosYawPitch implements Packet {
    public int id;
    public float x, y, z;
    public int yaw, pitch;

    @SuppressWarnings("unused")
    public Packet8SetPosYawPitch() {}

    @SuppressWarnings("unused")
    public Packet8SetPosYawPitch(float X, float Y, float Z, int pYaw, int pPitch) {
        x = X;
        y = Y;
        z = Z;
        yaw = pYaw;
        pitch = pPitch;
    }

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        id = stream.readByte();
        x = (float) stream.readShort() / 32;
        y = (float) stream.readShort() / 32;
        z = (float) stream.readShort() / 32;
        yaw = stream.readUnsignedByte();
        pitch = stream.readUnsignedByte();
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
        stream.writeByte(-1);
        stream.writeShort((short)(x * 32));
        stream.writeShort((short)(y * 32));
        stream.writeShort((short)(z * 32));
        stream.writeByte(yaw);
        stream.writeByte(pitch);
    }

    @Override
    public void packetReceived(NetHandler handler) {
        //TODO: proper event handling
        //TODO: proper tracking of players
    }
}
