package controller;
import java.util.function.Predicate;

public class Controller {
	public void run() {
		
		// Example test data
		Integer[] numbers = {0,1,2,3,4,5,6,7,8,9};
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
		Predicate<String> lengthPredicate = str -> str.length() > 6;
		
		@SuppressWarnings("unchecked")
		Iterator<String> longStringIterator = new FilterIterator<>(stringIterator, lengthPredicate);
		while (!longStringIterator.isDone()) {
			System.out.println(longStringIterator.current());
			longStringIterator.next();
		}
		
		// FilterIterator that filters results from another FilterIterator
		System.out.println("\nFilterIterator filtering results from another FilterIterator:");
		
		stringIterator.first();
		Predicate<String> lastLetterPredicate = str -> str.endsWith("y");
		
		@SuppressWarnings("unchecked")
		Iterator<String> filteredStringIterator = new FilterIterator<>(stringIterator, lastLetterPredicate);
		
		filteredStringIterator.first();
		
		@SuppressWarnings("unchecked")
		Iterator<String> doubleFilteredStringIterator = new FilterIterator<>(filteredStringIterator, lengthPredicate);
		while (!doubleFilteredStringIterator.isDone()) {
			System.out.println(doubleFilteredStringIterator.current());
			doubleFilteredStringIterator.next();
		}
		
		// FilterIterator that filters out everything
		System.out.println("\nFilterIterator that filters out everything:");
		Predicate<Integer> alwaysFalsePredicate = n -> false;
		
		@SuppressWarnings("unchecked")
		Iterator<Integer> emptyIntIterator = new FilterIterator<>(intIterator, alwaysFalsePredicate);
		while (!emptyIntIterator.isDone()) {
			System.out.println(emptyIntIterator.current());
			emptyIntIterator.next();
		}
		
		// ReverseIterator
		System.out.println("\nReverseIterator with Integer elements:");
		Iterator<Integer> reversedIntIterator = new ReverseIterator<>(intIterator);
		while (!reversedIntIterator.isDone()) {
			System.out.println(reversedIntIterator.current());
			reversedIntIterator.next();
		}
		
		// ReverseIterator that takes a FilterIterator
		System.out.println("\nReverseIterator that takes a FilterIterator:");
		Iterator<Integer> reversedFilteredIntIterator = new ReverseIterator<>(evenIntIterator);
		while (!reversedFilteredIntIterator.isDone()) {
			System.out.println(reversedFilteredIntIterator.current());
			reversedFilteredIntIterator.next();
		}
	}
}
