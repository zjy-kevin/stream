package collect;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToListTest {
    public static void main(String[] args) {
        List<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
