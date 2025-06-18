package groupingBy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employees{
    private int id;
    private String name;
    private String place;
    private String job;
    private double salary;

    public Employees(int id, String name, String place, String job, double salary) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.job = job;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class EmployeeDatabases{
    public static List<Employees> employeeList(){
        return Stream.of(new Employees(1,"sai","ap","se",1200),
                        new Employees(2,"kumar","ap","gold",1200),
                        new Employees(3,"rajveer","tg","se",5666),
                        new Employees(4,"nanda","karnataka","se",4344),
                        new Employees(7,"pardhu","ap","silver",466767),
                        new Employees(6,"nandhu","tg","diamond",24532),
                        new Employees(9,"gopal","karnataka","se",8900),
                        new Employees(10,"saaho","ap","se",12300),
                        new Employees(5,"bhairava","tg","business",9000))
                .collect(Collectors.toList());

    }
}
public class DumpExample {
    public static void main(String[] args) {
        List<Employees> employeesList=EmployeeDatabases.employeeList();
        //place and highest salary part 1
        Map<String, Employees> collect = employeesList.
                stream()
                .collect(Collectors.groupingBy(Employees::getPlace, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employees::getSalary)), Optional::get)));
        System.out.println(collect);
        //place and highest salary part 2
        Map<String, Employees> collect1 = employeesList.stream()
                .collect(Collectors.toMap(
                        Employees::getPlace,
                        emp -> emp,
                        (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2
                ));
        System.out.println(collect1);
        //place and highest salary part 3
        Map<String, Double> collect3 = employeesList.stream()
                .collect(Collectors.groupingBy(Employees::getPlace, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary)), optional -> optional.get().getSalary())));
        System.out.println(collect3);
        //place and highest salary part 4
        Map<String, Double> collect2 = employeesList.stream()
                .collect(Collectors.toMap(
                        Employees::getPlace,
                        Employees::getSalary,
                        (s1, s2) -> s1 > s2 ? s1 : s2
                ));
        System.out.println(collect2);
        //place and highest salary fetching names part 5
        Map<String, String> collect4 = employeesList.stream()
                .collect(Collectors.groupingBy(Employees::getPlace, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary)), optional -> optional.get().getName())));
        System.out.println(collect4);
        //place and highest salary fetching name part 6
        Map<String, String> collect5 = employeesList.stream()
                .collect(Collectors.toMap(
                        Employees::getPlace,
                        emp -> emp,
                        (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2
                )).entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getName()
                ));
        System.out.println(collect5);
        //place and list of names part 7
        Map<String, List<String>> collect6 = employeesList.stream()
                .collect(Collectors.groupingBy(Employees::getPlace, Collectors.mapping(Employees::getName, Collectors.toList())));
        System.out.println(collect6);
        //place and list of names part 8
        Map<String, List<String>> collect7 = employeesList.stream()
                .collect(Collectors.toMap(
                        Employees::getPlace,
                        emp -> new LinkedList<String>(Collections.singletonList(emp.getName())),
                        (existing,newone)->{
                            existing.addAll(newone);
                            return existing;
                        }
                        ));
        System.out.println(collect7);
        //place and second highest part 1
        Map<String, Double> collect8 = employeesList.stream()
                .collect(Collectors.groupingBy(Employees::getPlace
                        , Collectors.collectingAndThen(
                                Collectors.mapping(Employees::getSalary, Collectors.toList()),
                                salaries -> salaries.stream().sorted(Comparator.reverseOrder())
                                        .skip(1)
                                        .findFirst()
                                        .get()
                        )));
        System.out.println(collect8);
        //place and second highest part 2
        Map<String, Double> collect9 = employeesList.stream()
                .collect(Collectors.toMap(
                        Employees::getPlace,
                        emp -> new ArrayList<Double>(Collections.singletonList(emp.getSalary())),
                        (existing, newone) -> {
                            existing.addAll(newone);
                            return existing;
                        }
                )).entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().stream()
                                .sorted(Comparator.reverseOrder())
                                .skip(1)
                                .findFirst().get()
                ));
        System.out.println(collect9);
    }
}
