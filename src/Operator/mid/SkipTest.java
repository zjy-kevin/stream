package Operator.mid;

import java.util.Arrays;
import java.util.stream.Stream;

public class SkipTest {
    public static void main(String[] args) {
        Stream<String> stream = Arrays.asList("", "1", "2", "3").stream();
        Stream<String> skip = stream.skip(2);
        skip.forEach(System.out::println);
    }
}
