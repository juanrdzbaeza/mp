package org.mp.sesion03;


public class QueueLinkedListTest extends AbstractQueueTestCase {

    protected Queue<Integer> makeQueue() {
        return new QueueLinkedList<Integer>();
    }

}
