package com.gildedrose;

public class RoseItem extends Item {
    public RoseItem(String name, int sellIn, int quality){
        super(name, sellIn, quality);
    }

    public void decreaseQuality(){
        if(this.sellIn == 0){
            setQuality(this.quality -2);
        } else {
            setQuality(this.quality -1);
        }
    }

    public void decreaseSellin(){
        if(this.sellIn > 0){
            this.sellIn --;
        }
    }

    public String getName(){
        return name;
    }
    public int getSellIn(){
        return this.sellIn;
    }
    public int getQuality(){
        return this.quality;
    }
    public void setQuality(int quality){
        if(quality >= 0){
            this.quality = quality;
        }
    }
}