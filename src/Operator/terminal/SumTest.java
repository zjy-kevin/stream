package Operator.terminal;

import java.util.stream.Stream;

public class SumTest {
    public static void main(String[] args) {
        Stream<String> integerStream = Stream.of("1", "2", "3", "4");
        int sum = integerStream.mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
    }
}
