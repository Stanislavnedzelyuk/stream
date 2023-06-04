package stream.stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController  // Аннотация Spring, указывающая, что это класс контроллера
@RequestMapping("/departments")  // Базовый URL для всех методов в этом контроллере
public class EmployeeController {
    private final EmployeeService employeeService;  // Сервис для работы с данными о сотрудниках

    // Конструктор, который автоматически внедряет сервис через Spring Dependency Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Метод для обработки GET-запроса, возвращающего сотрудника с максимальной зарплатой
    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam int departmentId) {
        return employeeService.getMaxSalaryByDepartment(departmentId);
    }

    // Метод для обработки GET-запроса, возвращающего сотрудника с минимальной зарплатой
    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam int departmentId) {
        return employeeService.getMinSalaryByDepartment(departmentId);
    }

    // Метод для обработки GET-запроса, возвращающего список всех сотрудников
    @GetMapping("/all")
    public List<Employee> getAll(@RequestParam int departmentId) {
        return employeeService.getAllByDepartment(departmentId);
    }

    // Метод для обработки GET-запроса, возвращающего список всех сотрудников, сгруппированных по отделам
    @GetMapping("/all-grouped")
    public Map<Integer, List<Employee>> getAllGrouped() {

        return employeeService.getAllGroupByDepartment();
    }
}


