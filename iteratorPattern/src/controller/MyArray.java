package controller;

public class MyArray<T> implements IterableSequence<T> {
	private T[] array;
	private int size;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	public MyArray(int capacity) {
		this.array = (T[]) new Object[capacity];
		this.size = 0;
		this.capacity = capacity;
	}
	
	@Override
	public void add(T value) {
		if (size < capacity) {
			array[size++] = value;
		} else {
			throw new IndexOutOfBoundsException("Sequence is full");
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public int capacity() {
		return capacity;
	}
	
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		return array[index];
	}
	
	@Override
	public Iterator<T> getIterator() {
		return new MyIterator<>();
	}
	
	@SuppressWarnings("hiding")
	private class MyIterator<T> implements Iterator<T> {
		private int currentIndex;
		
		public MyIterator() {
			this.currentIndex = 0;
		}
		
		@Override
		public void first() {
			currentIndex = 0;
		}
		
		@Override
		public void next() {
			currentIndex++;
		}
		
		@Override
		public boolean isDone() {
			return currentIndex >= size;
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public T current() {
			if (isDone()) {
				throw new IndexOutOfBoundsException("Iterator out of bounds");
			}
			return (T) array[currentIndex];
		}
	}
}
