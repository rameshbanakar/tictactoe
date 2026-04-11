package Models;

import Models.Player.Player;
import Models.enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Player winner;
    private int nextMove;

    public Game(int  size) {
        this.board = new Board(size);
        this.players = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winner = null;
        this.nextMove = 0;
    }
}
