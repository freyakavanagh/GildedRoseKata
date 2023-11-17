package com.sparta.fk;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @org.junit.Test
    void checkNormalItemName() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
    }

    @org.junit.jupiter.api.Test
    void checkNormalItemSellIn() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        int days = 0;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(10, app.items[0].sellIn);
    }

    @org.junit.jupiter.api.Test
    void checkNormalItemSellIn1Day() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(9, app.items[0].sellIn);
    }

    @org.junit.jupiter.api.Test
    void checkNormalItemQuality1Day() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(19, app.items[0].quality);
    }

    @org.junit.jupiter.api.Test
    void checkAgedBrieSellIn1Day() {
        Item[] items = new Item[] {new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(1, app.items[0].sellIn);
    }
    @org.junit.jupiter.api.Test
    void checkAgedBrieQuality1Day() {
        Item[] items = new Item[] {new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(1, app.items[0].quality);
    }

    @org.junit.jupiter.api.Test
    void checkSulfurasSellIn1Day() {
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(0, app.items[0].sellIn);
    }

    @org.junit.jupiter.api.Test
    void checkSulfurasQuality1Day() {
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(80, app.items[0].quality);
    }
    @org.junit.jupiter.api.Test
    void checkBackstagePassesSellIn1Day() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(14, app.items[0].sellIn);
    }

    @org.junit.jupiter.api.Test
    void checkBackstagePassesLongTimeQuality1Day() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(21, app.items[0].quality);
    }

    @org.junit.jupiter.api.Test
    void checkBackstagePasses10daysQuality1Day() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 29)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(31, app.items[0].quality);
    }

    @org.junit.jupiter.api.Test
    void checkBackstagePasses5daysQuality1Day() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 29),};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(32, app.items[0].quality);
    }

    @org.junit.jupiter.api.Test
    void checkQualityNeverOver50() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(50, app.items[0].quality);
    }

    @org.junit.jupiter.api.Test
    void checkBackstagePassQualityAfterConcert() {
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(0, app.items[0].quality);
    }

    @org.junit.jupiter.api.Test
    void checkQualityIsNeverNegative() {
        Item[] items = new Item[] {new Item("Elixir of the Mongoose", 5, 0)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(0, app.items[0].quality);
    }

    @org.junit.jupiter.api.Test
    void checkPastSellByDateQualityDecreaseRate() {
        Item[] items = new Item[] {new Item("Elixir of the Mongoose", 0, 20)};
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void checkConjuredItemsQualityDecreaseRate() {
        Item[] items = new Item[] {new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        int days = 1;
        for (int i = 0; i < days; i++){
            app.updateQuality();}
        assertEquals(4, app.items[0].quality);
    }





}