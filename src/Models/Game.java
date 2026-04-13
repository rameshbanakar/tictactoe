package Models;

import Models.Player.Player;
import Models.enums.CellStatus;
import Models.enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Player winner;
    private int nextPlayer;

    public Game(int  size) {
        this.board = new Board(size);
        this.players = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winner = null;
        this.nextPlayer = 0;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextMove() {
        return nextPlayer;
    }

    public void setNextMove(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public void makeMove(){
        Player currPlayer=players.get(nextPlayer);
        Move move=currPlayer.makeMove();

        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        Cell cell=board.getCell().get(row).get(col);
        cell.setPlayer(currPlayer);
        cell.setCellStatus(CellStatus.FILLED);

        moves.add(move);



    }
}
