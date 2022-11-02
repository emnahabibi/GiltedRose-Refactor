package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GildedRoseTest {

    /**
     * Aged Brie item is never more than 50
     */
    @Test
     void agedBriePassesQualityShouldNotBeMoreThan50() {
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
     void sulfurasQualityShouldNotBeModified() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 8, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Sulfuras, Hand of Ragnaros");
        assertThat(item.quality).isEqualTo(80);
        assertThat(item.sellIn).isEqualTo(7);
    }

    /**
     * Backstage quality increases by 2 when there are 10 days or less
     */
    @Test
     void backstageQualityIncreasesRelatedToNumberOfDays() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.quality).isEqualTo(32);
        assertThat(item.sellIn).isEqualTo(7);
    }

    /**
     * Backstage quality increases by 3 when there are 5 days
     */
    @Test
     void backStagePassesQualityIncreases3TimesIn5Days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(5);
    }

    /**
     * Conjured item decrement quality twice faster than normal
     */
    @Test
    void conjuredItemDecreaseQualityTwiceFaster() {
        Item item = new Item("Conjured Mana Cake", 10, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.quality).isEqualTo(28);
        assertThat(item.sellIn).isEqualTo(9);

    }

    /**
     * Conjured item increase quality when expired
     */
    @Test
    void conjuredItemIncreasesQualityWhenExpired() {
        Item item = new Item("Conjured Mana Cake", 0, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.quality).isEqualTo(28);
    }


}
