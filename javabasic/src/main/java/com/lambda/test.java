package com.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class test {
    @Test
    public void test7() {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, (double) 3333),
                new Employee("李四", 38, (double) 55555),
                new Employee("王五", 50, 6666.66),
                new Employee("赵六", 16, 77777.77),
                new Employee("田七", 8, 8888.88)
        );
        employees.stream()
                .filter(e-> e.getSalary() >= (double)5000)
                .sorted((y,x) -> Double.compare(x.getSalary(),y.getSalary()))
                .limit(2)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("=========");
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
}
