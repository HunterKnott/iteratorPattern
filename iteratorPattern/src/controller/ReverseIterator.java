package controller;
import java.util.Stack;

public class ReverseIterator<T> implements Iterator<T> {
	private Iterator<T> iterator;
	private Stack<T> stack;
	
	public ReverseIterator(Iterator<T> iterator) {
		this.iterator = iterator;
		this.stack = new Stack<>();
		fillStack();
	}
	
	private void fillStack() {
		while (!iterator.isDone()) {
			stack.push(iterator.current());
			iterator.next();
		}
	}
	
	@Override
	public void first() {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		fillStack();
	}
	
	@Override
	public void next() {
		if (!stack.isEmpty()) {
			stack.pop();
		}
	}
	
	@Override
	public boolean isDone() {
		return stack.isEmpty();
	}
	
	@Override
	public T current() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		throw new IndexOutOfBoundsException("Iterator out of bounds.");
	}
}
