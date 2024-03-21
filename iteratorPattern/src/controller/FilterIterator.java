package controller;
import java.util.function.Predicate;

@SuppressWarnings("rawtypes")
public class FilterIterator<T> implements Iterator {
	private Iterator<T> iterator;
	private Predicate<T> predicate;
	
	public FilterIterator(Iterator<T> iterator, Predicate<T> predicate) {
		this.iterator = iterator;
		this.predicate = predicate;
	}
	
	@Override
	public void first() {
		iterator.first();
		skipToNextValid();
	}
	
	@Override
	public void next() {
		iterator.next();
		skipToNextValid();
	}
	
	@Override
	public boolean isDone() {
		return iterator.isDone();
	}
	
	@Override
	public T current() {
		return iterator.current();
	}
	
	private void skipToNextValid() {
		while (!iterator.isDone() && !predicate.test(iterator.current())) {
			iterator.next();
		}
	}
}
