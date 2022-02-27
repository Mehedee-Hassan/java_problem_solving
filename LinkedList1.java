/*
CTCI
1. delete duplicate node from linked list

*/


import java.util.Collections.*;
import java.util.*;

class Node{
	Node next = null;

	int data;


	public Node(int d){
		data = d;
	}


	void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;

		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}

	void deleteDups(Node n){
		HashSet<Integer> set = new HashSet<Integer>();

		Node previous = null;

		while(n != null){
			if (set.contains(n.data)){
				previous.next = n.next;

			}else{
				set.add(data);
				previous = n;
			}
			n = n.next;
		}
	}
}


public class LinkedList1{

	public static void main(String[] args){
		Node first = new Node(-1);
		Node n = new Node(2);
		first.next = n;
		n.next = new Node(3);
		n = n.next;
		n.next = new Node(4);
		n = n.next;
		n.next = new Node(5);
		n = n.next;
		n.next = new Node(5);
		n = n.next;

		n.deleteDups(n);



		// nth node to last



	}

}
