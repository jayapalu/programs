package GenericList;

import java.util.LinkedList;

public class GenericLinkedLIst {

    public static void main(String[] args) {
        linkedList<Integer> list = new linkedList<>();

        list.add(5);
        list.add(7);
        list.add(9);
        list.print();

        linkedList<String> listStr = new linkedList<>();

        System.out.println("String list");

        listStr.add("a");
        listStr.add("b");
        listStr.add("c");

        listStr.print();


    }
}

class linkedList<T> {
    private Node<T> head;

    void add(T data) {

        if (head == null) {
            head = new Node<T>(data);
            return;
        }

        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        Node<T> newNode = new Node<T>(data);
        curr.next = newNode;
    }


    void print() {
        Node<T> curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

class Node<T> {

    T data;
    Node<T> next;
    public Node(T data) {
        this.data =  data;
        this.next = null;
    }
}




