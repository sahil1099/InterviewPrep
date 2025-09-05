package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsProblems {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //1 Find the longest string in a list of strings using Java streams:
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");


        //strings.stream().max(Comparator.comparingInt(String::length)).get();

        String longestString = strings.stream()
                .max(Comparator.comparingInt(String::length)).get();

        System.out.println("1 - " + longestString);

        //2 find element which starts with 'a' or 'c' and
        // return the map<String,Long> which holds fruit as key and number of times it occurred in the list
        Map<String, Long> map1 = strings.stream().filter(s-> (s.startsWith("a") || s.startsWith("c"))).collect(Collectors.groupingBy(s->s, Collectors.counting()));

        List<String> stringList = Arrays

                .asList("apple", "apple", "cherry", "date", "grapefruit");

        System.out.println("2- a- " + map1);

        //stringList.stream().filter(s->s.startsWith("a") || s.startsWith("c")).collect(Collectors.groupingBy(s->s, Collectors.counting()));

        // result = [apple : 2, cherry:1]

        Map<String, Long> map = stringList.stream().
                filter(fruit -> (fruit.startsWith("a") || fruit.startsWith("c")))
                .collect(Collectors.groupingBy(s->s,Collectors.counting()));

        System.out.println("2- b -" + map);


        /*//3  Calculate the average age of a list of Person objects using Java streams
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

        //persons.stream().mapToInt(Person::getAge).average();

        Double avg_age = persons.stream().
                mapToInt(Person::getAge).
                average()
                .orElse(0);

        System.out.println(avg_age);*/

        //4 Merge two sorted lists into a single sorted list using Java streams:

        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        /*Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());*/

        //Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());

        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(mergedList);


        // distinct sorted list
        List<Integer> distictSortedList = Arrays.asList(4,2,8,3,1,2,5,6,1);

        //distictSortedList.stream().distinct().sorted().collect(Collectors.toList());

        List<Integer> collect = distictSortedList.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println("distinct sorted list" + collect);

        //5 Find the intersection of two lists using Java streams:
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);

        //list3.stream().filter(num-> list4.contains(num)).collect(Collectors.toList());


        //list3.stream().filter(list4::contains).collect(Collectors.toList());

        List<Integer> intersectionOfList = list3.stream()
                .filter(list4::contains)
                .collect(Collectors.toList());

        System.out.println(intersectionOfList);

        //6 Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        //numbersWithDuplicates.stream().distinct().collect(Collectors.toList());

        List<Integer> list = numbersWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(list);

        //7 Given a list of transactions, find the sum of transaction amounts for each day using Java streams:

        /*List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, IntSummaryStatistics> collect1 = transactions.stream().collect(Collectors.groupingBy(Transaction::getDate, Collectors.summarizingInt(Transaction::getAmount)));

        //System.out.println(sum2);

        Map<String, Integer> sumByDay = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));

        System.out.println(sumByDay);*/

        //8. Find the kth smallest element in an array using Java streams:
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element

        int val =  Arrays.stream(array)
                .sorted()
                .skip(k-1)
                .findFirst().getAsInt();

        System.out.println(val);

        //9. Implement a method to partition a list into two groups based on a predicate using Java streams:

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> map2 = numbers.stream()
                .collect(Collectors.partitioningBy(i->i%2==0));

        System.out.println("even list is " + map1.get(true));
        System.out.println("odd list is " + map1.get(false));

        //10. do the square of each number
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        //number.stream().map(num-> num*num).collect(Collectors.toList());

        List <Integer> sqList = number.stream()
                .map(value-> value*value)
                .collect(Collectors.toList());

        System.out.println(sqList);

        //11. Use Stream API to find the length of the longest name in the list. Expected Output: 7
        List<String> names = Arrays.asList("Alice", "Bob", "Charli", "David", "Eva");
        //names.stream().max(s-> Comparator.comparingInt()).get()
        //names.stream().mapToInt(String::length).sorted().skip(names.size()-1).sum();
        int  longest = names.stream().mapToInt(String::length).sorted().skip(names.size()-1).findFirst().getAsInt();

        System.out.println(longest);

        int longestName = names.stream()
                .max(Comparator.comparingInt(String::length)).get().length();

        System.out.println(longestName);

        //12. lenght of the longest name
        int length = names.stream()
                .max(Comparator.comparingInt(String::length)).get().length();

        System.out.println(length);

        //13 count the total number of distinct words (case-insensitive) in all the sentence
        //Expected Output: 37
        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );

        //sentences.stream().flatMap(s->Arrays.stream(s.split(" "))).distinct().count();

        sentences.stream().flatMap(s->Arrays.stream(s.split(" "))).distinct().count();

        long count  =  sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .distinct()
                .count();


        System.out.println(count);

        //14 find the concatenation of the first two words that have even lengths.
        List<String> words = Arrays.asList("apple", "banana", "cherry", "apple", "date", "elderberry");

        //words.stream().filter(s->s.length()%2==0).limit(2).collect(Collectors.joining());
        String collect2 = words.stream().filter(s -> s.length() % 2 == 0).limit(2).collect(Collectors.joining());

        System.out.println(collect2);

        String concatinatedWord = words.stream()
                .filter(s->(s.length()%2==0))
                .limit(2)
                .collect(Collectors.joining());

        System.out.println(concatinatedWord);

        //15 Stream API to find the sum of the squares of even numbers in the list.
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //nums.stream().filter(num-> num%2==0).map(num->num*num).reduce(1, Integer::sum);
        //nums.stream().filter(num->num%2==0).map(num->num*num).mapToInt(Integer::intValue).sum();

        int sum2 = nums.stream().filter(i -> i % 2 == 0).map(i->i*i).mapToInt(Integer::intValue).sum();

        System.out.println(sum2);

        int sum   = nums.stream()
                .filter(i->(i%2==0))
                .map(v->v*v)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);

        //2nd approach

        int sum1   = nums.stream()
                .filter(i->(i%2==0))
                .map(v->v*v)
                .reduce(1,Integer::sum);

        System.out.println(sum1);

        //16.calculate the average of a list of integers using streams.

        List<Integer> age = Arrays.asList(10, 15, 20, 25);
        age.stream().mapToInt(Integer::intValue).average().getAsDouble();

        double average = age.stream().
                mapToInt(Integer::intValue).average().getAsDouble();

        //age.stream().
        System.out.println(average);

        //17 strings to upper/lowercase using streams
        List<String> caseList = Arrays.asList("Apple", "baNana", "Cherry", "daTe", "elderBerry");

        //caseList.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> lowerCaseList = caseList.stream()
                .map(fruit-> fruit.toLowerCase()).collect(Collectors.toList());

        System.out.println(lowerCaseList);

        List<String> upperCaseList = caseList.stream()
                .map(fruit-> fruit.toUpperCase()).collect(Collectors.toList());

        System.out.println(upperCaseList);

        //18 duplicates from list using streams

        List<Integer> distinct = Arrays.asList(10, 10, 20, 25);


        List<Integer> distinctUpdated = distinct.stream()
                .distinct().collect(Collectors.toList());

        System.out.println(distinctUpdated);

        // find duplicate entries from the list using stream
        List<Integer> duplicates = Arrays.asList(10, 10, 20, 25, 25);

        //option 1
        List<Integer> collect5 = duplicates.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("duplicates are" + collect5);

        //option 2
        Set<Integer> duplicatesSet = new HashSet<>();
        List<Integer> collect6 = duplicates.stream().filter(i -> !duplicatesSet.add(i)).collect(Collectors.toList());
        System.out.println("duplicateSet" + collect6);

        //19 Sort strings A-Z and Z-A using streams

        List<String> frList = Arrays.asList("Apple", "baNana", "Cherry", "daTe", "elderBerry");
        //ascending
        frList = frList.stream().sorted().collect(Collectors.toList());
        System.out.println(frList);
        //descending
        frList = frList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(frList);


        //20 max and min in list using streams

        List<Integer> maxMinList = Arrays.asList(10, 10, 20, 25);

        int max = maxMinList.stream()
                .max(Comparator.naturalOrder()).get();

        System.out.println(max);

        int min = maxMinList.stream()
                .min(Comparator.naturalOrder()).get();

        System.out.println(min);

        //21. 2nd smallest/largest using streams
        List<Integer> maxMinList1 = Arrays.asList(10, 15, 20, 25);

        maxMinList1.stream().sorted().skip(1).findFirst().get();

        int secondMax1 = maxMinList1.stream()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        System.out.println(secondMax1);

        int secondMin1 = maxMinList1.stream()
                .sorted(Comparator.naturalOrder()).skip(1).findFirst().get();

        System.out.println(secondMin1);

        //22 Given a list of integers, find out all the numbers starting with 1 using Stream functions
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);


        List<Integer> collect3 = myList.stream().map(i -> i + "")
                .filter(s -> s.startsWith("1"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());



        myList = myList.stream()
                .map(s-> s +"")
                .filter(s -> s.startsWith("1"))
                .map(s-> Integer.valueOf(s))
                .collect(Collectors.toList());

        System.out.println(myList);

        //23 find duplicate elements in a given integers list

        List<Integer> myList1 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet();

        myList1 = myList1.stream()
                .filter(val1-> !set.add(val1)).collect(Collectors.toList());

        System.out.println(set);
        System.out.println(myList1);

        //24 Given a String, find the first non-repeated character in it
        String input = " aaskdl ldldk ";

        Character op = input.chars().mapToObj(c->(char) c)
                .filter(c-> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst()
                .orElse(null);

        System.out.println(op);

        //25  find only duplicate elements with its count from the String

        List<String> names1 = Arrays.asList("AA", "BB", "AA", "CC");

        Map<Map.Entry<String, Long>, Long> collect7 = names1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(v -> v.getValue() > 1)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println("collect 7 " + collect7);

        Map<String, Long> collect4 = names1.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(collect4);

        Map<String, Long> map4 = names1.stream()
                .filter(x->Collections.frequency(names1,x)>1)
                .collect(Collectors.groupingBy(s->s, Collectors.counting()));

        System.out.println(map2);

        //26 print the count of each character in a String

        String s = "safgiopqwnvmzvjkafiiofzjkcmbkjasjjoqwknvnzsjvajsgdhjqwioqwojzklvhsjkfj";
        Map<String,Long> mp = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));

        System.out.println(mp);

        //27 find max from array

        int[] arr = {1,2,300,4,5,6,7,8,9,77};

        int max1 = Arrays.stream(arr)
                .boxed()
                .max(Comparator.comparingInt(Integer::intValue)).get();

        System.out.println(max1);

        //28. Given a String, find the first non-repeated character in it using Stream functions?
        String ip = "Java articles are Awesome";
        char[] charArray = ip.toCharArray();
        Set<Character> characterSet = new HashSet<>();

        Map<Character, Long> charCounts = ip.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        // 29. find out those strings which start with a number?

        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");

        List<String> listOfStrings1 = listOfStrings.stream().filter(str->Character.isDigit(str.indexOf(0))).collect(Collectors.toList());

        System.out.println(listOfStrings1);

        //30. How do you find frequency of each element in an array or a list?
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");

        Map<String, Long> collect1 = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect1);

        //31. How do you sort the given list of decimals in reverse order?
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        //decimalList.stream().sorted(Comparator.comparingDouble());

        List<Double> collect8 = decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("collect 8 lsit is" + collect8);
    }

    //Dawood
    public static void streamExample(){
        List<String> projects1 = new ArrayList<>();
        projects1.add("Project 1");
        projects1.add("Project 2");

        List<String> projects2 = new ArrayList<>();
        projects2.add("Project 1");
        projects2.add("Project 3");

        List<String> projects3 = new ArrayList<>();
        projects3.add("Project 3");
        projects3.add("Project 4");

        // Create Employee objects
        Employee emp1 = new Employee("John", "Doe", 75000.00, projects1);
        Employee emp2 = new Employee("Jane", "Smith", 85000.00, projects2);
        Employee emp3 = new Employee("Michael", "Brown", 95000.00, projects3);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        //Stream of
        //for each is the terminal operation after this no operation can be performed on the stream only it can be collected to collection
        employeeList.stream().
                forEach(val->{
                    System.out.println(val.toString());
                });

        //map - intermediate operation

        List<Employee> updatedEmployee = employeeList.stream().
                map(employee -> new Employee(
                        employee.getName(),
                        employee.getLastName(),
                        employee.getSalary()*1.1,
                        employee.getProjects()
                )).collect(Collectors.toList());

        System.out.println(updatedEmployee);

        //filter
        List<Employee> filterEmployee = employeeList.stream().
                filter(employee -> employee.getProjects().contains("Project 1"))
                .collect(Collectors.toList());

        System.out.println(filterEmployee);

        //find first
        Optional<Employee> firstEmployee = employeeList.stream().
                filter(employee -> employee.getSalary()>800000)
                .map(employee -> new Employee(
                        employee.getName(),
                        employee.getLastName(),
                        employee.getSalary()*1.1,
                        employee.getProjects()
                ))
                .findFirst();

        System.out.println(firstEmployee);

        //flatmap
        String stringCsv = employeeList.stream().
                map(employee -> employee.getProjects())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));

        System.out.println(stringCsv);

        //short circuit operation

        List<Employee> shortCircuitList = employeeList.stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(shortCircuitList);

        //converting infinite records to limited record
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        //Sorting
        List<Employee> employees = employeeList.stream()
                .sorted((v1,v2) -> v1.getLastName().compareTo(v2.getLastName()))
                .collect(Collectors.toList());

        System.out.println(employees);

        //max salary
        employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        //reduce
        //calculate total distributed salary
        employeeList.stream()
                .map(employee -> employee.getSalary())
                .reduce(Double::sum)
                .ifPresent(System.out::println);
    }
}

