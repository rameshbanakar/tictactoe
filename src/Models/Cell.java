package Models;

import Models.Player.Player;
import Models.enums.CellStatus;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellStatus cellStatus;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellStatus=CellStatus.EMPTY;
    }

    public void displayCell(){
        if(this.cellStatus==CellStatus.EMPTY){
            System.out.print("|"+0+"|");
        }else{
            System.out.print("|"+this.player.getSymbol().getSymbol()+"|");
        }
    }
    public void setPlayer(Player player){
        this.player=player;

    }
    public Player getPlayer(){
        return this.player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }
}
