package com.gildedrose;


import java.util.List;

class GildedRose {
    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (!ItemTypesConst.BRIE.equals(item.name)
            && !ItemTypesConst.BACKSTAGE.equals(item.name)) {
            if (item.quality > 0) {
                if (!ItemTypesConst.SULFURAS.equals(item.name)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (ItemTypesConst.BACKSTAGE.equals(item.name)) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (!ItemTypesConst.SULFURAS.equals(item.name)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!ItemTypesConst.BRIE.equals(item.name)) {
                if (!ItemTypesConst.BACKSTAGE.equals(item.name)) {
                    if (item.quality > 0) {
                        if (!ItemTypesConst.SULFURAS.equals(item.name)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
