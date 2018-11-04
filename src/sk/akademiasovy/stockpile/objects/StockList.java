package sk.akademiasovy.stockpile.objects;

import java.util.List;

public class StockList {
    private List<StockUnit> stockunits;

    public StockList() {
    }

    public StockList(List<StockUnit> stockUnits) {
        this.stockunits = stockUnits;
    }

    public List<StockUnit> getStockUnits() {
        return stockunits;
    }

    public void setStockUnits(List<StockUnit> stockUnits) {
        this.stockunits = stockUnits;
    }
}
