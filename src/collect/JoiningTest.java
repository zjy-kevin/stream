package collect;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningTest {
    public static void main(String[] args) {
        String collect = Stream.of(1, 2, 3, 4).map(Object::toString).collect(Collectors.joining("||"));
        System.out.println(collect);
    }
}
