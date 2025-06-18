package exceptions;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ExceptionStreams {
    public static void main(String[] args) {
        List<String> stringList=List.of("12","23","45");
        stringList.forEach(k-> System.out.println(Integer.parseInt(k)));
        //approach 1
        List<String> stringList1=List.of("12","23","xyz");
        stringList1.forEach(k->{
            try{
                System.out.println(Integer.parseInt(k));
            }catch (Exception e){
                System.out.println("Exception is :"+e.getMessage());
            }
        });
        //approach 2 create a method that handles exception
        List<String> stringList2=List.of("12","23","abc");
        stringList2.forEach(ExceptionStreams::handleException);
        //approach 3 passing consumer interface as parameter to method
        List<String> stringList3=List.of("12","23","sai");
        stringList3.forEach(handleException2(k->System.out.println(Integer.parseInt(k))));
        //approach 4 passing anytype of values
        List<String> stringList4=List.of("12","23","sai");
        stringList3.forEach(handleException3(k->System.out.println(Integer.parseInt(k)),NumberFormatException.class));
        List<Integer> numList=List.of(1,0);
        numList.forEach(handleException3(k-> System.out.println(10/k), ArithmeticException.class));
    }
    static void handleException(String k){
        try{
            System.out.println(Integer.parseInt(k));
        }catch (Exception e){
            System.out.println("Exception is :"+e.getMessage());
        }
    }
    static Consumer<String>  handleException2(Consumer<String>  k){
        return something-> {
            try {
                 k.accept(something);
            } catch (Exception e) {
                System.out.println("Exception is :" + e.getMessage());
            }
        };
    }
    static <Target, ExObj extends Exception> Consumer<Target> handleException3(Consumer<Target> targetConsumer,Class<ExObj> exObjClass){
        return something->{
            try{
                targetConsumer.accept(something);
            }catch (Exception e){
                try{
                    ExObj exObj=exObjClass.cast(e);
                    System.out.println(exObj.getMessage());
                }catch (ClassCastException e1){
                    throw e1;
                }
            }
        };
    }
}

