package com.gildedrose;

public class AggregateItem implements AggregateItemInterface{

    Item item;

    public AggregateItem(Item item) {
        this.item = item;
    }

    public static AggregateItem generateNewItemFromItem(Item item) {
        if(ItemTypesConst.BRIE.equals(item.name)){}
        if(ItemTypesConst.SULFURAS.equals(item.name)){}
        if(ItemTypesConst.BACKSTAGE.equals(item.name)){}
        return new AggregateItem(item);
    }
}
