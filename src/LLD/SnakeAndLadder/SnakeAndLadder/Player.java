package LLD.SnakeAndLadder.SnakeAndLadder;

class Player {
    private int playerId;
    private int position;

    public Player(int playerId) {
        this.playerId = playerId;
        this.position = 0; // Initial position is 0
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}