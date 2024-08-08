package LLD.SnakeAndLadder.SnakeAndLadder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderGameService implements GameApplication {

    private Map<String, Game> games = new HashMap<>();

    /*
    return unique game id
    */
    @Override
    public String createGame(int boardSize, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Integer> playerIds) {
        String gameId = Utils.generateId();
        List<Player> players = new ArrayList<>();
        for (int playerId : playerIds) {
            players.add(new Player(playerId));
        }
        Game game = new Game(gameId, boardSize, snakes, ladders, players);
        games.put(gameId, game);
        return gameId;
    }

    /*
    return false
        - if player not part of this game
        - if the game is already ended
        - if the game id doesn't exist
        - if dice already allocated
    return true if hold dice is succeeded
    */
    @Override
    public Boolean holdDice(String gameId, int playerId) {
        Game game = games.get(gameId);

        if (game == null || game.isEnded()) return false;
        Player currentPlayer = game.getPlayers().get(game.getCurrentPlayerIndex());

        if (currentPlayer.getPlayerId() != playerId || game.isDiceHeld()){
            return false;
        }

        game.setDiceHeld(true);
        return true;
    }

    /*
    return false
        - if any player who doesn't hold the dice calls this
        - if dice is not allocated
        - if the game is already ended
        - if the game id doesn't exist
    otherwise roll dice and move and return true
    */
    @Override
    public Boolean rollDiceAndMove(String gameId, int playerId) {
        Game game = games.get(gameId);

        if (game == null || game.isEnded()) return false;
        Player currentPlayer = game.getPlayers().get(game.getCurrentPlayerIndex());

        if (currentPlayer.getPlayerId() != playerId || !game.isDiceHeld()){
            return false;
        }

        int diceRoll = Utils.generateRandomNumber(1, 6);
        int newPosition = currentPlayer.getPosition() + diceRoll;

        // Check newPosition is valid
        if (newPosition > game.getBoardSize() * game.getBoardSize()) {
            game.nextPlayer();
            game.setDiceHeld(false);
            return true;
        }

        // Check for snake or ladder
        if (game.getSnakes().containsKey(newPosition)) {
            newPosition = game.getSnakes().get(newPosition);
        } else if (game.getLadders().containsKey(newPosition)) {
            newPosition = game.getLadders().get(newPosition);
        }

        currentPlayer.setPosition(newPosition);

        // Check if player has won
        if (newPosition == game.getBoardSize() * game.getBoardSize()) {
            game.endGame();
        }

        game.nextPlayer();
        game.setDiceHeld(false);
        return true;
    }
}