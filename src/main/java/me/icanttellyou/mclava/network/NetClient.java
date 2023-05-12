package me.icanttellyou.mclava.network;

import com.sun.tools.javac.Main;
import me.icanttellyou.mclava.Delegate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
public class NetClient {
    public static final int PROTOCOL_VERSION = 7;
    public static final boolean USE_CPE = true; //= Main.config.cpeEnabled;
    public boolean isConnected;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Thread readThread;
    public Delegate disconnected = Delegate.empty;
    public Delegate receivedPacket = Delegate.empty;
    private Object sendLock = new Object();

    public NetClient() {
    }

    public void TODODODOODODAAAA(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            this.isConnected = true;

            this.inputStream = new DataInputStream(this.socket.getInputStream());
            this.outputStream = new DataOutputStream(this.socket.getOutputStream());
            this.readThread = new Thread(this::readThread_Func, "Socket Read Thread");
            this.readThread.start();
        } catch (Exception ex) {
            this.disconnect(null);
//            Main.logger.error("!!! Unable to asagdfdfg: ", ex);
        }
    }

    public void disconnect(String reason) {
        disconnect(reason, null);
    }

    public void disconnect(String reason, Exception e) {
//        Main.logger.error(reason);
        if (e != null) e.printStackTrace();

        if (this.inputStream != null) {
            try {
                this.inputStream.close();
            } catch (Exception ignored) {
            }
        }

        if (this.outputStream != null) {
            try {
                this.outputStream.close();
            } catch (Exception ignored) {
            }
        }

        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (Exception ignored) {
            }
        }

        this.socket = null;
        this.inputStream = null;
        this.outputStream = null;
        this.readThread = null;

        if (this.isConnected) {
            this.disconnected.call(reason);
        }
        this.isConnected = false;
    }

    public boolean getConnectionStatus() {
        return this.isConnected;
    }

    private void readThread_Func() {
        while (this.isConnected) {
            try {
                int packetID = this.inputStream.read();
//                logger.debug("got packet id %d", packetID);
                Packet packet = Packet.idToClassMap.containsKey(packetID) ?
                        Packet.idToClassMap.get(packetID).getDeclaredConstructor().newInstance() : null;

                if (packetID != -1) {
                    if (packet != null) {
                        packet.readPacket(this.inputStream);
                        this.receivedPacket.call(packet);
                    } else {
                        throw new SocketException("Received invalid packet -> " + packetID);
                    }
                } else {
                    throw new SocketException("Server disconnect");
                }
            } catch (Exception ex) {
                if (!(ex instanceof IOException || ex instanceof SocketException)) {
                    this.disconnect("Internal error -> " + ex.getMessage());
                } else {
                    this.disconnect(ex.getMessage());
                }
                return;
            }
        }
    }

    public void sendPacket(Packet packet) {
        if (!this.isConnected) return;

        try {
            synchronized (this.sendLock) {
                this.outputStream.writeInt(packet.getID());
                packet.writePacket(this.outputStream);
                this.outputStream.flush();
            }
        } catch (Exception ex) {
            this.disconnect(String.format("Internal error (%s)", ex.getMessage()));
//            Main.logger.throwable(ex);
        }
    }
}
