package Statergies;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Player.Player;
import Models.enums.CellStatus;

import java.util.List;
import java.util.Random;

public class MediumBotMove implements BotMovingStats {
    private int size;

    public MediumBotMove(int size) {
        this.size = size;
    }
    @Override
    public Move makeMove(Board board, Player player) {
        Random rand = new Random();
        List<List<Cell>> cells = board.getCell();
        int totalSize = this.size * this.size;
        int count = 0;
        while (count < totalSize) {
            int row = rand.nextInt(this.size);
            int col = rand.nextInt(this.size);
            Cell cell = cells.get(row).get(col);
            if (cell.getCellStatus().equals(CellStatus.EMPTY)) {
                return new Move(player, cell);
            }
            count++;
        }
        return null;
    }
}
