CN1-Stream
======================

![img](https://release-badges-generator.vercel.app/api/releases.svg?user=diamonddevgroup&repo=cn1-stream&gradient=238636,238636)
[![License](https://img.shields.io/github/license/tubone24/release-badges-generator.svg)](LICENSE)

A lightweight Stream API from Java 8 rewritten on iterators for Codename One. Adapted from LSA, refactored, and cleaned up for CN1 compatibility.


### Includes

 + Functional interfaces (`Supplier`, `Function`, `Consumer` etc);
 + `Stream`/`IntStream`/`LongStream`/`DoubleStream` (without parallel processing, but with a variety of additional methods and with custom operators);
 + `Optional`/`OptionalBoolean`/`OptionalInt`/`OptionalLong`/`OptionalDouble` classes;
 + `Exceptional` class - functional way to deal with exceptions;
 + `Objects` from Java 7.


### Usage

```java
Stream.of(/* array | list | set | map | anything based on Iterator/Iterable interface */)
    .filter(..)
    .map(..)
    ...
    .sorted()
    .forEach(..);
Stream.of(value1, value2, value3)...
IntStream.range(0, 10)...
```

## Key features

### Custom operators

Unlike Java 8 streams, CN1-Stream provides the ability to apply custom operators.

```java
Stream.of(...)
    .custom(new Reverse<>())
    .forEach(...);

public final class Reverse<T> implements UnaryOperator<Stream<T>> {

    @Override
    public Stream<T> apply(Stream<T> stream) {
        final Iterator<? extends T> iterator = stream.getIterator();
        final ArrayDeque<T> deque = new ArrayDeque<T>();
        while (iterator.hasNext()) {
            deque.addFirst(iterator.next());
        }
        return Stream.of(deque.iterator());
    }
}
```


### Additional operators

In addition to back-ported Java 8 Stream operators, the library provides:

- `filterNot` - negated `filter` operator

  ```java
  // Java 8
  stream.filter(((Predicate<String>) String::isEmpty).negate())
  // CN1-Stream
  stream.filterNot(String::isEmpty)
  ```

- `select` - filters instances of the given class

  ```java
  // Java 8
  stream.filter(Integer.class::isInstance)
  // CN1-Stream
  stream.select(Integer.class)
  ```

- `withoutNulls` - filters only not null elements

  ```java
  Stream.of("a", null, "c", "d", null)
      .withoutNulls() // [a, c, d]
  ```

- `sortBy` - sorts by extractor function

  ```java
  // Java 8
  stream.sorted(Comparator.comparing(Person::getName))
  // CN1-Stream
  stream.sortBy(Person::getName)
  ```

- `groupBy` - groups by extractor function

  ```java
  // Java 8
  stream.collect(Collectors.groupingBy(Person::getName)).entrySet().stream()
  // CN1-Stream
  stream.groupBy(Person::getName)
  ```

- `chunkBy` - partitions sorted stream by classifier function

  ```java
  Stream.of("a", "b", "cd", "ef", "gh", "ij", "klmnn")
      .chunkBy(String::length) // [[a, b], [cd, ef, gh, ij], [klmnn]]
  ```

- `sample` - emits every n-th elements

  ```java
  Stream.rangeClosed(0, 10)
      .sample(2) // [0, 2, 4, 6, 8, 10]
  ```

- `slidingWindow` - partitions stream into fixed-sized list and sliding over the elements

  ```java
  Stream.rangeClosed(0, 10)
      .slidingWindow(4, 6) // [[0, 1, 2, 3], [6, 7, 8, 9]]
  ```

- `takeWhile` / `dropWhile` - introduced in Java 9, limits/skips stream by predicate function

  ```java
  Stream.of("a", "b", "cd", "ef", "g")
      .takeWhile(s -> s.length() == 1) // [a, b]
  Stream.of("a", "b", "cd", "ef", "g")
      .dropWhile(s -> s.length() == 1) // [cd, ef, g]
  ```

- `scan` - iteratively applies accumulation function and returns Stream

  ```java
  IntStream.range(1, 6)
      .scan((a, b) -> a + b) // [1, 3, 6, 10, 15]
  ```

- `indexed` - adds an index to every element, result is `IntPair`

  ```java
  Stream.of("a", "b", "c")
      .indexed() // [(0 : "a"), (1 : "b"), (2 : "c")]
  ```

- `filterIndexed` / `mapIndexed` / `takeWhileIndexed` / `takeUntilIndexed` / `dropWhileIndexed` / `reduceIndexed` / `forEachIndexed` - indexed specialization of operators

  ```java
  Stream.of("a", "b", "c")
      .mapIndexed((i, s) -> s + Integer.toString(i)) // [a0, b1, c2]
  ```


### Throwable functions

No more ugly try/catch in lambda expressions.

```java
// Java 8
stream.map(file -> {
    try {
        return new FileInputStream(file);
    } catch (IOException ioe) {
        return null;
    }
})
// CN1-Stream
stream.map(Function.Util.safe(FileInputStream::new))
```


## JavaDocs
View the project [JavaDoc](https://diamondobama.github.io/apidocs/CN1-Stream)


## Download

Download [latest release](https://github.com/diamonddevgroup/CN1-Stream/releases) into your `lib` folder,
or grab via CN1 Extensions Library in Codename One Control Center.

Do `Refresh Libs` after downloading.


## License

MIT License

Copyright (c) 2021 Diamond Dev Group

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
