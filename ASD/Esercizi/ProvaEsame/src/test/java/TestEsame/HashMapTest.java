package TestEsame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    void put() {
        HashMap<String, Integer> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> map.put(null, null));
        assertThrows(IllegalArgumentException.class, () -> map.put("a", null));
        assertThrows(IllegalArgumentException.class, () -> map.put(null, 4));
        map.put("a", 1);
        map.put("b", 2);
        assertEquals(2, map.getSize());
        assertFalse(map.isEmpty());
    }

    @Test
    void get() {
        HashMap<String, Integer> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> map.get(null));
        assertThrows(IllegalArgumentException.class, () -> map.get("a"));
        map.put("a", 1);
        map.put("b", 2);
        assertEquals(2, map.get("b"));
        assertEquals(1, map.get("a"));
    }

    @Test
    void contains() {
        HashMap<String, Integer> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> map.contains(null));
        map.put("a", 1);
        map.put("b", 2);
        assertTrue(map.contains(2));
        assertTrue(map.contains(1));
        assertFalse(map.contains(42));
    }

    @Test
    void containsKey() {
        HashMap<String, Integer> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> map.containsKey(null));
        map.put("a", 1);
        map.put("b", 2);
        assertTrue(map.containsKey("a"));
        assertTrue(map.containsKey("b"));
        assertFalse(map.containsKey("T.M. Opera O"));
    }

    @Test
    void remove() {
        HashMap<String, Integer> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> map.remove(null));
        map.put("a", 1);
        map.put("b", 2);
        assertTrue(map.contains(1));
        map.remove(1);
        assertFalse(map.contains(1));
        assertEquals(1, map.getSize());
    }

    @Test
    void removeKey() {
        HashMap<String, Integer> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> map.remove(null));
        map.put("a", 1);
        map.put("b", 2);
        assertTrue(map.containsKey("b"));
        map.removeKey("b");
        assertFalse(map.containsKey("b"));
        assertEquals(1, map.getSize());
    }

    @Test
    void clear() {
        HashMap<String, Integer> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> map.remove(null));
        map.put("a", 1);
        map.put("b", 2);
        map.clear();
        assertEquals(0, map.getSize());
    }

    @Test
    void resize() {
        HashMap<String, Integer> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> map.remove(null));
        for(int i = 0; i < 18; i++){
            map.put(""+(char)i, i);
        }
        assertEquals(64, map.getCurrentCapacity());
    }

    @Test
    void enumerateKey() {
        HashMap<String, Integer> map = new HashMap<>();
        String[] correctKey = new String[18];
        for(int i = 0; i < 18; i++){
            map.put(""+(char)i, i);
            correctKey[i] = ""+(char)i;
        }
        Iterable<String> list = map.enumerateKey();
        int i = 0;
        for(String s : list){
            assertEquals(correctKey[i++], s);
        }
    }

    @Test
    void enumerateValues() {
        HashMap<String, Integer> map = new HashMap<>();
        int[] correctValue = new int[18];
        for(int i = 0; i < 18; i++){
            map.put(""+(char)i, i);
            correctValue[i] = i;
        }
        Iterable<Integer> list = map.enumerateValues();
        int i = 0;
        for(int k : list){
            assertEquals(correctValue[i++], k);
        }
    }
}