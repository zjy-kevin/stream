package Operator.mid;

import java.util.stream.Stream;

public class DistinctTest {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("jack", "jack", "jordan", "mike").distinct();
        stringStream.forEach(System.out::println);
    }
}
