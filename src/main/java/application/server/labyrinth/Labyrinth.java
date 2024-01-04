package application.server.labyrinth;

import application.server.labyrinth.tile.Tile;

public class Labyrinth {

    private int width;

    private int height;

    private Tile[][] tiles;

    public Labyrinth() {
    }

    public Labyrinth(int width, int height) {
        this.tiles = new Tile[width][height];
        this.width = width;
        this.height = height;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.tiles[x][y] = new Tile();
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int x, int y) {
        return tiles[x - 1][y - 1];
    }

    public char[][] getCharMap(){
        char[][] map = new char[tiles.length][tiles[0].length];
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[0].length; y++) {
                map[x][y] = tiles[x][y].getType().value;
            }
        }
        return map;
    }

    public boolean isTileEmpty(int x, int y){
        return tiles[x][y].isEmpty();
    }
}
