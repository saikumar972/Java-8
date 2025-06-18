package filtering;

import java.util.List;
import java.util.stream.Stream;

class Employee{
    private int id;
    private String name;
    private int salary;
    private double tax;

    public Employee(int id, String name, int salary, double tax) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", tax=" + tax +
                '}';
    }
}
class EmployeeData{
    public List<Employee> employees(){
        return Stream.of(new Employee(1,"sai",1200,12),
                new Employee(6,"rajveer",1500,12.21),
                new Employee(2,"pardu",1000,12.90),
                new Employee(3,"whatsapp",500,12.01)).toList();
    }
}
public class EmployeeFiltering {
    public static void main(String[] args) {
        new EmployeeData().employees().stream().filter(obj->obj.getSalary()>1200).forEach(System.out::println);
    }
}
