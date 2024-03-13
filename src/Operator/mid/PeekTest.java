package Operator.mid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PeekTest {
    public static void main(String[] args) {
       Object[] powers = Stream.iterate(1.0, p -> p * 2)
               .peek(e -> System.out.println("Fetching" + e))
               .limit(20).toArray();
    }
}
