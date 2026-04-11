package Models.Player;

import Models.Symbol;
import Models.enums.PlayerType;

public class HumanPlayer extends Player{
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    public HumanPlayer(String id, String name, Symbol symbol,int age) {
        super(id, name, symbol, PlayerType.HUMAN);
        this.age=age;
    }
}
