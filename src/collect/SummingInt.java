package collect;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummingInt {
    public static void main(String[] args) {
        Integer collect = Stream.of(1, 2, 3, 4).collect(Collectors.summingInt(num -> num));
        System.out.println(collect);
    }
}
