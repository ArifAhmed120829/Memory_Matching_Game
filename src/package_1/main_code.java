package package_1;
import java.util.*;



public class main_code {
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	static class LinkedList{
		Node head;
		Node tail;
		void push(int data) {
			Node newNode = new Node(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
				
			}
			else {
				tail.next = newNode;
				tail = tail.next;
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		LinkedList ll = new LinkedList();
		int[] arr = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
		int[] a = new int[arr.length];//random_array
		Random r = new Random();
		//all numbers are added in random places
		Stopwatch timer = new Stopwatch();
		System.out.println("Creating a random board of numbers...");
		for(int i =0; i<arr.length; i++) {
			int index = r.nextInt(0,18);
			//System.out.println(index);
			while(a[index] != 0) index = r.nextInt(1,18);
			a[index] = arr[i];
		}
		double time = timer.elapsedTime();
		System.out.println("Time taken: "+time);
		for(int val:a) ll.push(val);// all value of random_array has been added to linked list
		int weight = sizeofLL(ll.head,0);
		System.out.println(weight);
		

	}

	private static int sizeofLL(Node head,int c) {
		Node current = head;
		while(current!= null) {
			current = current.next;
			c++;
		}
		return c;
		
	}

}
