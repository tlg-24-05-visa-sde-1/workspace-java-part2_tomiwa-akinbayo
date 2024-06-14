package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private Television tv1;
    private Television tv2;
    private TelevisionBrandChannelComparator comparator;

    @Before
    public void setUp() {
        tv1 = new Television();
        tv2 = new Television();

        comparator = new TelevisionBrandChannelComparator();
    }

    @Test
    public void compare_shouldReturnZero_whenSameChannel() {
        assertEquals(0, comparator.compare(tv1, tv2));
    }
}