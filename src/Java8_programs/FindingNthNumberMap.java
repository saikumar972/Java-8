package Java8_programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    private int id;
    private String name;
    private double fees;
    //private List<String> subjects;

    public Employee(int id, String name, double fees) {
        this.id = id;
        this.name = name;
        this.fees = fees;
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

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fees=" + fees +
                '}';
    }
}
class Database{
    static Map<Employee,Integer> database(){
        Map<Employee,Integer> map=new HashMap<>();
        map.put(new Employee(1,"ok",2322.234),1);
        map.put(new Employee(2,"sare",343.11),67);
        map.put(new Employee(3,"rajveer",9997.22),90);
        map.put(new Employee(4,"laptop",8899.22),798);
        return map;
    }
}
class Database2{
    static Map<Employee,Integer> database(){
        Map<Employee,Integer> map=new HashMap<>();
        map.put(new Employee(1,"ok",2322.234),1);
        map.put(new Employee(2,"sare",9997.22),67);
        map.put(new Employee(3,"rajveer",9997.22),67);
        map.put(new Employee(4,"laptop",8899.22),798);
        return map;
    }
}

public class FindingNthNumberMap {
    public static void main(String[] args) {
        Map<Employee,Integer> map=Database.database();
        System.out.println(map);
        //find 2nd highest fees
        Map.Entry<Employee, Integer> second = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey(Comparator.comparingDouble(Employee::getFees))))
                .toList()
                .get(1);
        System.out.println(second);
        //2nd approach
        Map<Employee,Integer> map2=Database2.database();
        Map.Entry<Integer, List<Employee>> second2 = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList().get(1);
        System.out.println(second2);
        //fees grouping
        map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(event -> event.getKey().getFees(), Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))  // Sort by fees in descending order
                .skip(1)  // Skip the highest fees
                .flatMap(entry -> entry.getValue().entrySet().stream()) // Flatten the grouped map to get Employee-Integer pairs
                .findFirst()  // Get the second-highest entry
                .orElseThrow(() -> new RuntimeException("No second-highest found!"));
        //System.out.println(collect);
    }
}