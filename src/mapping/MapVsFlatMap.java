package mapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    private int id;
    private String name;
    private List<String> numbers;

    public Employee(int id, String name, List<String> numbers) {
        this.id = id;
        this.name = name;
        this.numbers = numbers;
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

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}
class ListofEmployees{
    public static List<Employee> ListofEmployees(){
        return Stream.of(new Employee(1,"sai",List.of("112144","1413413423","2342323")),
                        new Employee(2,"khaleja",List.of("45645457","8767096r75","2424635")),
                        new Employee(6,"athadu",List.of("2353445","447468","46457475")),
                        new Employee(0,"one",List.of("2534654856","36574856","3434645747")))
                        .collect(Collectors.toList());
    }
}
public class MapVsFlatMap {
    public static void main(String[] args) {
        List<Employee> list=ListofEmployees.ListofEmployees();
        System.out.println(list);
        System.out.println(list.stream().map(Employee::getNumbers).toList());
        System.out.println(list.stream().flatMap(employee -> employee.getNumbers().stream()).toList());
    }
}
