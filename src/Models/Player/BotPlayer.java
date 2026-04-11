package Models.Player;

import Models.Symbol;
import Models.enums.GameDifficulty;
import Models.enums.PlayerType;

public class BotPlayer extends Player{
    public GameDifficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public void setGameDifficulty(GameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    private GameDifficulty gameDifficulty;
    public BotPlayer(String id, String name, Symbol symbol,GameDifficulty gameDifficulty) {
        super(id, name, symbol, PlayerType.BOT);
        this.gameDifficulty=gameDifficulty;
    }
}
