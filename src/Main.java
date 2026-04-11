import Controller.GameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        GameController gameController=new GameController();
        System.out.println(gameController.getGame(size));
    }
}