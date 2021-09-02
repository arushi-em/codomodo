import java.util.*;
class ArrayQueue<E> 
{
    private E[] elements;
    private int front;
    private int back;
    private static final int INITIAL_CAPACITY = 4;
    public ArrayQueue() {
        front=back=-1;
        elements = (E[]) new Object[INITIAL_CAPACITY];
    }
    public ArrayQueue(int capacity) {
        front=back=-1;
        elements = (E[]) new Object[capacity];
    }
    public void add(E element) {
        if (size() == elements.length) {
            resize();
        }
        back=(back+1)%(elements.length);
        elements[back] = element;
        if(front==-1)
            front=0;
    }
    public E element() {
        if (size() == 0) {
            throw new java.util.NoSuchElementException();
        }
        return elements[front];
    }
    public boolean isEmpty() {
        return (size() == 0);
    }
    public E remove() {
        if (size() == 0) {
            throw new java.util.NoSuchElementException();
        }
        E element = elements[front];
        elements[front] = null;
        
        if (front == back) { // queue is empty
            front = back = -1;
        }
        else
            front=(front+1)%(elements.length);
        return element;
    }
    public int size() {
        if(front==-1)
            return 0;
        if (front <= back) {
            return back - front+1;
        } else {
            return back - front + elements.length+1;
        }
    }
    private void resize() {
        int size = size();
        int len = elements.length;
        assert size == len;
        Object[] a = new Object[2*len];
        System.arraycopy(elements, front, a, 0, len - front);
        System.arraycopy(elements, 0, a, len - front, back+1);
        elements = (E[])a;
        front = 0;
        back = size-1;
    }
    private void print(){
        for(E a: elements)
            System.out.print(a+" ");
        System.out.println();
    }
    public static void main(String []args)
    {
        ArrayQueue<Integer> aq=new ArrayQueue<Integer>();
        aq.add(3);
        aq.add(45);
        System.out.println(aq.remove());
        aq.add(67);
        aq.add(89);
        aq.add(12);
        aq.print();
        System.out.println(aq.remove());
        aq.print();
        aq.add(14);
        aq.print();
        aq.add(56);
        aq.print();
        System.out.println(aq.size());
	for(int i=0;i<aq.size();i++)
		System.out.println(aq.get(i));
	for(int i=0;i<aq.size();i++)
		System.out.println(aq.get(i));
    }
}