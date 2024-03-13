package collect;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinByTest {
    public static void main(String[] args) {
        Integer min = Stream.of(1, 2, 3, 4).collect(Collectors.minBy(Integer::compareTo)).get();
        System.out.println(min);
    }
}
