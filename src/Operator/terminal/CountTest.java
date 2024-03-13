package Operator.terminal;

import java.util.stream.Stream;

public class CountTest {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("a", "b", "c","");
        long count = stringStream.count();
        System.out.println(count);
    }
}
