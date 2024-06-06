package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
BVT:
    volume
    -1,0 and 100,101
 */
public class TelevisionTest {
    private Television tv;
    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() {
        tv = new Television();
        tv1 = new Television("LG", 30, DisplayType.LED);
        tv2 = new Television("LG", 30, DisplayType.LED);
    }

    @Test
    public void equals_shouldReturnTrue_forHashCode() {
        assertEquals(tv1.hashCode(), tv2.hashCode());
    }

    @Test
    public void compareTo_shouldReturnZero_allPropertiesSame() {
        assertEquals(0, tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldReturnNegativeNumber_when1stBrandLessThan2ndBrand() {
        tv1.setBrand("A_lessThan");
        tv2.setBrand("B_greaterThan");
        assertTrue(tv1.compareTo(tv2) < 0);
    }

    @Test
    public void compareTo_shouldReturnPositiveNumber_when1stBrandGreaterThan2ndBrand() {
        tv1.setBrand("B_greaterThan");
        tv2.setBrand("A_lessThan");
        assertTrue(tv1.compareTo(tv2) > 0);
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_upperBound()
    throws InvalidChannelException{
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_upperBound()
    throws InvalidChannelException{
        tv.changeChannel(1000);
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_lowerBound()
    throws InvalidChannelException{
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()
            throws InvalidChannelException {
        tv.changeChannel(0);
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
        try{
            tv.setVolume(101);
        }
        catch(IllegalArgumentException e) {
            assertEquals("Invalid volume: 101. Allowed range: [0,100].", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
        tv.setVolume(-1);
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }
}