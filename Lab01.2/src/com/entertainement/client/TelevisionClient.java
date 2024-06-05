package com.entertainement.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TelevisionClient {
    public static void main(String[] args) {

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Samsung", 32);
        Television tvD = new Television("LG", 12);


        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        System.out.println(tvA == tvB);
        System.out.println(tvA.equals(tvB));
        System.out.println();

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        for (Television tv : tvs){
            System.out.println(tv);
        }
        System.out.println("The size of the set is " + tvs.size());
    }
}
