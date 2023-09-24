/*
 * title：ReverseList
 * name：蔡孟臻
 */

import java.util.*;

class ListNode {
	int val;
	int size = 0;
	ListNode next;
	ListNode head = null;
	ListNode tail = null;
	
	ListNode(){};
	ListNode(int val){this.val = val;}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;		
	}
	
	//get value
	public int getValue() {return val;}
	//get next
	public ListNode getNext() {return next;}
	//get size
	public int getSize() {return size;}
	//empty
	public boolean isEmpty() {return size == 0;}
	//set next
	public void setNext(ListNode n) {next = n;} 
	//add first
	void addFirst(int val) {
		head = new ListNode(val, head);
		if(size == 0) {
			tail = head;
		}
		size++;
	}
	//add last
	void addLast(int val) {
		ListNode newest = new ListNode(val, null);

		if(isEmpty()) {
			head = newest;			
		}
		else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;		
	}
	//print
	void printList() {		
		String result = "";		
		ListNode temp_head = head;
		
		while(temp_head != null) {	
			result += temp_head.getValue() + "->";
			
			temp_head = temp_head.next;	
			
		}
		result += "null";
		System.out.println(result);		
	}
}


public class ReverseList {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);	//input
		int upper_limit = 5000, lower_limit = -5000;	//range
		int t = 0;	
		int number;
		ListNode numbers = new ListNode();	//original list
		ListNode reverse_numbers = new ListNode();	//reverse lists		
		
		//create original ListNode
		while(t == 0)
		{
			try 
			{
				System.out.println("請輸入欲加入Link之項目，數值範圍：-5000~5000 =>");	
				number=scanner.nextInt();	//input number
				
				if(number<=upper_limit && number>=lower_limit) {
					numbers.addLast(number);
					t = 0;
					
					System.out.println("是否繼續輸入欲加入Link之項目=> 1)YES 2)NO");
					
					try 
					{						
						if(scanner.nextInt() == 1) {
							t = 0;
						}
						else {
							break;
						}
					}
					catch(InputMismatchException e)
					{				
						System.out.printf("請重新輸入:\r\n",scanner.nextInt());
						t = -1;
					}
				}
				else {
					System.out.printf("數值超過範圍，請重新輸入\r\n");
					
					continue;
				}
			}
			catch(InputMismatchException e)
			{				
				System.out.printf("請重新輸入:\r\n",scanner.nextInt());
				t = -1;
			}			
		}
						
		System.out.print("original numbers：");
		numbers.printList();
		
		//reverse list
		ListNode copy_nummbers = numbers;
		ListNode current_head, current_next;
		
		while(copy_nummbers.head != null) {				
			reverse_numbers.addFirst(copy_nummbers.head.getValue());
			
			copy_nummbers.head = copy_nummbers.head.next;				
		}
		
		System.out.print("reverse numbers：");
		reverse_numbers.printList();
		
	}

}
