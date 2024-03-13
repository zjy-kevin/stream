package collect;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingTest {
    public static void main(String[] args) {
        Long collect = Stream.of(1, 2, 3, 4).collect(Collectors.counting());
        System.out.println(collect);
    }
}
