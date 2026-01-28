package TestEsame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue() {
        Queue<String> queue = new Queue<>();
        assertThrows(IllegalArgumentException.class, () -> queue.enqueue(null));
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.getSize());
    }

    @Test
    void dequeue() {
        Queue<String> queue = new Queue<>();
        assertThrows(NullPointerException.class, queue::dequeue);
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals(0, queue.getSize());
    }

    @Test
    void remove() {
        Queue<String> queue = new Queue<>();
        assertThrows(NullPointerException.class, () -> queue.remove("C"));
        assertThrows(IllegalArgumentException.class, () -> queue.remove(null));
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        assertTrue(queue.remove("B"));
        assertFalse(queue.remove("B"));
        assertEquals(3, queue.getSize());
    }

    @Test
    void removeAll() {
        Queue<String> queue = new Queue<>();
        assertThrows(NullPointerException.class, () -> queue.removeAll("C"));
        assertThrows(IllegalArgumentException.class, () -> queue.removeAll(null));
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("B");
        queue.enqueue("B");
        assertTrue(queue.remove("B"));
        assertFalse(queue.remove("B"));
        assertEquals(1, queue.getSize());
    }
}