package Operator.mid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        Stream<String> stringStream = list.stream().filter(string -> string.length() > 2);
        stringStream.forEach(System.out::println);
    }
}
