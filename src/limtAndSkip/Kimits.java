package limtAndSkip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Kimits {
    public static void main(String[] args) throws IOException {
        List<Integer> list= Arrays.asList(1,3,4,3,5,3,1);
        System.out.println(list.stream().skip(2)
                .limit(3)
                .toList());
        //samething performing on data
        List<String> list1= Files.readAllLines(Paths.get("src/data.txt"));
        list1.stream().skip(1)
                .limit(3)
                .toList().forEach(System.out::println);
    }
}
