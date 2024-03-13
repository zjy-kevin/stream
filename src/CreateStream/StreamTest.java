package CreateStream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        // 创建空流
        Stream<String> emptyStream = Stream.empty();

        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Stream<String> paralleStream = list.parallelStream();
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        int[] intArr = {1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(intArr, 0, 5);

        // 产生常量值的流
        Stream<String> echos = Stream.generate(() -> "Echo");
        // 获取一个随机数的流
        Stream<Double> randoms = Stream.generate(Math::random);

        // Pattern
        Stream<String> words = Pattern.compile("\\PL+").splitAsStream("hello word i am robot");
        words.forEach(System.out::println);

        // File
        String filepath = "D:\\ideaproject\\stream\\src\\CreateStream\\file.txt";
        try(Stream<String> lines = Files.lines(Paths.get(filepath))){
            lines.forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
