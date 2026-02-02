package TestEsame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
        list.add(15);
        for(Integer i : list){
            assertEquals(15, i);
        }
        list.add(14);
        list.add(13);
        list.add(12);
        int[] correct = new int[]{15, 14, 13, 12};
        int k = 0;
        for(Integer i : list){
            assertEquals(i, correct[k++]);
        }
    }

    @Test
    void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4, 0);
        assertThrows(IllegalArgumentException.class, () -> list.add(null, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(42, 42));
        list.add(15, 1);
        list.add(14, 1);
        list.add(13, 1);
        list.add(12, 1);
        int[] correct = new int[]{4, 12, 13, 14, 15};
        int k = 0;
        for(Integer i : list){
            assertEquals(i, correct[k++]);
        }
    }

    @Test
    void remove() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.remove(null));
        assertThrows(NullPointerException.class, () -> list.remove(42));
        list.add(15);
        list.add(14);
        list.add(13);
        list.add(12);
        list.remove(14);
        int[] correct = new int[]{15, 13, 12};
        int k = 0;
        for(Integer i : list){
            assertEquals(i, correct[k++]);
        }
    }

    @Test
    void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(42);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(42));
        list.add(15);
        list.add(14);
        list.add(13);
        list.add(12);
        list.remove(0);
        int[] correct = new int[]{15, 14, 13, 12};
        int k = 0;
        for(Integer i : list){
            assertEquals(i, correct[k++]);
        }
    }

    @Test
    void get() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(42));
        list.add(15);
        list.add(14);
        list.add(13);
        list.add(12);
        assertEquals(12, list.get(3));
        assertEquals(15, list.get(0));
        assertEquals(14, list.get(1));
        assertEquals(13, list.get(2));
    }

    @Test
    void contains() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.contains(null));
        list.add(15);
        list.add(14);
        list.add(13);
        list.add(12);
        assertTrue(list.contains(15));
        assertTrue(list.contains(14));
        assertTrue(list.contains(13));
        assertTrue(list.contains(12));
        assertFalse(list.contains(42));
    }

    @Test
    void indexOf() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.indexOf(null));
        list.add(15);
        list.add(14);
        list.add(13);
        list.add(12);
        assertEquals(0, list.indexOf(15));
        assertEquals(1, list.indexOf(14));
        assertEquals(2, list.indexOf(13));
        assertEquals(3, list.indexOf(12));
        assertEquals(-1, list.indexOf(42));
    }
}