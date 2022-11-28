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

class IntegerListImplTest {

    @Test
    void testAdd() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        assertEquals(12, stringListImpl.add(12));
        assertFalse(stringListImpl.isEmpty());
    }


    @Test
    void testAddThrowExceptionIfNull() {
        assertThrows(NullItemException.class, () -> (new IntegerListImpl()).add(null));
    }

    @Test
    void testAddThrowExceptionIfArrayIsFull() {
        assertThrows(ArrayIsFullException.class, () -> (new IntegerListImpl(0)).add(12));
    }

    @Test
    void testAddThrowExceptionIfOutOfIndex() {
        assertThrows(InvalidIndexException.class, () -> (new IntegerListImpl()).add(1, 12));
    }

    @Test
    void testAddThrowExceptionIfNullAdded() {
        assertThrows(NullItemException.class, () -> (new IntegerListImpl()).add(0, null));
    }

    @Test
    void testAddThrowExceptionIfIndexInvalid() {
        assertThrows(InvalidIndexException.class, () -> (new IntegerListImpl()).add(-1, 12));
    }

    @Test
    void testSet() {
        assertThrows(InvalidIndexException.class, () -> (new IntegerListImpl()).set(1, 12));
        assertThrows(NullItemException.class, () -> (new IntegerListImpl()).set(0, null));
        assertThrows(InvalidIndexException.class, () -> (new IntegerListImpl()).set(-1, 12));
    }

    @Test
    void testSet2() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(12);
        assertEquals(12, stringListImpl.set(1, 12));
    }

    @Test
    void testRemove() {
        assertThrows(ElementNotFoundException.class, () -> (new IntegerListImpl()).remove(12));
        assertThrows(NullItemException.class, () -> (new IntegerListImpl()).remove((Integer) null));
        assertThrows(InvalidIndexException.class, () -> (new IntegerListImpl()).remove(1));
        assertThrows(InvalidIndexException.class, () -> (new IntegerListImpl()).remove(-1));
    }

    @Test
    void testRemoveWhenDeleted() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(12);
        assertEquals(12, stringListImpl.remove(12));
        assertTrue(stringListImpl.isEmpty());
    }

    @Test
    void testContainsWhenEmpty() {
        assertFalse((new IntegerListImpl()).contains(12));
    }

    @Test
    void testContainsTrue() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(12);
        assertTrue(stringListImpl.contains(12));
    }

    @Test
    void testContainsFalse() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(322);
        assertFalse(stringListImpl.contains(12));
    }

    @Test
    void testIndexOfIllegalIndex() {
        assertEquals(-1, (new IntegerListImpl()).indexOf(12));
    }

    @Test
    void testIndexOfCheckIndex() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(12);
        assertEquals(0, stringListImpl.indexOf(12));
    }

    @Test
    void testIndexOfNoSuchElement() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(12);
        assertEquals(-1, stringListImpl.indexOf(12));
    }

    @Test
    void testLastIndexOf() {
        assertEquals(-1, (new IntegerListImpl()).lastIndexOf(12));
    }

    @Test
    void testLastIndexOfCheckLastIndex() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(12);
        assertEquals(0, stringListImpl.lastIndexOf(12));
    }

    @Test
    void testLastIndexOfNoElement() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(144);
        assertEquals(-1, stringListImpl.lastIndexOf(12));
    }


    @Test
    void testGet() {
        assertThrows(InvalidIndexException.class, () -> (new IntegerListImpl()).get(1));
        assertNull((new IntegerListImpl()).get(0));
        assertThrows(InvalidIndexException.class, () -> (new IntegerListImpl()).get(-1));
    }

    @Test
    void testEquals() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        assertTrue(stringListImpl.equals((IntegerList) new IntegerListImpl()));
    }

    @Test
    void testEqualsFalse() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(12);
        assertFalse(stringListImpl.equals((IntegerList) new IntegerListImpl()));
    }

    @Test
    void size() {
        assertEquals(0, (new IntegerListImpl()).size());
    }

    @Test
    void testIsEmpty() {
        assertTrue((new IntegerListImpl()).isEmpty());
    }

    @Test
    void testIsEmptyFalse() {
        IntegerListImpl stringListImpl = new IntegerListImpl();
        stringListImpl.add(12);
        assertFalse(stringListImpl.isEmpty());
    }

    @Test
    void clear() {
        IntegerListImpl actualStringListImpl = new IntegerListImpl();
        actualStringListImpl.clear();
        assertTrue(actualStringListImpl.isEmpty());
        assertEquals(0, actualStringListImpl.size());
    }

    @Test
    void testToArray() {
        assertEquals(0, (new IntegerListImpl()).toArray().length);
    }
}

