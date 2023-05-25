package pro.sky.collectionsvarietyofimplementations.service;

import pro.sky.collectionsvarietyofimplementations.model.Employee;

import java.util.Collection;

public interface EmployeeBookServiceInterface {

    Employee employeeAdd(String name, String surname);

    Employee employeeRemove(String name, String surname);

    Employee findEmployee(String name, String surname);

    Collection<Employee> printAllEmployee();
}
