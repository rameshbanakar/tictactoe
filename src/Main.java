import Controller.GameController;
import Models.Game;
import Models.Player.BotPlayer;
import Models.Player.HumanPlayer;
import Models.Player.Player;
import Models.Symbol;
import Models.enums.GameDifficulty;
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
        Player player2 = new BotPlayer("2", "Botty", new Symbol("V"), GameDifficulty.EASY);
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
            gameController.display(game);
            System.out.println(gameController.getWinner(game).getName() + " is the Winner!");
            System.out.println("Congratulations");
        }else{
            gameController.display(game);
            System.out.println("Game Drawn");
            System.out.println("Opps.. none of you won the game");
        }
    }
}