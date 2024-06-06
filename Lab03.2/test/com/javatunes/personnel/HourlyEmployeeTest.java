package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {

    private HourlyEmployee hourly;

    @Before
    public void setUp() {
        hourly = new HourlyEmployee("John", Date.valueOf("2020-02-02"), 25.0, 35.0);
    }

    @Test
    public void testPay() {
        assertEquals(875, hourly.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(218.75, hourly.payTaxes(), .001);
    }
}