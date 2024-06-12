package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
//        emp1 = new DummyEmployee("Tomiwa", Date.valueOf("2020-09-08"));
//        emp2 = new DummyEmployee("Tomiwa", Date.valueOf("2020-09-08"));

        emp1 = getEmployee();
        emp2 = getEmployee();
    }

    private static Employee getEmployee() {
        return new Employee("Tomiwa", Date.valueOf("2020-09-08")) {
            public double pay() {
                return 0;
            }
            public double payTaxes() {
                return 0;
            }
        };
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("Tomi");
        assertNotEquals(emp1, emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2020-02-02"));
        assertNotEquals(emp1, emp2);
        assertFalse(emp1.equals(emp2));
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1, emp2);   // this does a .equals() check
        assertTrue(emp1.equals(emp2));  // alternative assertion, wouldn't normally do both
    }

    // NAMED MEMBER-LEVEL INNER CLASSES
    private class DummyEmployee extends Employee {
        public DummyEmployee() {
        }

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}