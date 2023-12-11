package application.server.model;

import network.Message;
import protocol.server2client.PlayerJoined;

public class Player {
    private String name;
    private int x, y;

    public Player(String playerName, int pos) {
        name = playerName;
        switch (pos) {
            case 0 -> {
                x = 0;
                y = 0;
            }
            case 1 -> {
                x = 0;
                y = 1;
            }
            case 2 -> {
                x = 1;
                y = 0;
            }
            case 3 -> {
                x = 1;
                y = 1;
            }
            default -> {
            }
        }
    }

    public boolean isYourName(String playerName) {
        return name.equals(playerName);
    }

    public Message createPlayerJoined() {
        return new PlayerJoined(name, x, y);
    }
}
