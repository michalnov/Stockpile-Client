package sk.akademiasovy.stockpile.objects;

import java.util.LinkedList;
import java.util.List;

public class Stockunits {
    private LinkedList<StockUnit> stockunits;

    public Stockunits() {
    }

    public Stockunits(LinkedList<StockUnit> stockUnits) {
        this.stockunits = stockUnits;
    }

    public LinkedList<StockUnit> getStockUnits() {
        return stockunits;
    }

    public void setStockUnits(LinkedList<StockUnit> stockUnits) {
        this.stockunits = stockUnits;
    }
}
