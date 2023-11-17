package com.sparta.fk;

class GildedRose {
    Item[] items; // the tavern's stock as an array of items, can't be private when used in tests
    private static final int MAX_QUALITY = 50;//magic numbers as constants
    private static final int MIN_QUALITY = 0;

    private static final String AGED_BRIE = "Aged Brie"; //item names as constants
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured Mana Cake";

    public GildedRose(Item[] items) { // tavern constructor
        this.items = items;
    }


    public void updateQuality() {


        for (Item item : items) { //for-each loop through all items in array

            String itemName = item.name;

            switch (itemName) {
                case AGED_BRIE:
                    increaseQuality(item, 1);
                    item.sellIn--;
                    break;

                case BACKSTAGE_PASS:
                    setPassQuality(item);
                    item.sellIn--;
                    break;

                case SULFURAS:

                    break;
                case CONJURED_ITEM:
                    decreaseQuality(item, 2);
                    item.sellIn--;
                    break;
                default:
                    setNormalItemQuality(item);
                    item.sellIn--;
                    break;

            }
        }
    }

    public void setPassQuality(Item item) {
        int sellByDate = item.sellIn;

        if (sellByDate > 10) {
            increaseQuality(item, 1);
        } else if (sellByDate > 5) {
            increaseQuality(item, 2);
        } else if (sellByDate > 0) {
            increaseQuality(item, 3);
        } else {
            item.quality = MIN_QUALITY;
        }
    }

    private void increaseQuality(Item item, int amount) {
        if (item.quality + amount > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        } else {
            item.quality += amount;
        }
    }


    public void setNormalItemQuality(Item item) {

        if (item.sellIn > 0) {
            decreaseQuality(item, 1);
        } else {
            decreaseQuality(item, 2);
        }
    }



    private void decreaseQuality(Item item, int amount) {
        if (item.quality - amount < MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        } else {
            item.quality -= amount;
        }
    }
}
