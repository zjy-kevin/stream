package collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByTest {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> collect = Stream.of(1, 2, 3, 4).collect(Collectors.groupingBy(integer -> integer > 1));
        System.out.println(collect);
    }
}
