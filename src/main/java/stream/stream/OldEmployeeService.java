package stream.stream;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OldEmployeeService {
    private List<Employee> employees = new ArrayList<>();  // Список всех сотрудников

    // Метод для добавления сотрудника в список
    public void add(Employee employee) {
        employees.add(employee);
    }

    // Метод для удаления сотрудника из списка
    public void delete(Employee employee) {
        employees.remove(employee);
    }

    // Метод для получения списка всех сотрудников
    public List<Employee> getAllEmployees() {
        return employees;
    }
    public OldEmployeeService() {
        Employee employee1 = new Employee("John Smith", 5, 100);
        Employee employee2 = new Employee("Alice Johnson", 6, 100);
        Employee employee3 = new Employee("Robert Davis", 5, 200);
        Employee employee4 = new Employee("Emily Wilson", 5, 200);
        Employee employee5 = new Employee("Michael Brown", 6, 300);

        add(employee1);
        add(employee2);
        add(employee3);
        add(employee4);
        add(employee5);
    }



}


