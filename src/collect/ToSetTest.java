package collect;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToSetTest {
    public static void main(String[] args) {
        Set<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toSet());
        System.out.println(collect);
    }
}
