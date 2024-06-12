package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("white", 1.5, 2.5, 5));
        radishes.add(new Radish("black", 1.0, 0.0, 0));
        radishes.add(new Radish("red", 2.7, 5.5, 0));
        radishes.add(new Radish("pink", 0.9, 0.0, 6));

        System.out.println("Original List");
        dump(radishes);

        System.out.println("Sorted by Natural oder");
        radishes.sort(null);    // passing null means natural order
        dump(radishes);

        System.out.println("Sort by color via anonymous Comparator class");
//        radishes.sort(new RadishColorComparator());
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return r1.getColor().compareTo(r2.getColor());
            }
        });
        dump(radishes);

        System.out.println("Sort by guysOnTop via anonymous class");
//        radishes.sort(new RadishGuysOnTopComparator());
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return Integer.compare(r1.getGuysOnTop(), r2.getGuysOnTop());
            }
        });
        dump(radishes);

        System.out.println("sort by tailLength via anonymous class");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish radish1, Radish radish2) {
                return Double.compare(radish1.getTailLength(), radish2.getTailLength());
            }
        });
        dump(radishes);
    }

    private static void dump(List<Radish> radishes) {
        for(Radish radish : radishes) {
            System.out.println(radish);
        }
        System.out.println();
    }


}
