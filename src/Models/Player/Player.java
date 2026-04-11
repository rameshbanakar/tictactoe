package Models.Player;

import Models.Symbol;
import Models.enums.PlayerType;

public abstract class Player {
    private String id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(String id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }




}
