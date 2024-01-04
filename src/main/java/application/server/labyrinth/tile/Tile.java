package application.server.labyrinth.tile;


public class Tile {

    private TileType type;

    private TileOccupation occupation;

    public Tile() {
        this.type = TileType.FREE;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public TileOccupation getOccupation() {
        return occupation;
    }

    public void setOccupation(TileOccupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "" + this.type.value;
    }

    public boolean isEmpty() {
        return this.type == TileType.FREE && this.occupation == null;
    }
}
