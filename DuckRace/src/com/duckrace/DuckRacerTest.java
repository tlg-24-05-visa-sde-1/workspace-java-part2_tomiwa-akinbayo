package com.duckrace;

import java.util.Collection;

public class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer duck1 = new DuckRacer(16, "Tomiwa");
        duck1.win(Reward.DEBIT_CARD);
        System.out.println(duck1);

    }
}
