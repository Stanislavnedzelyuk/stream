package stream.stream;

import java.util.Objects;

public class Employee {
    private String fullName;  // Полное имя сотрудника
    private double salary;  // Зарплата сотрудника
    private int departmentId;  // ID отдела, в котором работает сотрудник


    public Employee(String fullName, int departmentId, int salary) {
        this.fullName = fullName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getSalary() == employee.getSalary() && Objects.equals(getFullName(),
                employee.getFullName()) && Objects.equals(getDepartmentId(),
                employee.getDepartmentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getDepartmentId(), getSalary());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
