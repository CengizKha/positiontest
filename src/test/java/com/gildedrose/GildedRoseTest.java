package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    private RoseItem[] items = new RoseItem[] {
            new RoseItem(RoseItem.AGED_BRANDIE, 2, 10) /* 0 */
            , new RoseItem(RoseItem.AGED_BRANDIE, -10, 10) /* 1 */
            , new RoseItem(RoseItem.AGED_BRANDIE, 1, 10) /* 2 */
            , new RoseItem(RoseItem.BACKSTAGE_PASSES, 3, 10) /* 3 */
            , new RoseItem(RoseItem.BACKSTAGE_PASSES, 2, 10) /* 4 */
            , new RoseItem(RoseItem.BACKSTAGE_PASSES, 10, 10) /* 5 */
            , new RoseItem(RoseItem.BACKSTAGE_PASSES, 8, 10) /* 6 */
            , new RoseItem(RoseItem.BACKSTAGE_PASSES, 0, 10) /* 7 */
            , new RoseItem(RoseItem.BACKSTAGE_PASSES, 11, 10) /* 8 */
            , new RoseItem(RoseItem.CONJURED, 11, 10) /* 9 */
            , new RoseItem("Other", 0, 10) /* 10 */
            , new RoseItem("Other", -1, 10) /* 11 */
            , new RoseItem("Other", 11, 10) /* 12 */
            , new RoseItem(RoseItem.SULFURA, 11, 80) /* 13 */
    };

    @Test
    void foo() {
        RoseItem[] items = new RoseItem[] { new RoseItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertNotEquals("fixme", app.items[0].name);
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void ageBriedIncreaseQualityTest(){
        GildedRose app = new GildedRose(items);
        app.agedBendieUpadate(items[0]);

        assertEquals(11, app.items[0].getQuality());
    }

    @Test
    void ageBriedIncreaseQualityWhenZeroTest(){
        GildedRose app = new GildedRose(items);
        app.agedBendieUpadate(items[2]);

        assertEquals(11, app.items[2].getQuality());
    }

    @Test
    void ageBriedDecreaseQualityTest(){
        GildedRose app = new GildedRose(items);
        app.agedBendieUpadate(items[1]);

        assertEquals(8, app.items[1].getQuality());
    }

    @Test
    void backstageIncreseBy3Test(){
        GildedRose app = new GildedRose(items);
        app.backstageUpdate(items[3]);
        app.backstageUpdate(items[4]);

        assertEquals(13, app.items[3].getQuality());
        assertEquals(13, app.items[4].getQuality());
    }

    @Test
    void backstageIncreseBy2Test(){
        GildedRose app = new GildedRose(items);
        app.backstageUpdate(items[5]);
        app.backstageUpdate(items[6]);

        assertEquals(12, app.items[5].getQuality());
        assertEquals(12, app.items[6].getQuality());
    }

    @Test
    void backstageOverTest(){
        GildedRose app = new GildedRose(items);
        app.backstageUpdate(items[7]);

        assertEquals(0, app.items[7].getQuality());
    }

    @Test
    void backstageIncreseBy1Test(){
        GildedRose app = new GildedRose(items);
        app.backstageUpdate(items[8]);

        assertEquals(11, app.items[8].getQuality());
    }

    @Test
    void backstageDecreaseConjuredTest(){
        GildedRose app = new GildedRose(items);
        app.othersUpdate(items[9]);

        assertEquals(8, app.items[9].getQuality());
    }

    @Test
    void backstageDecreaseOthersTest(){
        GildedRose app = new GildedRose(items);
        app.othersUpdate(items[10]);
        app.othersUpdate(items[11]);
        app.othersUpdate(items[12]);

        assertEquals(8, app.items[10].getQuality());
        assertEquals(8, app.items[11].getQuality());
        assertEquals(9, app.items[12].getQuality());
    }

    @Test
    void updateSulfuraTest(){
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, app.items[13].getQuality());
        assertEquals(11, app.items[13].getSellIn());
        assertEquals(RoseItem.SULFURA, app.items[13].getName());
    }

    @Test
    void updateQualityTestV1(){
        GildedRose app = new GildedRose(items);
        app.updateQualityV1();

        // ageBried
        assertEquals(11, app.items[0].getQuality());
        assertEquals(11, app.items[2].getQuality());
        assertEquals(8, app.items[1].getQuality());
        // backstage
        assertEquals(13, app.items[3].getQuality());
        assertEquals(12, app.items[5].getQuality());
        assertEquals(0, app.items[7].getQuality());
        assertEquals(12, app.items[8].getQuality());
        assertEquals(8, app.items[9].getQuality());
        assertEquals(8, app.items[10].getQuality());
        //conjured
        assertEquals(8, app.items[9].getQuality());
        //others
        assertEquals(8, app.items[10].getQuality());
        assertEquals(8, app.items[11].getQuality());

        // sulfura
        assertEquals(RoseItem.SULFURA, app.items[13].getName());
    }

    @Test
    void updateQualityTestV2(){
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        //conjured
        assertEquals(8, app.items[9].getQuality());
        //others
        assertEquals(8, app.items[10].getQuality());
        assertEquals(8, app.items[11].getQuality());

        // sulfura
        assertEquals(RoseItem.SULFURA, app.items[13].getName());
    }



}
