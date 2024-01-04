package application.server.model;

import network.Message;
import protocol.server2client.PlayerJoined;

public class Player {
    private String name;

    private String connectionId;
    private int x;
    private int y;

    public Player(String name, String connectionId) {
        this.name = name;
        this.connectionId = connectionId;
        x = 0;
        y = 0;
    }

    public Player(String name, String connectionId, int[] position) {
        this.name = name;
        this.connectionId = connectionId;
        this.x = position[0];
        this.y = position[1];
    }

    public boolean isYourName(String playerName) {
        return name.equals(playerName);
    }

    public Message createPlayerJoined() {
        return new PlayerJoined(name, x, y);
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
