package Models.Player;

import BotStatergyFactory.BotStatergyFactory;
import Models.Board;
import Models.Move;
import Models.Symbol;
import Models.enums.GameDifficulty;
import Models.enums.PlayerType;
import Statergies.BotMovingStats;

public class BotPlayer extends Player{
    private GameDifficulty gameDifficulty;
    private BotMovingStats botPlayingStats;
    private int size;

    public BotPlayer(String id, String name, Symbol symbol, GameDifficulty gameDifficulty, int size) {
        super(id, name, symbol, PlayerType.BOT);
        this.gameDifficulty = gameDifficulty;
        this.size = size;
        this.botPlayingStats = BotStatergyFactory.getBotStatergy(this.gameDifficulty, size);
    }
    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public void setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }


    @Override
    public Move makeMove(Board board) {
        System.out.println("It's " + this.getName() + " turn to make move");
        return botPlayingStats.makeMove(board, this);
    }
}
