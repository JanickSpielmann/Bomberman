package network.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import network.Message;

public class ServerProxyImpl extends ServerProxy {

    private Socket socket;
    private ObjectOutputStream toServer;
    private String hostName;
    private int port;

    public ServerProxyImpl(ClientApplicationInterface ci) {
        super(ci);
        hostName = "192.168.xxx.xxx"; // IP address of the server
        port = 8080;
        try {
            socket = new Socket(hostName, port);
            toServer = new ObjectOutputStream(socket.getOutputStream());
            new Listener(socket, ci).start();
        } catch (IOException e) {
            System.err.println("Seems no Server is running");
        }

    }

    @Override
    public void send(Message message) {
        try {
            toServer.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
