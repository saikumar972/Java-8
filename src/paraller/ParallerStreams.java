package paraller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallerStreams {
    public static void main(String[] args) {
        long start1=System.currentTimeMillis();
        IntStream.range(1,1000000000).sum();
        long end1=System.currentTimeMillis();
        System.out.println("time taken in first range "+(end1-start1));
        long start2=System.currentTimeMillis();
        IntStream.range(1,1000000000).parallel().sum();
        long end2=System.currentTimeMillis();
        System.out.println("time taken in parallel flow on streams "+(end2-start2));
        /*IntStream.range(1,10).forEach(x->System.out.println("Thread names "+Thread.currentThread().getName()+" "+x));
        IntStream.range(1,10).parallel().forEach(x->System.out.println("Thread names "+Thread.currentThread().getName()+" "+x));
        System.out.println("----------------");*/

        List<Employee> list= new ArrayList<>();
        for(int i=0;i<999999;i++){
            list.add(new Employee(i,"employee"+i, Double.valueOf(new Random().nextInt(100*100))));
        }
        long start4=System.currentTimeMillis();
        double avg=list.stream().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
        System.out.println(avg);
        long end4=System.currentTimeMillis();
        System.out.println("time taken to calculate average in type1 "+(end4-start4));
        long start5=System.currentTimeMillis();
        double avg2=list.parallelStream().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
        System.out.println(avg2);
        long end5=System.currentTimeMillis();
        System.out.println("time taken to calculate average in paralleltype "+(end5-start5));
    }

}
class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
