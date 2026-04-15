package BotStatergyFactory;

import Models.enums.GameDifficulty;
import Statergies.BotMovingStats;
import Statergies.EasyBotMoving;
import Statergies.HardBotMove;
import Statergies.MediumBotMove;

public class BotStatergyFactory {
    public static BotMovingStats getBotStatergy(GameDifficulty difficulty, int size) {
        if (difficulty.equals(GameDifficulty.EASY)) {
            return new EasyBotMoving();
        } else if (difficulty.equals(GameDifficulty.MEDIUM)) {
            return new MediumBotMove(size);
        } else if (difficulty.equals(GameDifficulty.HARD)) {
            return new HardBotMove();
        } else {
            return null;
        }
    }
}
