package Operator.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("MAN", "boy", "WOMEN");
        // 将集合里面的元素全部改成大写
        Stream<String> stringStream = list.stream().map(string -> string.toUpperCase());
        stringStream.forEach(System.out::println);
    }
}
