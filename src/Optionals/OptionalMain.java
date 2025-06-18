package Optionals;

import java.util.*;
import java.util.stream.Collectors;
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

    public Employee() {
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
    public static List<Employee> employees(){
        return Stream.of(new Employee(1,"rajveer",1200,12),
                new Employee(6,"sai",1500,12.21),
                new Employee(2,"pardu",1000,12.90),
                new Employee(3,"sai",501,12.01)).toList();
    }
}
public class OptionalMain {
    public static void main(String[] args) throws Exception {
        Optional<Object> optional=Optional.empty();
        System.out.println(optional);
        String k=null;
        String k1="null@gmail.com";
        Optional<String> optional1=Optional.ofNullable(k);
        optional1.ifPresent(System.out::println);
        Optional<String> optional2=Optional.of(k1);
        if(optional1.isPresent()){
            System.out.println(optional2.get());
        }
        else{
            System.out.println("null  em led");
        }

        System.out.println(optional1.orElseGet(()->"default@gmail.com"));
        System.out.println(optional2.map(String::toUpperCase).orElseGet(()->"default@gmail.com"));
        System.out.println("----------------------------------------------");
        System.out.println(getName1("sai"));
        System.out.println(getNamesBySorting("sai"));
        System.out.println(getavg("sai"));
        getName("saii");
    }

    public static Employee getName(String name) throws Exception{
        List<Employee> list=EmployeeData.employees();
        return list.stream().
                filter(employee->employee.getName().equalsIgnoreCase(name))
                .findAny()
                .orElseThrow(()->new Exception("no employee present"));
    }
    public static List<Employee> getName1(String name) throws Exception{
        List<Employee> list=EmployeeData.employees();
        return  list.stream().
                filter(employee->employee.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(Collections::singletonList)
                .orElseGet(()-> List.of(new Employee()));

    }
    public static double getavg(String name) throws Exception{
        List<Employee> list=EmployeeData.employees();
        return  list.stream().
                filter(employee->employee.getName().equalsIgnoreCase(name))
                .mapToInt(Employee::getSalary)
                .average()
                .getAsDouble();
                //.orElseGet(()->0.009);

    }
    public static List<Employee> getNamesBySorting(String name) throws Exception{
        List<Employee> list=EmployeeData.employees();
        return  list.stream().
                filter(employee->employee.getName().equalsIgnoreCase(name))
                .sorted(Comparator.comparingInt(Employee::getSalary)).
                collect(Collectors.toList());

    }
    public static List<Employee> getNamesBySorting2(String name) throws Exception{
        List<Employee> list=EmployeeData.employees();
        return  list.stream().
                filter(employee->employee.getName().equalsIgnoreCase(name))
                .sorted((o1,o2)->o1.getSalary()-o2.getSalary()).
                collect(Collectors.toList());

    }
}
