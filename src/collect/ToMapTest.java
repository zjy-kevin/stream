package collect;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toMap(key -> key, value -> value * 2));
        System.out.println(collect);
    }
}
