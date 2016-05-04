package org.mp.sesion03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueArrayCircularTest {

    private QueueArray<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new QueueArray<Integer>();
    }
   
    @Test
    public void testCicularQueue() {

        queue.addLast(10);
        queue.addLast(20);
        queue.addLast(30);
        queue.addLast(40);
        queue.addLast(50);
        
        assertEquals((Integer) 4, (Integer) queue.getLastQueue());
      	
      	assertEquals((Integer) 0, (Integer) queue.getFirstQueue());
      	
        
        try {
        	assertEquals((Integer) 10, (Integer) queue.removeFirst());
        } catch(EmptyQueueException e) {
        	e.printStackTrace();
        }
        		
        try {
        	assertEquals((Integer) 20, (Integer) queue.removeFirst());
        } catch(EmptyQueueException e) {
        	e.printStackTrace();
        }
        
        assertEquals((Integer) 4, (Integer) queue.getLastQueue());
      	
       	assertEquals((Integer) 2, (Integer) queue.getFirstQueue());

       	assertEquals((Integer) 3, (Integer) queue.size());

       	queue.addLast(60);
 
      	assertEquals((Integer) 0, (Integer) queue.getLastQueue());
      	
      	queue.addLast(70);
      	
      	assertEquals((Integer) 1, (Integer) queue.getLastQueue());
      	
      	assertEquals((Integer) 2, (Integer) queue.getFirstQueue());
    }

}
