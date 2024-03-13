package Operator.mid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortedTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("mike", "jacky", "tom");
        // 最后使用reversed()反转结果
        Stream<String> longestFirst = names.stream().sorted(Comparator.comparing(String::length).reversed());
        longestFirst.forEach(System.out::println);
    }
}
