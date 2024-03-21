package controller;
import java.util.function.Predicate;

public class Controller {
	public void run() {
		
		// Example test data
		Integer[] numbers = {1,2,3,4,5,6,7,8,9};
		String[] words = {"strawberry", "pineapple", "orange", "blueberry", "pitaya"};
		
		// FilterIterator with 2 different data types
		System.out.println("FilterIterator for Integers:");
		IterableSequence<Integer> myIntArray = new MyArray<>(numbers.length);
		for (Integer number : numbers) {
			myIntArray.add(number);
		}
		Iterator<Integer> intIterator = myIntArray.getIterator();
		Predicate<Integer> evenPredicate = n -> n % 2 == 0;
		
		@SuppressWarnings("unchecked")
		Iterator<Integer> evenIntIterator = new FilterIterator<>(intIterator, evenPredicate);
		while (!evenIntIterator.isDone()) {
			System.out.println(evenIntIterator.current());
			evenIntIterator.next();
		}
		
		System.out.println("\nFilterIterator for Strings:");
		IterableSequence<String> myStringArray = new MyArray<>(words.length);
		for (String word : words) {
			myStringArray.add(word);
		}
		Iterator<String> stringIterator = myStringArray.getIterator();
		Predicate<String> lengthPredicate = str -> str.length() > 5;
		
		@SuppressWarnings("unchecked")
		Iterator<String> longStringIterator = new FilterIterator<>(stringIterator, lengthPredicate);
		while (!longStringIterator.isDone()) {
			System.out.println(longStringIterator.current());
			longStringIterator.next();
		}
	}
}
