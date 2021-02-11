package com.gildedrose;

public class RoseItem extends Item {

    public static String SULFURA = "Sulfuras";
    public static String AGED_BRANDIE = "Aged Brie";
    public static String BACKSTAGE_PASSES = "Backstage passes";
    public static String CONJURED = "Backstage passes";

    public RoseItem(String name, int sellIn, int quality){
        super(name, sellIn, quality);
        if(name.contains(SULFURA)){
            this.quality = 80;
        }
    }

    public void decreasePeriode(int periode){
        setSellIn(getSellIn() -periode);
    }

    public String getName(){
        return name;
    }

    public int getSellIn(){
        return sellIn;
    }
    public void setSellIn(int sellIn){
        if(!getName().contains(SULFURA)){
            this.sellIn = sellIn;
        }
    }

    public int getQuality(){
        return quality;
    }
    public void setQuality(int quality){
        if(!getName().contains(SULFURA) && (quality <= 50 || quality >= 0) ){
            this.quality = quality;
        }
    }

}
