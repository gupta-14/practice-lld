package LLD.SnakeAndLadder.SnakeAndLadder;

import java.util.List;
import java.util.Map;

class Game {
    private String gameId;
    private int boardSize;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private List<Player> players;
    private boolean isEnded;
    private int currentPlayerIndex;
    private boolean isDiceHeld;

    public Game(String gameId, int boardSize, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players) {
        this.gameId = gameId;
        this.boardSize = boardSize;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        this.isEnded = false;
        this.currentPlayerIndex = 0;
        this.isDiceHeld = false;

    }

    public String getGameId() {
        return gameId;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void endGame() {
        this.isEnded = true;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void nextPlayer() {
        this.currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public boolean isDiceHeld() {
        return isDiceHeld;
    }

    public void setDiceHeld(boolean diceHeld) {
        isDiceHeld = diceHeld;
    }
}