package Models;

import Models.Player.Player;
import Models.enums.GameStatus;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;

    private List<Move> moves;
    private GameStatus gameStatus;
    private Player winner;
    private int nextMove;

}
