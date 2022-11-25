package com.example.arrays1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.arrays1.exception.ArrayIsFullException;
import com.example.arrays1.exception.ElementNotFoundException;
import com.example.arrays1.exception.InvalidIndexException;
import com.example.arrays1.exception.NullItemException;

import org.junit.jupiter.api.Test;

class StringListImplTest {

    @Test
    void testAdd() {
        StringListImpl stringListImpl = new StringListImpl();
        assertEquals("Item", stringListImpl.add("Item"));
        assertFalse(stringListImpl.isEmpty());
    }


    @Test
    void testAddThrowExceptionIfNull() {
        assertThrows(NullItemException.class, () -> (new StringListImpl()).add(null));
    }

    @Test
    void testAddThrowExceptionIfArrayIsFull() {
        assertThrows(ArrayIsFullException.class, () -> (new StringListImpl(0)).add("Item"));
    }

    @Test
    void testAddThrowExceptionIfOutOfIndex() {
        assertThrows(InvalidIndexException.class, () -> (new StringListImpl()).add(1, "Item"));
    }

    @Test
    void testAddThrowExceptionIfNullAdded() {
        assertThrows(NullItemException.class, () -> (new StringListImpl()).add(0, null));
    }

    @Test
    void testAddThrowExceptionIfIndexInvalid() {
        assertThrows(InvalidIndexException.class, () -> (new StringListImpl()).add(-1, "Item"));
    }

    @Test
    void testSet() {
        assertThrows(InvalidIndexException.class, () -> (new StringListImpl()).set(1, "Item"));
        assertThrows(NullItemException.class, () -> (new StringListImpl()).set(0, null));
        assertThrows(InvalidIndexException.class, () -> (new StringListImpl()).set(-1, "Item"));
    }

    @Test
    void testSet2() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("Item");
        assertEquals("Item", stringListImpl.set(1, "Item"));
    }

    @Test
    void testRemove() {
        assertThrows(ElementNotFoundException.class, () -> (new StringListImpl()).remove("Item"));
        assertThrows(NullItemException.class, () -> (new StringListImpl()).remove((String) null));
        assertThrows(InvalidIndexException.class, () -> (new StringListImpl()).remove(1));
        assertThrows(InvalidIndexException.class, () -> (new StringListImpl()).remove(-1));
    }

    @Test
    void testRemoveWhenDeleted() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("Item");
        assertEquals("Item", stringListImpl.remove("Item"));
        assertTrue(stringListImpl.isEmpty());
    }

    @Test
    void testContainsWhenEmpty() {
        assertFalse((new StringListImpl()).contains("Item"));
    }

    @Test
    void testContainsTrue() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("Item");
        assertTrue(stringListImpl.contains("Item"));
    }

    @Test
    void testContainsFalse() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("123");
        assertFalse(stringListImpl.contains("Item"));
    }

    @Test
    void testIndexOfIllegalIndex() {
        assertEquals(-1, (new StringListImpl()).indexOf("Item"));
    }

    @Test
    void testIndexOfCheckIndex() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("Item");
        assertEquals(0, stringListImpl.indexOf("Item"));
    }

    @Test
    void testIndexOfNoSuchElement() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("123");
        assertEquals(-1, stringListImpl.indexOf("Item"));
    }

    @Test
    void testLastIndexOf() {
        assertEquals(-1, (new StringListImpl()).lastIndexOf("Item"));
    }

    @Test
    void testLastIndexOfCheckLastIndex() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("Item");
        assertEquals(0, stringListImpl.lastIndexOf("Item"));
    }

    @Test
    void testLastIndexOfNoElement() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("123");
        assertEquals(-1, stringListImpl.lastIndexOf("Item"));
    }


    @Test
    void testGet() {
        assertThrows(InvalidIndexException.class, () -> (new StringListImpl()).get(1));
        assertNull((new StringListImpl()).get(0));
        assertThrows(InvalidIndexException.class, () -> (new StringListImpl()).get(-1));
    }

    @Test
    void testEquals() {
        StringListImpl stringListImpl = new StringListImpl();
        assertTrue(stringListImpl.equals((StringList) new StringListImpl()));
    }

    @Test
    void testEqualsFalse() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("Item");
        assertFalse(stringListImpl.equals((StringList) new StringListImpl()));
    }

    @Test
    void size() {
        assertEquals(0, (new StringListImpl()).size());
    }

    @Test
    void testIsEmpty() {
        assertTrue((new StringListImpl()).isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        StringListImpl stringListImpl = new StringListImpl();
        stringListImpl.add("Item");
        assertFalse(stringListImpl.isEmpty());
    }

    @Test
    void clear() {
        StringListImpl actualStringListImpl = new StringListImpl();
        actualStringListImpl.clear();
        assertTrue(actualStringListImpl.isEmpty());
        assertEquals(0, actualStringListImpl.size());
    }

    @Test
    void testToArray() {
        assertEquals(0, (new StringListImpl()).toArray().length);
    }
}

