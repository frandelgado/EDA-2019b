package ar.edu.itba.eda.models;

import org.joda.money.Money;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @BeforeAll
    static void setUp(){
        System.out.println("Starting test suite");
    }

    @Test
    void testCreateEmployee(){
        Money salary = Money.parse("USD 1200");
        String name = "John";
        String surname = "doe";
        Employee employee = new Employee(name, surname, salary);
        Assertions.assertEquals(name, employee.getName());
        Assertions.assertEquals(surname, employee.getSurname());
        Assertions.assertEquals(salary, employee.getSalary());
    }

    @Test()
    void testCreateEmployeeWithBadCurrency(){
        Money salary = Money.parse("ARS 45000");
        String name = "John";
        String surname = "doe";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Employee(name, surname, salary));
    }

    @AfterAll
    static void tearDown(){
        System.out.println("Finished testing");
    }
}
