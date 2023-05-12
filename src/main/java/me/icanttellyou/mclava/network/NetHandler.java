package me.icanttellyou.mclava.network;

import me.icanttellyou.mclava.Delegate;
import me.icanttellyou.mclava.network.packets.cpe.Packet16CPEExtInfo;
import me.icanttellyou.mclava.network.packets.cpe.Packet17CPEExtEntry;

import java.util.Map;

public class NetHandler {
    public NetClient client;
    public Delegate disconnected = Delegate.empty;
    public Delegate receivedPacket = args -> {
        try {
            ((Packet) args[0]).packetReceived(this);
        } catch (Exception e) {
            //TODO
//            Main.logger.error("Failed to perform received packet actions", e);
        }
    };

    public NetHandler(NetClient netClient) {
        client = netClient;
    }

    public void beginCPENegotiation() {
        /*
        client.sendPacket(new Packet16CPEExtInfo(Server.clientName, (short) Server.supportedExtensions.size()));

        for (Map.Entry<String, Integer> ext : Server.supportedExtensions.entrySet())
            client.sendPacket(new Packet17CPEExtEntry(ext.getKey(), ext.getValue()));

         */
    }
}
