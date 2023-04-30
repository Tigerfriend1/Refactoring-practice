package characterStackTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.EmptyStackException;
import org.junit.Test;
import characterStack.CharacterStack;

public class CharacterStackTest {
	@Test
	public void testConstructorChar() {
	    CharacterStack stack = new CharacterStack('a');
	    assertEquals(1, stack.getSize());
	    assertEquals('a', stack.pop());
	}


	@Test
	public void testPushChar() {
		CharacterStack stack = new CharacterStack();
		stack.push('a');
		assertEquals(1, stack.getSize());
	}

	@Test
	public void testPushString() {
		CharacterStack stack = new CharacterStack();
		stack.push("abc");
		assertEquals(3, stack.getSize());
	}


	@Test
	public void testPushMaxSize() {
	    CharacterStack stack = new CharacterStack("10000000000000000000");
	    try {
	        stack.push('a');
	    } catch (StackOverflowError e) {
	        return;
	    }
	    fail("fail.");
	}
	
	
//	@Test
//	public void testPushMaxSize2() {
//	    CharacterStack stack = new CharacterStack("100000000000000000000");
//	    try {
//	        stack.push('a');
//	    } catch (StackOverflowError e) {
//	        return;
//	    }
//	    fail("fail.");
//	}


	@Test
	public void testPop() {
		CharacterStack stack = new CharacterStack("abc");
		assertEquals('c', stack.pop());
		assertEquals('b', stack.pop());
		assertEquals('a', stack.pop());
		assertEquals(0, stack.getSize());
	}

	@Test(expected = EmptyStackException.class)
	public void testPopEmpty() {
		CharacterStack stack = new CharacterStack();
		stack.pop();
	}

	@Test
	public void testGetMaxSize() {
		CharacterStack stack = new CharacterStack();
		assertEquals(20, stack.getMaxSize());
	}


}




