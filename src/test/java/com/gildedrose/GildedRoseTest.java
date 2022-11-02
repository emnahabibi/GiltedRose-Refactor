package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemTypesConst.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class GildedRoseTest {

    /**
     * Aged Brie item is never more than 50
     */
    @Test
     void agedBriePassesQualityShouldNotBeMoreThan50() {
        Item item = new Item(BRIE, 8, 50);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo(BRIE);
        assertThat(item.quality).isEqualTo(50);
        assertThat(item.sellIn).isEqualTo(7);
    }

    /**
     * Sulfuras, being a legendary item, never has to be sold or decreases in Quality
     */
    @Test
     void sulfurasQualityShouldNotBeModified() {
        Item item = new Item(SULFURAS, 8, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo(SULFURAS);
        assertThat(item.quality).isEqualTo(80);
        assertThat(item.sellIn).isEqualTo(7);
    }

    /**
     * Backstage quality increases by 2 when there are 10 days or less
     */
    @Test
     void backstageQualityIncreases2TimesIn10Days() {
        Item item = new Item(BACKSTAGE, 8, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo(BACKSTAGE);
        assertThat(item.quality).isEqualTo(32);
        assertThat(item.sellIn).isEqualTo(7);
    }

    /**
     * Backstage quality increases by 3 when there are 5 days
     */
    @Test
     void backStagePassesQualityIncreases3TimesIn5Days() {
        Item item = new Item(BACKSTAGE, 5, 2);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo(BACKSTAGE);
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(5);
    }
    @Test
    public void SulfurasPassesQualityIncreases0WhenSellInOff() {
        Item item = new Item(SULFURAS, -5, 80);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.name).isEqualTo(SULFURAS);
        assertThat(item.sellIn).isEqualTo(-5);
        assertThat(item.quality).isEqualTo(80);
    }

    /**
     * Conjured item decrement quality twice faster than normal
     */
    @Test
    void conjuredItemDecreaseQualityTwiceFaster() {
        Item item = new Item(CONJURED, 10, 30);
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
        Item item = new Item(CONJURED, 0, 30);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();
        assertThat(item.quality).isEqualTo(28);
    }


}
