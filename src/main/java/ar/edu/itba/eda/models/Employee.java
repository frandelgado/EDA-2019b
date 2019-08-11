package ar.edu.itba.eda.models;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;

public class Employee {

    private String name;
    private String surname;
    private Money salary;

    public Employee(String name, String surname, Money salary) {
        if(salary.getCurrencyUnit() !=  CurrencyUnit.of("USD")){
            throw new IllegalArgumentException("The salary's currency must be in USDs");
        }
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public Money getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    /**
     * Increases the salary of a given employee by a given percentage
     * @param employee the employee who's salary should be increased
     * @param percentage the percentage of the current salary to be increased, ex. 2.5 for 2.5%
     * */
    public static Employee increaseSalary(Employee employee, float percentage) {
        if(percentage < 0) {
            throw new IllegalArgumentException("Percentage must be a positive number");
        }
        employee.salary = employee.getSalary().multipliedBy(1+percentage, RoundingMode.DOWN);
        return employee;
    }
}
