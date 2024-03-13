package Operator.mid;

import java.util.stream.Stream;

public class LimitTest {
    public static void main(String[] args) {
        // 随机生成10个数，用Limit限制最多10个
        Stream<Double> limit = Stream.generate(Math::random).limit(10);
        limit.forEach(System.out::println);
    }
}
