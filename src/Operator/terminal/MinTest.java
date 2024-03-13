package Operator.terminal;

import java.util.stream.Stream;

public class MinTest {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        Integer min = integerStream.min(Integer::compareTo).get();
        System.out.println(min);
    }
}
