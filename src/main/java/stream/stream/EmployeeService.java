package stream.stream;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final OldEmployeeService oldEmployeeService;  // старый сервис для доступа к списку сотрудников

    public EmployeeService(OldEmployeeService oldEmployeeService) {
        this.oldEmployeeService = oldEmployeeService;
    }

    public Employee getMaxSalaryByDepartment(int departmentId) {
        return oldEmployeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee getMinSalaryByDepartment(int departmentId) {
        return oldEmployeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getAllByDepartment(int departmentId) {
        return oldEmployeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllGroupByDepartment() {
        return oldEmployeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}




