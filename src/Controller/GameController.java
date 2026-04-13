package Controller;

import Models.Game;
import Models.enums.GameStatus;

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

    }
}
