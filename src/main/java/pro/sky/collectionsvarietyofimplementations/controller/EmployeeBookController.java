package pro.sky.collectionsvarietyofimplementations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collectionsvarietyofimplementations.model.Employee;
import pro.sky.collectionsvarietyofimplementations.service.EmployeeBookServiceInterface;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {

    private final EmployeeBookServiceInterface service;

    public EmployeeBookController(EmployeeBookServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee employeeAdd(@RequestParam("name") String name,
                                @RequestParam("surname") String surname
    ) {
        return service.employeeAdd(name, surname);
    }

    @GetMapping("/remove")
    public Employee employeeRemove(@RequestParam("name") String name,
                                   @RequestParam("surname") String surname
    ) {
        return service.employeeRemove(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name,
                                 @RequestParam("surname") String surname
    ) {
        return service.findEmployee(name, surname);
    }

    @GetMapping
    public Collection<Employee> findAllEmployee() {
        return service.printAllEmployee();
    }
}
