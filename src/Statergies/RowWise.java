package Statergies;

import Models.Move;

import java.util.HashMap;

public class RowWise implements WinningStatergies{
    int size;
    //symbolName, count
    private HashMap<String, Integer> rowCount[];

    public RowWise(int size) {
        this.size = size;
        rowCount = new HashMap[size];
        for (int i = 0; i < size; i++) {
            rowCount[i] = new HashMap<>();
        }
    }

    @Override
    public boolean checkWinner(Move move) {
       int row=move.getCell().getRow();
        HashMap<String, Integer> rowMap=rowCount[row];

        String currSymbol=move.getPlayer().getSymbol().getSymbol();

        if(!rowMap.containsKey(currSymbol)){
            rowMap.put(currSymbol,1);
        }
        else rowMap.put(currSymbol,rowMap.get(currSymbol)+1);
        if (size == rowMap.get(currSymbol)) return true;
        return false;
    }


}
