package Operator.others;

import java.util.stream.Stream;

public class ConcatTest {
    public static void main(String[] args) {
        // 使用concat连接两个流
        Stream<String> combined = Stream.concat(Stream.of("a", "b"),Stream.of("c", "d"));
        combined.forEach(System.out::println);
    }
}
