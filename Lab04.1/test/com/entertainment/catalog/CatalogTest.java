/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void findLoudest_TelevisionInCatalog() {
        Collection<Television> tv = Catalog.getInventory();
        int loudest = 0;
        for(Television item : tv) {
            if(item.getVolume() > loudest){
                loudest = item.getVolume();
            }
        }
        assertEquals(94, loudest);

    }

    @Test
    public void removeDuplicates() {
        Collection<Television> tv = Catalog.getInventory();
        Set<Television> newTv = new HashSet<>(tv);

        assertEquals(23, newTv.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getInventory_shouldThrowException_ifModified()
    throws UnsupportedOperationException{
        Collection<Television> tv = Catalog.getInventory();

        tv.add(new Television("LG", 0));
    }

    @Test
    public void getInventory_shouldReturn_entireTelevisionArrayList() {
        Collection<Television> tv = Catalog.getInventory();
        assertEquals(30, tv.size());
    }

    @Test
    public void findByBrands_shouldReturnPopulatedMap_brandsPassed() {
        Map<String,Collection<Television>> tvMap = Catalog.findByBrands("Sony", "NOT-FOUND");

        assertEquals(2, tvMap.size());

        Collection<Television> sonyTvs = tvMap.get("Sony");
        assertEquals(7, sonyTvs.size());
        for (Television tv: sonyTvs) {
            assertEquals("Sony", tv.getBrand());
        }

        Collection<Television> notFoundTvs = tvMap.get("NOT-FOUND");
        assertEquals(0, notFoundTvs.size());

    }

    @Test
    public void findByBrands_shouldReturnEmptyMap_noBrandsPassed() {
        Map<String,Collection<Television>> tvMap = Catalog.findByBrands();

        assertEquals(0, tvMap.size());
    }

    @Test
    public void findByBrand_shouldReturnPopulatedCollection_brandFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");

        assertEquals(7, tvs.size());

        for (Television tv : tvs){
            assertEquals("Sony", tv.getBrand());
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_brandNotFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(tvs);
        assertTrue(tvs.isEmpty());
    }
}