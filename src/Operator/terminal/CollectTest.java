package Operator.terminal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("apple", "banana", "cherry", "date");
        List<String> collectedList = stream.collect(Collectors.toList());
        System.out.println("Collected List: " + collectedList);
    }
}
