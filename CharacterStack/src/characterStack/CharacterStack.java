package characterStack;

import java.util.EmptyStackException;
import java.util.Stack;

public class CharacterStack {
	private static final int MAX_SIZE = 20;
	private Stack<Character> data = new Stack();

	public CharacterStack() {
	}

	public CharacterStack(String str) {
		if ((str != null) && (!str.equals(""))) {
			char[] chars = str.toCharArray();

			for (int i = 0; i < chars.length; i++) {
				if (i >= MAX_SIZE) {
					throw new StackOverflowError();
				}
				this.data.push(Character.valueOf(chars[i]));
			}
		}
	}

	public CharacterStack(char c) {
		this.data.push(Character.valueOf(c));
	}

	public void push(char c) {
		if (this.data.size() < getMaxSize())
			this.data.push(Character.valueOf(c));
		else
			throw new StackOverflowError();
	}

	public void push(String str) {
		if ((str != null) && (!str.equals(""))) {
			char[] chars = str.toCharArray();

			for (int i = 0; i < chars.length; i++) {
				if (i >= MAX_SIZE) {
					throw new StackOverflowError();
				}
				this.data.push(Character.valueOf(chars[i]));
			}
		}
	}

	public char pop() {
		if (this.data.size() == 0) {
			throw new EmptyStackException();
		}
		return ((Character) this.data.pop()).charValue();
	}

	public int getSize() {
		return this.data.size();
	}

	public int getMaxSize() {
		return MAX_SIZE;
	}
}