package me.icanttellyou.mclava.network.packets;

import me.icanttellyou.mclava.network.Packet;
import me.icanttellyou.mclava.network.NetHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Packet0Identification implements Packet {
    public int pvn, isOP;
    public String serverName, serverMOTD;

    @SuppressWarnings("unused")
    public Packet0Identification() {}

    @Override
    public void readPacket(DataInputStream stream) throws IOException {
        pvn = stream.readUnsignedByte();
        serverName = Packet.readString(stream);
        serverMOTD = Packet.readString(stream);
        isOP = stream.readUnsignedByte();
    }

    @Override
    public void writePacket(DataOutputStream stream) throws IOException {
        /*
        stream.writeByte(ServerProperties.PROTOCOL_VERSION);
        stream.write(serverName.concat(" ".repeat(64 - username.length())).getBytes(StandardCharsets.US_ASCII));
        stream.write(serverMOTD.concat(" ".repeat(64 - mpPass.length())).getBytes(StandardCharsets.US_ASCII));
        stream.writeByte(Player.isOp);

         */
    }

    @Override
    public void packetReceived(NetHandler handler) {
        if (isOP == 0x42)
            handler.beginCPENegotiation();
    }
}
