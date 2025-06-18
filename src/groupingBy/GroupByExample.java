package groupingBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Student{
    private int id;
    private String name;
    private int fees;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFees() {
        return fees;
    }

    public Student(int id, String name, int fees) {
        this.id = id;
        this.name = name;
        this.fees = fees;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fees=" + fees +
                '}';
    }
}
class StudentDatabase{
    public static Map<Student,Integer> studentData(){
        Map<Student,Integer> map=new HashMap<>();
        map.put(new Student(1,"sai",2000),12);
        map.put(new Student(2,"rajveer",2000),121);
        map.put(new Student(3,"war",3000),122);
        map.put(new Student(4,"bang",4000),125);
        map.put(new Student(5,"fight",2000),126);
        map.put(new Student(6,"fin",3000),612);
        return map;
    }
}
public class GroupByExample {
    public static void main(String[] args) {
        Map<Student,Integer> map= StudentDatabase.studentData();
        //general grouping
        Map<Integer, List<Map.Entry<Student, Integer>>> collect = map.entrySet().stream()
                .collect(Collectors.groupingBy((k) -> k.getKey().getFees()));
        System.out.println(collect);
        //i just want only names
        Map<Integer, List<String>> collect1 = map.entrySet().stream()
                .collect(Collectors.groupingBy((k) -> k.getKey().getFees(), Collectors.mapping((k) -> k.getKey().getName(), Collectors.toList())));
        System.out.println(collect1);
        //i want the result in treemap
        TreeMap<Integer, List<String>> collect2 = map.entrySet().stream()
                .collect(Collectors.groupingBy((k) -> k.getKey().getFees(), TreeMap::new, Collectors.mapping((k) -> k.getKey().getName(), Collectors.toList())));
        System.out.println(collect2);
        //nested groupBy i mean i want name and also name length
        TreeMap<Integer, Map<Integer, List<String>>> collect3 = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy((entry) -> entry.getKey().getFees(), TreeMap::new, Collectors.groupingBy((entry) -> entry.getKey().getName().length(), Collectors.mapping((entry) -> entry.getKey().getName(), Collectors.toList()))));
        System.out.println(collect3);

    }
}
