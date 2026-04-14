package Statergies;

import Models.Board;
import Models.Move;
import Models.Player.Player;

public interface BotMovingStats {
    Move makeMove(Board board, Player player);
}
