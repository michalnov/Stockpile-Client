package sk.akademiasovy.stockpile.objects;

import java.util.List;

public class StockList {
    private List<StockUnit> stockUnits;

    public StockList() {
    }

    public StockList(List<StockUnit> stockUnits) {
        this.stockUnits = stockUnits;
    }

    public List<StockUnit> getStockUnits() {
        return stockUnits;
    }

    public void setStockUnits(List<StockUnit> stockUnits) {
        this.stockUnits = stockUnits;
    }
}
