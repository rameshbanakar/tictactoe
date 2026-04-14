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

    public BotPlayer(String id, String name, Symbol symbol, GameDifficulty gameDifficulty) {
        super(id, name, symbol, PlayerType.BOT);
        this.gameDifficulty = gameDifficulty;
        this.botPlayingStats = BotStatergyFactory.getBotStatergy(this.gameDifficulty);
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
