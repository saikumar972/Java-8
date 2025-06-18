package groupingBy;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    private int id;
    private String name;
    private String place;
    private String job;
    private double salary;

    public Employee(int id, String name, String place, String job, double salary) {
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
class EmployeeDatabase{
    public static List<Employee> employeeList(){
        return Stream.of(new Employee(1,"rao","ap","se",1200),
                new Employee(2,"bahu","ap","gold",1200),
                new Employee(3,"tik","tg","se",5666),
                new Employee(4,"tok","karnataka","se",4344),
                new Employee(7,"whatsapp","ap","silver",466767),
                new Employee(6,"fb","tg","diamond",24532),
                new Employee(9,"jio","karnataka","se",8900),
                new Employee(10,"aircel","ap","se",12300),
                new Employee(5,"voda","tg","business",9000))
                .collect(Collectors.toList());
    }
}
public class Example2 {
    public static void main(String[] args) {
        List<Employee> employeeList=EmployeeDatabase.employeeList();
        //filter by salary range
        System.out.println("Filter by salary range");
        List<Employee> list = employeeList.stream()
                .filter((emp) -> emp.getSalary() > 5000 && emp.getSalary() < 10000)
                .toList();
        System.out.println(list);
        //find who is in ap and sort by name
        System.out.println("Filter by ap and sort by their names");
        List<Employee> list1 = employeeList.stream()
                .filter((emp) -> emp.getPlace().equals("ap"))
                .sorted(Comparator.comparing(Employee::getName).reversed())
                //.sorted(Comparator.comparing(Employee::getName,comparator.reversed())
                .toList();
        System.out.println(list1);
        //find all names
        System.out.println("Getting all the names");
        List<String> list2 = employeeList.stream()
                .map(Employee::getName)
                .distinct()
                .toList();//or collect(Collectors.toSet() also removes duplicates
        System.out.println(list2);
        //group by job
        System.out.println("Group by job");
        Map<String, List<Employee>> list4 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getJob));
        System.out.println(list4);
        //how many in job wise
        System.out.println("Group by job and count");
        Map<String, Long> list5 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getJob,Collectors.counting()));
        System.out.println(list5);
        //max of job employees
        System.out.println("Group by job and fetching which job has highest count in way1");
        Map.Entry<String, Long> list6 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getJob, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .findFirst()
                .get();
        System.out.println(list6);
        //getting max in other way
        System.out.println("Group by job and fetching which job has highest count in way2");
        Map.Entry<String, Long> list7 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getJob, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println(list7);
        //average salary of ap and tg
        System.out.println("Average salary in place wise");
        Map<String, Double> list8 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getPlace, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(list8);
        //lowest salary in each place
        System.out.println("lowest salary in each place");
        Map<String, Optional<Employee>> list9 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getPlace, Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(list9);
        //employee with 2nd high pay
        System.out.println("fetching second highest pay");
        Employee list10 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst().get();
        System.out.println(list10);
        //place lo max salary
        System.out.println("fetching highest salary in each place wise");
        Map<String, Optional<Double>> collect = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getPlace,
                                Collectors.mapping(Employee::getSalary,
                                        Collectors.maxBy(Comparator.naturalOrder())))
                );
        System.out.println(collect);
        //in case of only double
        System.out.println("fetching highest salary in each place wise and making double");
        Map<String, Double> collect1 = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getPlace,
                                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                        optional -> optional.map(Employee::getSalary).get())));
        System.out.println(collect1);
        //even simple
        System.out.println("fetching highest salary in each place wise and making double in simple manner");
        Map<String, Double> maxSalariesByPlace = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getPlace,
                        Employee::getSalary,
                        Double::max
                ));
        System.out.println(maxSalariesByPlace);
        //getting the salary of which place has maximum
        System.out.println("max salary in a place");
        Map.Entry<String, Double> stringDoubleEntry = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getPlace,
                        Employee::getSalary,
                        Double::max
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Double>comparingByValue().reversed())
                .findFirst().get();
        System.out.println(stringDoubleEntry);
        //grouping place and name
        System.out.println("grouping place and corresponding name");
        Map<String, List<String>> samples = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getPlace, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(samples);
        //grouping by place and the name having max length
        System.out.println("grouping by place and corresponding max length");
        Map<String, String> collect2 = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getPlace,
                        Employee::getName,
                        (o1, o2) -> o1.length() > o2.length()?o1:o2
                ));
        System.out.println(collect2);
        //grouping by name and place
        System.out.println("grouping by name and place");
        Map<String, String> collect3 = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        Employee::getPlace
                ))
                .entrySet()
                .stream().sorted(Map.Entry.<String,String>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        System.out.println(collect3);
        // Grouping by place and collecting names in a list
        System.out.println("Grouping by place and collecting names as a List");
        Map<String, List<String>> collect4 = employeeList.stream()
                .collect(Collectors.toMap(
                        Employee::getPlace,                     // Key: place
                        employee -> new ArrayList<>(List.of(employee.getName())), // Value: list with a single name
                        (existing, replacement) -> {            // Merge function: append name to the list
                            existing.addAll(replacement);
                            return existing;
                        }
                ));

        System.out.println(collect4);

    }
}
