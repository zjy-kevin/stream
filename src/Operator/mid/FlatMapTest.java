package Operator.mid;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        String[] words = {"Hello", "World"};

        Stream<String> flatMapStream = Arrays.stream(words)
                .flatMap(word -> Arrays.stream(word.split("")));

        flatMapStream.forEach(System.out::println);
    }
}
