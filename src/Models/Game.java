package Models;

import Models.Player.BotPlayer;
import Models.Player.Player;
import Models.enums.CellStatus;
import Models.enums.GameStatus;
import Statergies.WinningStatergies;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private Player winner;
    private int nextPlayer;
    private List<WinningStatergies> winningStatergies;

    public Game(int size, List<Player> players, List<WinningStatergies> winn) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winner = null;
        this.nextPlayer = 0;
        this.winningStatergies = winn;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public List<WinningStatergies> getWinningStatergies() {
        return winningStatergies;
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
        Move move = currPlayer.makeMove(board);

        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        Cell cell=board.getCell().get(row).get(col);
        cell.setPlayer(currPlayer);
        cell.setCellStatus(CellStatus.FILLED);

        moves.add(move);

        nextPlayer = (nextPlayer + 1) % players.size();

        if (checkWinner(move)) {
            winner = currPlayer;
            gameStatus = GameStatus.COMPLETED;
        }

        if (moves.size() == board.getSize() * board.getSize()) {
            gameStatus = GameStatus.DRAW;
        }
    }

    public boolean checkWinner(Move move) {
        for (WinningStatergies winn : winningStatergies) {
            if (winn.checkWinner(move)) {
                return true;
            }
        }
        return false;
    }

    public void setWinningStatergies(List<WinningStatergies> winningStatergies) {
        this.winningStatergies = winningStatergies;
    }

    public static class Builder {
        private int size;
        private List<Player> players;
        private List<WinningStatergies> winn;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStats(List<WinningStatergies> winn) {
            this.winn = winn;
            return this;
        }

        private boolean numberOfPlayersAndSizeOfBoard() {
            return this.size > players.size();
        }

        private boolean botPlayersValidation() {
            int count = 0;
            for (Player player : this.players) {
                if (player instanceof BotPlayer) {
                    count++;
                }
            }
            return count >= 2;
        }

        private boolean validate() {
            if (!numberOfPlayersAndSizeOfBoard()) {
                System.out.println("Number of Players should be less the board size");
                return false;
            } else if (players.size() == 1) {
                System.out.println("Single player cann't play the game");
                return false;
            } else if (botPlayersValidation()) {
                System.out.println("Single bot can be allowed in game");
                return false;
            } else {
                return true;
            }

        }

        public Game buid() {

            if (validate()) {
                return new Game(this.size, this.players, this.winn);
            }
            return null;
        }

    }
}
