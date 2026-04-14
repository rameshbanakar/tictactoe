package Controller;

import Models.Game;
import Models.Player.Player;
import Models.enums.GameStatus;
import Statergies.WinningStatergies;

import java.util.List;

public class GameController {
    public Game StartGame(int size){
        return new Game(size);
    }

    public void display(Game game){
        game.getBoard().displayBoard();
    }
    public GameStatus getStatus(Game game){
        return game.getGameStatus();
    }
    public void makeMove(Game game){
        game.makeMove();
    }

    public void addPlayers(Game game, List<Player> player) {
        game.setPlayers(player);
    }

    public void addWinningStatergy(Game game, List<WinningStatergies> wins) {
        game.setWinningStatergies(wins);
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
