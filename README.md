<a name="gm7Gc"></a>

# 使用流的好处

- 流更好阅读，一眼看上去就知道干什么
- 流遵循"做什么而非怎么做",因此我们有优化的空间
- 流不存储元素，元素在底层集合或按需生成
- 流操作不修改数据源，如：filter方法不会从新的流移除元素，而是会生成一个新的流，其中包括被过滤的元素
- 流操作都是尽可能惰性执行的，只有当需要结果时，操作才会执行
  <a name="lmOKM"></a>

# 一.流的创建操作

<a name="itNnx"></a>

## 1.1 Collection的stream方法创建集合

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
Stream<Integer> stream = list.stream();
stream.forEach(System.out::println);
```

<a name="qEYbM"></a>

## 1.2 Stream的静态方法创建流

Stream.of(T... values)<br />of方法具有可变长参数，因此我们可以构建具有任意数量引元的流

```java
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
integerStream.forEach(System.out::println);
```

Stream.empty();

```java
// 创建空流
Stream<String> emptyStream = Stream.empty();
```

<a name="NtIBp"></a>

## 1.3 Array数组创建

使用Array.stream（array，from，to）可以从数组中位于from（包括）和to（不包括）的元素中创建一个流。

```java
int[] intArr = {1, 2, 3, 4, 5};
IntStream stream1 = Arrays.stream(intArr, 0, 5);
stream1.forEach(System.out::println);
```

<a name="qzFj9"></a>

## 1.4 创建无限流

Stream接口有两个用于创建无限流的静态方法。generate方法会接受一个不包含任何引元的函数（或者从技术上讲，是一个Supplier<T>接口的对象）。
<a name="sRQsW"></a>

### generate

```java
 // 产生常量值的流
Stream<String> echos = Stream.generate(() -> "Echo");
// 获取一个随机数的流
Stream<Double> randoms = Stream.generate(Math::random);
```

<a name="CCAlg"></a>

### iterate

为了产生无限序列，例如0 12 3…，可以使用iterate方法。它会接受一个“种子”值，以及一个函数（从技术上讲，是一个UnaryOperation<T>），并且会反复地将该函数应用到之前的结果上.

```java
// iterate
Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
```

<a name="F7dBa"></a>

## 1.5 其他产生流的方法

<a name="erJDb"></a>

### 1.5.1 Pattern中splitAsStream方法

会按照某个正则表达式来分割一个CharSequence对象。可以使用下面的语句来将一个字符串分割为一个个的单词.

```java
 // Pattern
Stream<String> words = Pattern.compile("\\PL+").splitAsStream("hello word i am robot");
words.forEach(System.out::println);
```

<a name="QflLh"></a>

### 1.5.2 文件创建流

静态方法Files.lines()会返回一个包含文件中所有行的Stream

```java
String filepath = "D:\\ideaproject\\stream\\src\\CreateStream\\file.txt";
try(Stream<String> lines = Files.lines(Paths.get(filepath))){
    lines.forEach(System.out::println);
}catch (IOException e){
    e.printStackTrace();
}
```

<a name="MlkKa"></a>

# 二.常见的操作符

<a name="EuVnV"></a>

## 2.1 中间操作符

- 中间操作返回一个新的流。你可以在一个流上调用多个中间操作，它们会形成操作链。
- 中间操作不会立即执行，只有遇到终端操作时才会触发执行。（惰性操作）
  <a name="CeYUM"></a>

### filter

用于通过设置的条件过滤出元素

```java
List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
Stream<String> stringStream = list.stream().filter(string -> string.length() > 2);
stringStream.forEach(System.out::println);
```

<a name="Paiws"></a>

### map

接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映射成一个新的元素.<br />通常，我们想要按照某种方式来转换流中的值，此时，可以使用map方法并传递执行该转换的函数。

```java
List<String> list = Arrays.asList("MAN", "boy", "WOMEN");
// 将集合里面的元素全部改成大写
Stream<String> stringStream = list.stream().map(string -> string.toUpperCase());
stringStream.forEach(System.out::println);
```

<a name="iOyLH"></a>

### flatMap

使用flatMap方法的效果是，各个数组并不是分别映射成一个流，而是映射成流的内容。所有使用map(Arrays::stream)时生成的单个流都被合并起来，即扁平化为一个流

```java
// 创建一个包含多个单词的数组
String[] words = {"Hello", "World"};

// 使用flatMap将每个单词拆分为字符，然后合并为一个新的Stream
Stream<String> flatMapStream = Arrays.stream(words)
                .flatMap(word -> Arrays.stream(word.split("")));
        
// 打印合并后的Stream中的每个字符
flatMapStream.forEach(System.out::println);
```

在这个例子中，我们首先创建了一个包含多个单词的数组 words。然后使用 flatMap 方法将每个单词拆分为字符，并将这些字符合并为一个新的 Stream。最后，我们遍历打印了合并后的 Stream 中的每个字符。

<a name="U1aK1"></a>

### limit

会返回一个不超过给定长度的流

```java
// 随机生成10个数，用Limit限制最多10个
Stream<Double> limit = Stream.generate(Math::random).limit(10);
limit.forEach(System.out::println);
```

<a name="Kupo4"></a>

### skip

调用stream.skip（n）正好相反：它会丢弃前n个元素。这个方法在将文本分隔为单词时会显得很方便，因为按照split方法的工作方式，第一个元素是没什么用的空字符串。我们可以通过调用skip来跳过它

```java
Stream<String> stream = Arrays.asList("", "1", "2", "3").stream();
Stream<String> skip = stream.skip(2);
skip.forEach(System.out::println);
```

<a name="xpcSY"></a>

### distinct

去重，返回一个元素各异（根据流所生成元素的hashCode和equals方法实现）的流

```java
Stream<String> stringStream = Stream.of("jack", "jack", "jordan", "mike").distinct();
stringStream.forEach(System.out::println);
```

<a name="dOR7O"></a>
## 
<a name="TyIqS"></a>

### sorted

自然排序（从小到大），流中元素需实现Comparable接口。 例：list.stream().sorted()<br />对于流的排序，有多种sorted方法的变体可用。其中一种用于操作Comparable元素的流，而另一种可以接受一个Comparator。下面，我们对字符串排序，使得最长的字符串排在最前面：

```java
List<String> names = Arrays.asList("mike", "jacky", "tom");
// 最后使用reversed()反转结果
Stream<String> longestFirst = names.stream().sorted(Comparator.comparing(String::length).reversed());
longestFirst.forEach(System.out::println);
```

我们在对集合排序时可以不使用流。但是，当排序处理是流管道的一部分时，sorted方法就会显得很有用。

<a name="j5xPD"></a>

### peek

对元素进行遍历处理 <br />peek方法会产生另一个流，它的元素与原来流中的元素相同，但是在每次获取一个元素时，都会调用一个函数。这对于调试来说很方便

```java
 Object[] powers = Stream.iterate(1.0, p -> p * 2)
               .peek(e -> System.out.println("Fetching" + e))
               .limit(20).toArray();
```

当实际访问一个元素时，就会打印出来一条消息。通过这种方式，你可以验证iterate返回的无限流是被惰性处理的。
<a name="qcymE"></a>

## 2.2 终止操作符

<a name="fVt42"></a>

### collect

收集器，将流转换为其他形式

```java
Stream<String> stream = Stream.of("apple", "banana", "cherry", "date");
List<String> collectedList = stream.collect(Collectors.toList());
System.out.println("Collected List: " + collectedList);
```

<a name="qrOxc"></a>

### forEach

遍历流

```java
Stream<String> stringStream = Stream.of("abcd", "efg");
stringStream.forEach(System.out::println);
```

<a name="hX93T"></a>

### findFirst

findFirst返回的是非空集合中的第一个值。它通常会在与filter组合使用时显得很有用

```java
Stream<String> stringStream = Stream.of("abc", "TYU", "OPQ");
String res = stringStream.filter(str -> str.startsWith("O")).findFirst().get();
System.out.println(res);
```

<a name="RH3o4"></a>

### findAny

返回流中的任意元素

```java
Stream<String> stringStream = Stream.of("a", "b", "c");
String s = stringStream.findAny().get();
System.out.println(s);
```

<a name="fyuN1"></a>

### count

返回流中元素的个数

```java
Stream<String> stringStream = Stream.of("a", "b", "c","");
long count = stringStream.count();
System.out.println(count);
```

<a name="WFwtn"></a>

### sum

对流中内容求和

```java
Stream<String> integerStream = Stream.of("1", "2", "3", "4");
int sum = integerStream.mapToInt(Integer::parseInt).sum();
System.out.println(sum);
```

<a name="n0ISb"></a>

### max

对流中内容求最大值

```java
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
Integer max = integerStream.max(Integer::compareTo).get();
System.out.println(max);
```

<a name="lYkjK"></a>

### min

对流中内容求最小值

```java
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
Integer min = integerStream.min(Integer::compareTo).get();
System.out.println(min);
```

<a name="ypU04"></a>

### anyMatch

检查是否至少匹配一个元素，返回boolean

```
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
boolean b = integerStream.anyMatch(integer -> integer > 3);
System.out.println(b);
```

<a name="qmMPU"></a>

### allMatch

检查是否匹配所有元素，返回boolean

```java
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
boolean b = integerStream.allMatch(integer -> integer > 1);
System.out.println(b);
```

<a name="fvcE6"></a>

### noneMatch

检查是否没有匹配所有元素，返回boolean

```java
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
boolean b = integerStream.noneMatch(integer -> integer < 0);
System.out.println(b);
```

<a name="T4IG1"></a>

### reduce

可以将流中元素反复结合起来，得到一个值

```java
Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
Integer reduce = integerStream.reduce(0, (a, b) -> a + b);
System.out.println(reduce);
```

<a name="bKS9H"></a>

## 2.3 concat连接两个流

·static<T>Stream<T>concat（Stream<?extends T>a，Stream<?extends T>b）产生一个流，它的元素是a的元素后面跟着b的元素

```java
 // 使用concat连接两个流
Stream<String> combined = Stream.concat(Stream.of("a", "b"),Stream.of("c", "d"));
combined.forEach(System.out::println);
```

<a name="LmQLO"></a>

# 三.Collect收集

<a name="dF8DR"></a>

## toList

```java
 List<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toList());
 collect.forEach(System.out::println);
```

<a name="A9iat"></a>

## toMap

```java
Map<Integer, Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toMap(key -> key, value -> value * 2));
System.out.println(collect);
```

<a name="DtZsI"></a>

## toSet

```java
Set<Integer> collect = Stream.of(1, 2, 3, 4).collect(Collectors.toSet());
System.out.println(collect);
```

<a name="TxWz5"></a>

## counting

```java
Long collect = Stream.of(1, 2, 3, 4).collect(Collectors.counting());
System.out.println(collect);
```

<a name="Gd7eZ"></a>

## summingInt

```java
Integer collect = Stream.of(1, 2, 3, 4).collect(Collectors.summingInt(num -> num));
System.out.println(collect);
```

<a name="OJFj8"></a>

## minBy

```java
Integer min = Stream.of(1, 2, 3, 4).collect(Collectors.minBy(Integer::compareTo)).get();
System.out.println(min);
```

<a name="ExQ0r"></a>

## joining

```java
String collect = Stream.of(1, 2, 3, 4).map(Object::toString).collect(Collectors.joining("||"));
System.out.println(collect);
```

<a name="CrKrJ"></a>

## groupingBy

```java
Map<Boolean, List<Integer>> collect = Stream.of(1, 2, 3, 4).collect(Collectors.groupingBy(integer -> integer > 1));
System.out.println(collect);
```
