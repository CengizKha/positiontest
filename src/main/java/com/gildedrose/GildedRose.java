package com.gildedrose;

class GildedRose {

    protected RoseItem[] items;

    public GildedRose(RoseItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (RoseItem item : items) {

            if(item.getName().contains(item.BACKSTAGE_PASSES)){
                if(item.getSellIn() <= 3){
                    item.setQuality(item.getQuality() +3);
                } else if(item.getSellIn() <= 10){
                    item.setQuality(item.getQuality() +2);
                } else if(item.getSellIn() == 0){
                    item.setQuality(0);
                } else {
                    item.setQuality(item.getQuality() +1);
                }
            } else if(item.getName().contains(item.AGED_BRANDIE) && item.getSellIn() >= 0) {
                if(item.getSellIn() >= 0){
                    item.setQuality(item.getQuality() +1);
                } else {
                    item.setQuality(item.getQuality() /2);
                }
            } else {
                if(item.getSellIn() == 0){
                    item.setQuality(item.getQuality() /2);
                } else {
                    item.setQuality(item.getQuality() -1);
                }
            }

            item.sellingPeriode();
        }
    }
}