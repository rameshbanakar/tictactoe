package Statergies;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Player.Player;
import Models.enums.CellStatus;

import java.util.List;

public class EasyBotMoving implements BotMovingStats {
    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> cells = board.getCell();
        for (List<Cell> eachRow : cells) {
            for (Cell cell : eachRow) {
                if (cell.getCellStatus().equals(CellStatus.EMPTY)) {
                    return new Move(player, cell);
                }
            }
        }
        return null;
    }
}
