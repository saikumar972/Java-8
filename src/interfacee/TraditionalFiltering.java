package interfacee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Book{
    private int id;
    private String name;
    private double amount;

    public Book(int id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
class BookData{
    public List<Book> bookList(){
        return Stream.of(new Book(1,"string",9000.00),
                new Book(2,"int",3000.90),
                new Book(3,"double",3000.00),
                new Book(5,"friends",6000.00),
                new Book(4,"data",3000.20),
                        new Book(4,"cad",3000.20),
                new Book(5,"friends",5000.00)).
                collect(Collectors.toList());
    }
}
class TraditionalFiltering {
    public static void main(String[] args) {
        List<Book> books= new BookData().bookList();
        Collections.sort(books,new MyComparator());
        System.out.println(books);
        Collections.sort(books,new Comparator<Book>(){

            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(books);
        books.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(books);
        System.out.println(books.stream().sorted(Comparator.comparingInt(Book::getId)).toList());
        System.out.println(books.stream().sorted(Collections.reverseOrder(Comparator.comparingDouble(Book::getAmount))).toList());
        System.out.println("------------map----------------------------------------------------");
        Map<Book,Integer> map=new HashMap<>();
        for(Book b:books){
            map.put(b,b.getId());
        }
        System.out.println(map);
        Map<Book,Integer> map1=new TreeMap<>((o1,o2)->o1.getName().compareTo(o2.getName()));
        for(Book b:books){
            map1.put(b,b.getId());
        }
        System.out.println(map1);
        Map<Book,Integer> map2=new HashMap<>();
        for(Book b:books){
            map2.put(b,b.getId());
        }
        map2.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Book::getId)))
                .forEach(System.out::println);
        //reverse of double
        map2.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey(Comparator.comparingDouble(Book::getAmount))))
                .forEach(System.out::print);
        System.out.println();
        System.out.println("------------------------All filters---------------------");
        List<Map.Entry<Book, Integer>> sorted = map2.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparingInt(Book::getId)
                        .thenComparing(Book::getName)
                        .thenComparingDouble(Book::getAmount))).toList();
        System.out.println(sorted);
    }
}
class MyComparator implements Comparator<Book>{

    @Override
    public int compare(Book o1, Book o2) {

        return Double.compare(o1.getAmount(),o2.getAmount());
    }
}
