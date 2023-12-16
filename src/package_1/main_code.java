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
		Scanner in = new Scanner(System.in);
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
			while(a[index] != 0) index = r.nextInt(0,18);
			a[index] = arr[i];
		}
		double time = timer.elapsedTime();
		System.out.println("Time taken: "+time);
		for(int val:a) ll.push(val);// all value of random_array has been added to linked list
		int weight = sizeofLL(ll.head,0);
		int col = 9;
		while(col>0) {
			showBoard(ll.head,col);
			System.out.println("Add first cards positions which must be between 0-"+col*2);
			int p1 = in.nextInt();
			System.out.println("Add second cards positions which must be between 0-"+col*2);
			int p2 = in.nextInt();
			if(checkMatch(p1,p2,ll.head))col--;
		}

	}





	private static boolean checkMatch(int p1, int p2, Node h) {
		Node c1 = h;
		Node prev1 = null;
		Node prev2 = null;
		Node c2= h;
		int count = 0;
		while(count!=p1) {
			prev1 = c1;
			c1 = c1.next;
			count++;
		}
		count = 0;
		while(count!=p2) {
			prev2 = c2;
			c2 = c2.next;
			count++;
		}
		if(c1.data == c2.data) {
			if(prev1 == null) prev1 =h.next;
			else prev1.next = prev1.next.next;
			if(prev2 == null) prev2 =h.next;
			else prev2.next = prev2.next.next;
			return true;
		}
		return false;
	}

	private static int sizeofLL(Node head,int c) {
		Node current = head;
		while(current!= null) {
			current = current.next;
			c++;
		}
		return c;
		
	}
	private static void showBoard(Node h,int c) {
		Node curr = h;
		for(int row = 0; row<2; row++) {
			System.out.println("------------------------");
			for(int col = 0; col<c; col++) {
				System.out.print(curr.data+" ");
				curr = curr.next;
			}
			System.out.println();
			
		}
		
	}

}
