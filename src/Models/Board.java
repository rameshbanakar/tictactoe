package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int size;

    public Board(int size) {
        this.size = size;
        this.board=new ArrayList<>();
        for(int i=0;i<size;i++){
            this.board.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void displayBoard(){
        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++){
                this.board.get(i).get(j).displayCell();
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getCell(){
        return this.board;
    }
}
