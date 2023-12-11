package application.server.model;

import network.Message;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int NB_OF_PLAYERS = 4;
    private List<Player> players = new ArrayList<Player>();
    public boolean NBOfPlayersComplete() {
        return  players.size() == NB_OF_PLAYERS;
    }

    public boolean isUnique(String playerName) {
        for(Player player : players){
            if (player.isYourName(playerName)){
                return false;
            }
        }
        return true;
    }

    public Player createPlayer(String playerName) {
        Player player = new Player(playerName, players.size());
        players.add(player);
        return player;
    }

    public Message StartGame() {
    }
}
