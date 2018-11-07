package sk.akademiasovy.stockpile.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StockFilter {

    public StockUnit findByname(Stockunits list,String name){
        StockUnit out = new StockUnit();
        Predicate<StockUnit> p = (n) -> n.getName().equals(name);
        out = list.getStockUnits().stream()
                .filter(p)
                .findFirst()
                .get();
        return out;
    }

}
