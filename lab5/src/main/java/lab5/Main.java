package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 6, 1, 3, 6};
        List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        List<String> strList = new ArrayList<>(List.of("Gamma", "Alpha", "Beta", "apple", "Text", "BBB"));
        List<String> strEmptyList = new ArrayList<>(List.of());

        System.out.println("Integer list: " + intList);
        System.out.println("Average of integer list: " + Algorithms.getAverage(intList) + "\n");

        List<String> newStrList = Algorithms.modifyStrings(strList);
        System.out.println("String list: " + strList);
        System.out.println("Modified list: " + newStrList + "\n");

        System.out.println("Integer list: " + intList);
        System.out.println("Squares of unique list: " + Algorithms.getSquaresOfUnique(intList) + "\n");

        newStrList = Algorithms.getStringsByFirstLetter(strList, 'a', ArrayList::new);
        System.out.println("String list: " + strList);
        System.out.println("List of strings by first letter 'a': " + newStrList + "\n");

        System.out.println("String list: " + strList);
        System.out.println("Last element: " + Algorithms.checkLastElement(strList) + "\n");
        try {
            String last = Algorithms.checkLastElement(strEmptyList);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        System.out.println("Integer list: " + intList);
        System.out.println("Sum of even: " + Algorithms.getSumOfEven(intArray) + "\n");

        Map<Character, String> map = Algorithms.transformToMap(strList);
        System.out.println("String list: " + strList);
        System.out.println("Map: " + map);
    }
}
