package controller;

public class ReverseIterator<T> implements Iterator<T> {
	private Iterator<T> iterator;
	private int currentIndex;
	
	public ReverseIterator(Iterator<T> iterator) {
		this.iterator = iterator;
		this.currentIndex = -1;
		goToLast();
	}
	
	private void goToLast() {
		iterator.first();
		currentIndex = iterator.isDone() ? -1 : 0;
		while (!iterator.isDone()) {
			iterator.next();
			currentIndex++;
		}
		currentIndex--;
	}
	
	@Override
	public void first() {
		goToLast();
	}
	
	@Override
	public void next() {
		if (currentIndex > 0) {
			currentIndex--;
		} else {
			currentIndex = -1;
		}
	}
	
	@Override
	public boolean isDone() {
		return currentIndex < 0;
	}
	
	@Override
	public T current() {
		if (!isDone()) {
			Iterator<T> tempIterator = iterator;
			tempIterator.first();
			for (int i = 0; i < currentIndex; i++) {
				tempIterator.next();
			}
			return tempIterator.current();
		}
		throw new IndexOutOfBoundsException("Iterator out of bounds.");
	}
}
