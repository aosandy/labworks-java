package lab5;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Algorithms {
    public static double getAverage(List<Integer> list) {
        OptionalDouble average =  list.stream()
                .mapToInt(Integer::intValue)
                .average();
        return average.isPresent() ? average.getAsDouble() : 0.0;
    }

    public static List<String> modifyStrings(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .map(str -> "_new_" + str)
                .collect(Collectors.toList());
    }

    public static List<Integer> getSquaresOfUnique(List<Integer> list) {
        return list.stream()
                .filter(i -> Collections.frequency(list, i) == 1)
                .map(i -> i * i)
                .collect(Collectors.toList());
    }

    public static <C extends Collection<String>> C getStringsByFirstLetter(C collection, char letter, Supplier<C> supplier) {
        return collection.stream()
                .filter(str -> !str.isEmpty())
                .filter(str -> str.charAt(0) == Character.toLowerCase(letter)
                        || str.charAt(0) == Character.toUpperCase(letter))
                .sorted(Comparator.comparing(String::toUpperCase))
                .collect(Collectors.toCollection(supplier));
    }

    public static <T> T checkLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(NoSuchElementException::new);
    }

    public static int getSumOfEven(int[] array) {
        return Arrays.stream(array)
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Map<Character, String> transformToMap(List<String> list) {
        return list.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toMap(str -> str.charAt(0), str -> str.substring(1),
                        (str, replacement) -> str));
    }
}
