package cs10_cs03;

import static org.junit.Assert.*;

import org.junit.Test;


public class DLinkedListTest {
	
	DLinkedList dlinkedlist = new DLinkedList();
	
	@Test
    public void cs65TestSet() {
        ILinkedList instance = (ILinkedList)dlinkedlist;
        instance.add(1);
        instance.add(3);
        instance.add(5);
        instance.set(1, 'F');
        assertEquals('F', instance.get(1));
    }

	@Test
    public void cs65TestSetError() {
        ILinkedList instance = (ILinkedList)dlinkedlist;
        try {
            instance.add(1);
            instance.add(2);
            instance.set(4, 'F');
            fail("You should throw an exception when trying to set in a wrong index");
        } catch ( RuntimeException f) {
        }
    }

	@Test
    public void cs65TestSubList() {
        ILinkedList instance = (ILinkedList)dlinkedlist;
        instance.add('a');
        instance.add('b');
        instance.add('c');
        instance.add('d');
        ILinkedList temp = instance.sublist(1, 2);
        assertEquals(temp.get(0), instance.get(1));
        assertEquals(temp.get(1), instance.get(2));
    
    }

	@Test
    public void cs56TestContains() {
        ILinkedList c = (ILinkedList)dlinkedlist;
        for(int i=0;i<3;i++){
            c.add(i);
        }
        c.add(0,3);
        c.add(4,4);
        
        assertTrue(c.contains(4));
        assertTrue(c.contains(0));
        assertTrue(c.contains(1));
        assertTrue(c.contains(2));
        assertTrue(c.contains(3));
        assertFalse(c.contains(9));
        assertFalse(c.contains(7));
    }

	@Test
    public void cs56TestAddRemoveTwoLists5() {
        ILinkedList c = (ILinkedList)dlinkedlist;
        for(int i=0;i<3;i++){
            c.add(i);
        }
        c.add(0,3);
        c.add(4,4);
        c.set(1, 7);
        c.set(4,9);
        ILinkedList d = (ILinkedList)dlinkedlist;
        d.add(3);
        d.add(7);
        d.add(1);
        d.add(2);
        d.add(9);
        for(int i=0;i<5;i++){
            assertEquals(c.get(i),d.get(i));
        }
    }
}