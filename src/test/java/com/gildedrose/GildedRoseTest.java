package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GildedRoseTest {

    @Test
    void foo() {
        RoseItem[] items = new RoseItem[] { new RoseItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertNotEquals("fixme", app.items[0].name);
        assertEquals("foo", app.items[0].name);
    }

}
