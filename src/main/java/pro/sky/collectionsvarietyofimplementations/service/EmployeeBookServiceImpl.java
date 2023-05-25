package pro.sky.collectionsvarietyofimplementations.service;

import org.springframework.stereotype.Service;
import pro.sky.collectionsvarietyofimplementations.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collectionsvarietyofimplementations.exceptions.EmployeeNotFoundException;
import pro.sky.collectionsvarietyofimplementations.model.Employee;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookServiceInterface {

    private final Map<String, Employee> employeeMap;

    public EmployeeBookServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee employeeAdd(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee employeeRemove(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.remove(employee.getFullName());
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        if (!employeeMap.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.get(employee.getFullName());

    }

    @Override
    public Collection<Employee> printAllEmployee() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

}
