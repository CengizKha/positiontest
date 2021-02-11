package com.gildedrose;

class GildedRose {

    protected RoseItem[] items;

    public GildedRose(RoseItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (RoseItem item : items) {


            if (!item.getName().equals(RoseItem.AGED_BRANDIE)
                    && !item.getName().contains(RoseItem.BACKSTAGE_PASSES)) {
                if (item.getQuality() > 0) {
                    if (!item.getName().contains(RoseItem.SULFURA)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.quality = item.quality + 1;

                    if (item.getName().contains(RoseItem.BACKSTAGE_PASSES)) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals(RoseItem.AGED_BRANDIE)) {
                    if (!item.getName().contains(RoseItem.BACKSTAGE_PASSES)) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().contains(RoseItem.SULFURA)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }


            if(!item.getName().contains(RoseItem.SULFURA)){
                item.decreaseSellin();
            }
        }
    }
}