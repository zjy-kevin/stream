package Operator.terminal;

import java.util.stream.Stream;

public class ReduceTest {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Integer reduce = integerStream.reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }
}
