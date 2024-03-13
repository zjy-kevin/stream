package Operator.terminal;

import java.util.stream.Stream;

public class ForEachTest {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("abcd", "efg");
        stringStream.forEach(System.out::println);

    }
}
