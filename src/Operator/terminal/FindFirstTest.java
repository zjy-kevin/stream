package Operator.terminal;

import java.util.stream.Stream;

public class FindFirstTest {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("abc", "TYU", "OPQ");
        String res = stringStream.filter(str -> str.startsWith("O")).findFirst().get();
        System.out.println(res);
    }
}
