package com.gildedrose;

import static java.lang.String.format;

public class TexttestFixture {
    public static void main(String[] args) {
        StringBuilder builder = buildTests();
        System.out.println(builder);
    }

    private static StringBuilder buildTests() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};

        StringBuilder builder = new StringBuilder();
        GildedRose app = new GildedRose(items);

        int days = 10;
        for (int i = 0; i < days; i++) {
            builder.append(format("------------------------- day %s -------------------------- %n", i));
            builder.append(format("%42s %6s %-8s %n", "NAME", "SELLIN", "QUALITY"));
            for (Item item : items) {
                builder.append(format("%42s %6s %-8s %n", item.name, item.sellIn, item.quality));
            }
            System.out.println();
            app.updateQuality();
        }
        return builder;
    }
}
