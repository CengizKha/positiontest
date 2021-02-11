package com.gildedrose;

class GildedRose {
    private static String SULFURA = "Sulfuras";
    private static String AGED_BRANDIE = "Aged Brie";
    private static String BACKSTAGE_PASSES = "Backstage passes";

    protected Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRANDIE)
                    && !item.name.contains(BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    if (!item.name.contains(SULFURA)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.contains(BACKSTAGE_PASSES)) {
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

            if (!item.name.contains(SULFURA)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRANDIE)) {
                    if (!item.name.contains(BACKSTAGE_PASSES)) {
                        if (item.quality > 0) {
                            if (!item.name.contains(SULFURA)) {
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
}