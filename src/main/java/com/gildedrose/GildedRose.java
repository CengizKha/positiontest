package com.gildedrose;

class GildedRose {

    protected RoseItem[] items;

    public GildedRose(RoseItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (RoseItem item : items) {

            item.decreasePeriode(1);

            if(item.getName().contains(item.BACKSTAGE_PASSES)){
                backstageUpdate(item);
            } else if(item.getName().contains(item.AGED_BRANDIE)) {
                agedBendieUpadate(item);
            } else {
                othersUpdate(item);
            }

        }

    }

    public void agedBendieUpadate(final RoseItem item){
        if(item.getSellIn() >= 0){
            increaseQualityBy(item, 1);
        } else {
            decreaseQualityBy(item, 2);
        }
    }

    public void backstageUpdate(final RoseItem item){
        if(item.getSellIn() <= 0){
            item.setQuality(0);
        } else if(item.getSellIn() <= 3){
            increaseQualityBy(item, 3);
        } else if(item.getSellIn() <= 10){
            increaseQualityBy(item, 2);
        } else {
            increaseQualityBy(item, 1);
        }
    }

    public void othersUpdate(final RoseItem item){
        if(item.getName().contains(item.CONJURED) || item.getSellIn() <= 0){
            decreaseQualityBy(item, 2);
        } else {
            decreaseQualityBy(item, 1);
        }
    }

    private void increaseQualityBy(final RoseItem item, final int value){
        item.setQuality(item.getQuality() +value);
    }

    private void decreaseQualityBy(final RoseItem item, final int value){
        item.setQuality(item.getQuality() -value);
    }

}