package Operator.terminal;

import java.util.stream.Stream;

public class AnyMatchTest {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        boolean b = integerStream.anyMatch(integer -> integer > 3);
        System.out.println(b);
    }
}
