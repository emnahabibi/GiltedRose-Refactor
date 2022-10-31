package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    /**
     * The Quality of an item is never more than 50
     */
    @Test
    public void backstagePassesQualityShouldNotBeMoreThan50() {

        Item item = new Item("Aged Brie", 8, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Aged Brie");
        assertThat(item.quality).isEqualTo(50);
        assertThat(item.sellIn).isEqualTo(7);
    }

    /**
     * Sulfuras, being a legendary item, never has to be sold or decreases in Quality
     */
    @Test
    public void sulfurasQualityShouldNotBeModified() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 8, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Sulfuras, Hand of Ragnaros");
        assertThat(item.quality).isEqualTo(80);
        assertThat(item.sellIn).isEqualTo(7);
    }

    /**
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * Quality drops to 0 after the concert
     */
    @Test
    public void qualityIncreasesRelatedToNumberOfDays() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.quality).isEqualTo(32);
        assertThat(item.sellIn).isEqualTo(7);
    }
}
