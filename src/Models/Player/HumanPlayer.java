package Models.Player;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Symbol;
import Models.enums.PlayerType;

import java.util.Scanner;

public class HumanPlayer extends Player{
    private int age;
    private Scanner scan;

    public HumanPlayer(String id, String name, Symbol symbol, int age) {
        super(id, name, symbol, PlayerType.HUMAN);
        this.age = age;
        this.scan = new Scanner(System.in);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("It's your turn " + this.getName());
        System.out.println("Enter row & col:");
        int row = this.scan.nextInt();
        int col = this.scan.nextInt();
        return new Move(this, new Cell(row, col));
    }
}
