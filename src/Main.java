import Controller.GameController;
import Models.Game;
import Models.Player.HumanPlayer;
import Models.Player.Player;
import Models.Symbol;
import Models.enums.GameStatus;
import Statergies.ColumnWise;
import Statergies.RowWise;
import Statergies.WinningStatergies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size=scan.nextInt();
        GameController gameController=new GameController();
        Game game=gameController.StartGame(size);
        List<Player> playars = new ArrayList<>();
        Player player1 = new HumanPlayer("1", "Ramesh", new Symbol("X"), 26);
        Player player2 = new HumanPlayer("2", "Veeresh", new Symbol("V"), 24);
        playars.add(player1);
        playars.add(player2);
        gameController.addPlayers(game, playars);

        List<WinningStatergies> wins = new ArrayList<>();
        wins.add(new RowWise(size));
        wins.add(new ColumnWise(size));

        gameController.addWinningStatergy(game, wins);

        while(gameController.getStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.display(game);
            gameController.makeMove(game);

        }

        if(gameController.getStatus(game).equals(GameStatus.COMPLETED)){
            System.out.println("Winner");
        }else{
            System.out.println("Game Drawn");
        }
    }
}