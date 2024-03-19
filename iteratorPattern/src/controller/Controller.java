package controller;

public class Controller {
	public void run() {
		MyArray<Integer> myArray = new MyArray<>(5);
		myArray.add(1);
		myArray.add(2);
		myArray.add(3);
		myArray.add(4);
		myArray.add(5);
		
		Iterator<Integer> iterator = myArray.getIterator();
		while (!iterator.isDone()) {
			System.out.println(iterator.current());
			iterator.next();
		}
	}
}
