package controller;
import java.util.function.Predicate;

public class MyFilterIterator<T> implements Iterator<T> {
	private Iterator<T> iterator;
	private Predicate<T> predicate;
	
	public MyFilterIterator(Iterator<T> iterator, Predicate<T> predicate) {
		this.iterator = iterator;
		this.predicate = predicate;
	}
	
	@Override
	public void first() {
		iterator.first();
		while (!iterator.isDone() && !predicate.test(iterator.current())) {
			iterator.next();
		}
	}
	
	@Override
	public void next() {
		iterator.next();
		while (!iterator.isDone() && ! predicate.test(iterator.current())) {
			iterator.next();
		}
	}
	
	@Override
	public boolean isDone() {
		return iterator.isDone();
	}
	
	@Override
	public T current() {
		return iterator.current();
	}
}
