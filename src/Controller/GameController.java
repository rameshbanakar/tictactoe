package Controller;

import Models.Game;
public class GameController {
    public Game getGame(int size){
        return new Game(size);
    }
}
