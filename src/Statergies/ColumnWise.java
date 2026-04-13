package Statergies;

import Models.Move;

import java.util.HashMap;

public class ColumnWise implements WinningStatergies{
    private int size;
    private HashMap<String,Integer> colCount[];

    public ColumnWise(int size) {
        colCount = new HashMap[size];
        for (int i = 0; i < size; i++) {
            colCount[i] = new HashMap<>();
        }
    }
    @Override
    public boolean checkWinner(Move move) {
        int col=move.getCell().getCol();
        String currSym=move.getPlayer().getSymbol().getSymbol();
        HashMap<String,Integer> currCol=colCount[col];
        if(!currCol.containsKey(currSym)){
            currCol.put(currSym,1);
        }else currCol.put(currSym,currCol.get(currSym)+1);

        return size==currCol.get(currSym);
    }
}
