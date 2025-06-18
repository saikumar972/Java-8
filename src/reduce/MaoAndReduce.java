package reduce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student{
    private int id;
    private String name;
    private char grade;
    private double marks;

    public Student(int id, String name, char grade, double marks) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.marks = marks;
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

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", marks=" + marks +
                '}';
    }
}
class StudentData{
    public static List<Student> studentList(){
        return Stream.of(new Student(1,"sai",'A',400.23),
                new Student(4,"sfs",'A',400.23),
                new Student(3,"fsg",'A',500.75),
                new Student(2,"wgeh",'B',900.53)).collect(Collectors.toList());
    }
}
public class MaoAndReduce {
    public static void main(String[] args) {
        List<Integer> list=List.of(1,2,6,34,55);
        //traditional approach
        int sum=0;
        for(int k:list){
            sum=sum+k;
        }
        System.out.println(sum);
        //stream provided sum reduction method
        int sum2=list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum2);
        int sum3=list.stream().mapToInt(i->i).sum();
        System.out.println(sum2);
        //reduce
        int sum1=list.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum1);
        int sum4=list.stream().reduce( Integer::sum).get();
        System.out.println(sum4);
        //max
        int max=list.stream().reduce((a,b)->a>b?a:b).get();
        System.out.println(max);
        int max1=list.stream().reduce(Integer::max).get();
        System.out.println(max1);
        List<String> stringList=List.of("sai","java","intellij");
        String maxstring=stringList.stream().reduce((a,b)->a.length()>b.length()?a:b).get();
        System.out.println(maxstring);
        System.out.println("-----------------------------");
        Double k=StudentData.studentList().stream().filter(student->student.getGrade()=='A')
                .map(Student::getMarks).mapToDouble(i->i).reduce(Double::sum).getAsDouble();
        System.out.println(k);
        Double k4=StudentData.studentList().stream().filter(student->student.getGrade()=='A')
                .map(Student::getMarks).mapToDouble(i->i).average().orElse(0);
        System.out.println(k4);
        Double k2=StudentData.studentList().stream().filter(student->student.getGrade()=='A')
                .map(Student::getMarks).reduce(Double::sum).orElse(000.00);
        System.out.println(k2);
        Double k1=StudentData.studentList().stream().filter(student->student.getGrade()=='A')
                .map(Student::getMarks).mapToDouble(i->i).average().getAsDouble();
        System.out.println(k1);
        Double k3=StudentData.studentList().stream().filter(student->student.getGrade()=='A')
                .map(Student::getMarks).mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(k3);
    }
}
