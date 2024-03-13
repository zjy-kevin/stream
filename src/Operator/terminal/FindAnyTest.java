package Operator.terminal;

import java.util.stream.Stream;

public class FindAnyTest {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        String s = stringStream.findAny().get();
        System.out.println(s);
    }
}
