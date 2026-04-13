import Controller.GameController;
import Models.Game;
import Models.enums.GameStatus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        GameController gameController=new GameController();
        Game game=gameController.StartGame(size);

        while(gameController.getStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.display(game);
            gameController.makeMove(game);
            System.out.println("Game status");
            break;
        }
        if(gameController.getStatus(game).equals(GameStatus.COMPLETED)){
            System.out.println("Winner");
        }else{
            System.out.println("Game Drawn");
        }
    }
}