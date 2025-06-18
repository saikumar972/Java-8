package dumps;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class HighestLength {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "watermelon", "kiwi");
        String s = strings.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).get();
        System.out.println(s);
        List<Employee> empList=new ArrayList<>();
        empList.add(new Employee(1,"devara",1200.22));
        empList.add(new Employee(4,"devara",565775.88));
        empList.add(new Employee(3,"sai",6464));
        empList.add(new Employee(2,"sgs",4646));
        empList.add(new Employee(6,"devara",445.79));
        //finding 2nd highest salary
        Double v = empList.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println(v);
        //flatmap list of list os int ot list
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        List<Integer> collect = listOfLists.stream()
                .flatMap(l -> l.stream().toList().stream())
                .collect(Collectors.toList());
        System.out.println(collect);
       //partitioning
        List<Integer> numbers=Arrays.asList(1,2,4,2,2,2,45,5,3);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(partitioned);
        //Find the longest palindrome in a list of strings:
        List<String> listt= Arrays.asList("okok","kook","saas","saooas");
        String s3 = listt.stream()
                .filter(string -> new StringBuffer(string).reverse().toString().equals(string))
                .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
                .get();
        System.out.println(s3);
        //other way
        String s1 = listt.stream()
                .filter(string -> new StringBuffer(string).reverse().toString().equals(string))
                .sorted(Comparator.comparingInt(String::length).reversed())
                .findFirst().get();
        System.out.println(s1);
        //another way
        String s2 = listt.stream()
                .filter(string -> new StringBuffer(string).reverse().toString().equals(string))
                        .max(Comparator.comparingInt(String::length)).get();
        System.out.println(s2);
        //highest salary per name
        Map<String, Employee> collect1 = empList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get)));
        System.out.println(collect1);
        //avg salary per name
        Map<String, Double> collect2 = empList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect2);
        //just want name and highest salary
        Map<String, Double> collect3 = empList.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary,
                        (s11, s22) -> s11 > s22 ? s11 : s22
                ));
        System.out.println(collect3);
        //need employee name and avg employee full details
        Map<String, Employee> collect4 = empList.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        emp -> emp,
                        (emp1, emp2) -> new Employee(emp1.getId(), emp1.getName(), (emp1.getSalary() + emp2.getSalary()) / 2)

                ));
        System.out.println(collect4);
        //important with grouping
        Map<String, Employee> avgSalaryPerEmployee = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getName,
                        Collectors.collectingAndThen(
                                Collectors.reducing(
                                        (e1, e2) -> new Employee(e1.getId(), e1.getName(), (e1.getSalary() + e2.getSalary()) / 2)
                                ),
                                Optional::get
                        )
                ));
        //simple ga maximum kuda
        Map<String,Double> mappp=empList.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getSalary,
                        (ss1,ss2)->ss1>ss2?ss1:ss2
                ));
        System.out.println(mappp);
        //person andd max salary
        Map<String, Employee> collect5 = empList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
        System.out.println(collect5);
        //if i need salary
        Map<String, Double> collect6 = empList.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), optional -> optional.get().getSalary())));
        System.out.println(collect6);
    }
}
class Employee{
    private int id;
    private String name;
    private double salary;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}