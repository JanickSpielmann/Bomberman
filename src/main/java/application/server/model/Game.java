package application.server.model;

import application.server.labyrinth.Labyrinth;
import application.server.labyrinth.tile.TileType;
import protocol.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static final int NB_OF_PLAYERS = 4;
    private List<Player> players = new ArrayList<Player>();

    private Labyrinth labyrinth;
    private boolean isRunning = false;

    public Game(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    public boolean numberOfPlayersComplete() {
        return players.size() == NB_OF_PLAYERS;
    }

    public boolean isUnique(String playerName) {
        for (Player player : players) {
            if (player.isYourName(playerName)) {
                return false;
            }
        }
        return true;
    }

    public Player createPlayer(String playerName, String connectionId) {
        Player player = new Player(playerName, connectionId, getRandomPosition());
        players.add(player);
        return player;
    }

    private int[] getRandomPosition() {
        Random random = new Random();
        return new int[] { random.nextInt(1, labyrinth.getWidth() + 1), random.nextInt(1, labyrinth.getHeight() + 1) };
    }

    public boolean isMovePossible(String playerName, Direction direction) {

        return switch (direction) {
            case UP -> labyrinth.isTileEmpty(getPlayerByName(playerName).getX(),
                    getPlayerByName(playerName).getY() - 1);
            case DOWN -> labyrinth.isTileEmpty(getPlayerByName(playerName).getX(),
                    getPlayerByName(playerName).getY() + 1);
            case LEFT -> labyrinth.isTileEmpty(getPlayerByName(playerName).getX() - 1,
                    getPlayerByName(playerName).getY());
            case RIGHT -> labyrinth.isTileEmpty(getPlayerByName(playerName).getX() + 1,
                    getPlayerByName(playerName).getY());
        };
    }

    public void movePlayer(String playerName, Direction direction) {
        switch (direction) {
            case UP -> getPlayerByName(playerName).setY(getPlayerByName(playerName).getY() - 1);
            case DOWN -> getPlayerByName(playerName).setY(getPlayerByName(playerName).getY() + 1);
            case LEFT -> getPlayerByName(playerName).setX(getPlayerByName(playerName).getX() - 1);
            case RIGHT -> getPlayerByName(playerName).setX(getPlayerByName(playerName).getX() + 1);
        }
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public List<Player> getPlayers() {
        return players;
    }

    private Player getPlayerByName(String playerName) {
        for (Player player : players) {
            if (player.isYourName(playerName)) {
                return player;
            }
        }
        return null;
    }
}
