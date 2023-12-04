package application.server.control;

import application.server.network.MessageEntry;
import application.server.network.MessageQueue;

public class BombermanServer {

    public static void main(String[] args) {
        new BombermanServer();
    }

    private BombermanServer(){
        MessageQueue queue = new MessageQueue();
        MessageEntry entry = new MessageEntry(queue);
    }
}
