package TestEsame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {

    @Test
    @DisplayName("Push e pop test")
    void push_and_pop() {
        Stack<String> stack = new Stack<>();
        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
        assertThrows(NullPointerException.class, stack::pop);
        stack.push("A");
        assertEquals(1, stack.getSize());
        stack.push("B");
        assertEquals(2, stack.getSize());
        assertEquals("B", stack.pop());
        assertEquals(1, stack.getSize());
        assertEquals("A", stack.pop());
        assertEquals(0, stack.getSize());
        assertThrows(NullPointerException.class, stack::pop);
    }

    @Test
    void clear() {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < 100; i++){
            stack.push(""+(char)i);
        }
        stack.clear();
        assertEquals(0, stack.getSize());
        assertThrows(NullPointerException.class, stack::pop);
    }

    @Test
    void remove() {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(5);
        stack.push(7);
        stack.remove(5);
        assertEquals(7, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(0, stack.getSize());
    }

    @Test
    void removeAll() {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(7);
        stack.push(7);
        stack.remove(7);
        assertEquals(4, stack.pop());
        assertEquals(0, stack.getSize());
    }
}