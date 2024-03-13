package Operator.terminal;

import java.util.stream.Stream;

public class MaxTest {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Integer max = integerStream.max(Integer::compareTo).get();
        System.out.println(max);
    }
}
