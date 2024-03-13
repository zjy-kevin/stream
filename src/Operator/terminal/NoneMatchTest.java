package Operator.terminal;

import java.util.stream.Stream;

public class NoneMatchTest {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        boolean b = integerStream.noneMatch(integer -> integer < 0);
        System.out.println(b);
    }
}
