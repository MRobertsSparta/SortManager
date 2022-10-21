# SortManager
Allows the user to use different sorting algorithms to sort a generated random array and time how long the algorithm takes in nanoseconds.
### Available Sorting Algorithms:
* Bubble Sort
* Merge Sort
* Binary Tree Sort
* Quick Sort
* Insertion Sort
* Selection Sort

# Installation
To use the application download or request to pull the code and call the `SortManager.start()` method. Then you can use the console or CLI to select your sorting algorithm and receive your results.
### Dependencies
* Junit Jupiter 5.9.0

# Usage
You must first select a sorting algorithm from the menu by entering the corresponding number.

Then you must specify the size of the integer array to be sorted (Min 1, Max 1000). A random array of that size will then be produced for you.

The requested sorting algorithm will then be executed on the generated array and the sorted array and time taken to sort it in nanoseconds will be printed.

# Contributing
Please open an issue to discuss any problems found with the application.

If you wish to add your own sorting algorithm you must implement the `Sorter` interface and then ensure you add a state to the SorterOption enum to represent your new class and add your new Sorter object to the `SortFactory.getSorter(SortOption option)` method as seen below.

```java
public static Sorter getSorter(SorterOption option) {
    return switch(option) {
        case BUBBLE -> new BubbleSort(); ...
    ... case SELECTION -> new SelectionSort();
            
>>      case CUSTOMSORT -> new CustomSort();      <<
        };
    }
```

```java
public enum SorterOption {
    BUBBLE("Bubble Sort"), ...
... SELECTION("Selection Sort"),
    
>>  CUSTOMSORT("Custom Sort provided by user");  <<
```

