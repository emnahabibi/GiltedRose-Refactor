package com.gildedrose;


import java.util.List;

class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            dailyUpdateQuality(item);
        }
    }


    private void dailyUpdateQuality(Item item) {
        updateItem(item);
        updateExpiration(item);
        if (itemExpired(item)) {
            itemExpiration(item);
        }
    }
    private void updateItem(Item item) {
        if (ItemTypesConst.BRIE.equals(item.name)) {
            incrementQuality(item);
        } else if (ItemTypesConst.BACKSTAGE.equals(item.name)) {
            incrementQuality(item);
            if (item.sellIn < 11) {
                incrementQuality(item);
            }
            if (item.sellIn < 6) {
                incrementQuality(item);
            }
        } else {
            if (!ItemTypesConst.SULFURAS.equals(item.name)) {
                decrementQuality(item);
            }
        }
    }

    private void itemExpiration(Item item){
        if (ItemTypesConst.BRIE.equals(item.name)) {
            incrementQuality(item);
        } else if (ItemTypesConst.BACKSTAGE.equals(item.name)) {
            item.quality = 0;
        } else if (ItemTypesConst.SULFURAS.equals(item.name)) {
            return;
        } else {
            decrementQuality(item);
        }
    }

    private boolean itemExpired(Item item){
        return item.sellIn < 0;
    }

    private void updateExpiration(Item item) {
        if (ItemTypesConst.SULFURAS.equals(item.name)) {
            return;
        }
        --item.sellIn;
    }
    private void decrementQuality(Item item) {
        if (item.quality > 0) {
            if (!ItemTypesConst.SULFURAS.equals(item.name)) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
