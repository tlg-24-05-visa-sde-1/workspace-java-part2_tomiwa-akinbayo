/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.util.Collection;

class InMemoryCatalogTestMain {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        // testSize();
        // testGetAll();
        // testFindSelfTitle();
        // testPriceRocks(13.00);
        // testAveragePrice();
        // testGetAll();
        // testFindCheapest(MusicCategory.POP);
        // testGenreAveragePrice(MusicCategory.CLASSICAL);

    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.findById(6L));

        MusicItem notFound = catalog.findById(101L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> match = catalog.findByKeyword("annielennox");
        dump(match);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> found = catalog.findByCategory(MusicCategory.POP);
        dump(found);

    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.size());
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> data = catalog.getAll();
        dump(data);
    }

    private static void testFindSelfTitle() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> sameName = catalog.findSelfTitle();
        dump(sameName);
    }

    private static void testPriceRocks(double price){
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> prices = catalog.priceRocks(price);
        dump(prices);
    }

    private static void testAveragePrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.averagePrice());
    }

    private static void testFindCheapest(MusicCategory genre) {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> cheap = catalog.findCheapest(MusicCategory.ROCK);
        dump(cheap);
    }

    private static void testGenreAveragePrice(MusicCategory genre) {
        InMemoryCatalog catalog = new InMemoryCatalog();
        System.out.println(catalog.genreAveragePrice(genre));
    }


    private static void dump(Collection<MusicItem> items){
        for(MusicItem item: items){
            System.out.println(item);
        }
    }
}