import java.util.Collections.*;
import java.util.*;
/*
CTCI
1. delete duplicate node from linked list
2. find kth node in the linked list from last

*/


class Node{
	Node next = null;

	int data;

	public Node(){

	}

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


	public Node findKthNodeFromLast(Node head,int k){

		// two pointer approach
		// fist from 0 ,second from the kth from the first

		Node first = new Node();
		Node second = new Node();

		first.next = head;
		second.next = head;

		int cnt = 0;
		while(second != null){

			if (cnt >= k){
				first = first.next;
			}
			second = second.next;

			cnt ++;


		}


		return first;
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


		Node kthNode = n.findKthNodeFromLast(first.next,3);

		System.out.println(kthNode.data);
		// nth node to last



	}

}
