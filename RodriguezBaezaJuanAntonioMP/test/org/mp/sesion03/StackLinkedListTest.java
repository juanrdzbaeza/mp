package org.mp.sesion03;


public class StackLinkedListTest extends AbstractStackTestCase {

    protected Stack<Integer> makeStack() {

        return new StackLinkedList<Integer>();
    }
}
