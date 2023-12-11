package application.server.control;

import network.server.Server;
import protocol.client2server.ClientMessage;

public abstract class Controller {
    Server server;

    public Controller(Server server) {
        this.server = server;
    }

    public abstract void handleMessage(ClientMessage message, String connectionId);

}
