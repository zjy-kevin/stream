package Operator.terminal;

import java.util.stream.Stream;

public class AllMatchTest {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        boolean b = integerStream.allMatch(integer -> integer > 1);
        System.out.println(b);
    }
}
