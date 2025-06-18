package interview;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Sample {
    private static List<Employee> getEmployeeDetails(){
        return Stream.of(new Employee(1,10000,"Sai"),
                new Employee(1,20000,"Sai"),
                new Employee(1,30000,"Sai"),
                new Employee(1,30000,"Sai")).toList();
    }

    public static void main(String[] args) {
        List<Employee> employeeList=getEmployeeDetails();
        Double v = employeeList.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(v);

    }
}
class Employee{
    private int id;
    private double salary;
    private String name;

    public Employee(int id, double salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}