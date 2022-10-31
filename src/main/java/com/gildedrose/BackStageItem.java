package com.gildedrose;

public class BackStageItem extends AggregateItem {
    public BackStageItem(Item item) {
        super(item);
    }

    @Override
    public void dailyUpdateQuality() {
        if (this.item.sellIn < 0) {
            this.item.quality = 0;
        } else if (this.item.sellIn < 6) {
            super.itemUpdate(3, 0, 50);
        } else if (this.item.sellIn < 11) {
            super.itemUpdate(2, 0, 50);
        } else {
            super.itemUpdate(1, 0, 50);
        }
    }


}
