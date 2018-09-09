/*
 * The question to understand Singly linked list delete method
 * Source https://codereview.stackexchange.com/questions/112396/singly-linked-list-delete-method
 */

//import data_structures.LinkedLists.SinglyLinkedNode;

public class SinglyLinkedList{
	private SinglyLinkedNode head = null;
	private SinglyLinkedNode tail = null;
	private int length = 0;

	public SinglyLinkedList(int data){
		this.head = new SinglyLinkedNode(data);
		this.tail = this.head;
		this.length = 1;
	}

	public void delete(int data){
		SinglyLinkedNode n = this.head;
		if (n == null){
			return;
		}
		if (n.getData()==data){
			//If the head is the data we want
			if (n.getNext()==null){//If it's the only node, null the head and tail
				this.tail = null;
				this.head = null;
				this.length = 0;
			}
			else { //Or move the head to the next node
				this.head = n.getNext();
				this.length--;
			}
			return;
		}
		while (n.getNext()!=null && n.getNext().getData()!=data){//Get the data node or the last node at n.next
			n = n.getNext();
		}
		if (n.getNext() == null){//If n is the last element in the list
			if(n.getData()!=data){
				return;
			}
			//If we're deleting the only remaining element
			if (this.length <=1){
				this.tail = null;
				this.head = null;
				this.length = 0;
			}
			else {//If we're just moving the tail
				n.setNext(null);
				this.tail = n;
				this.length--;
			}
		}
		else {//If n is not the last element
			if (n.getNext().getNext()==null){//If n.next is the last element
				n.setNext(null);
				this.tail = n;
				this.length--;
			}
			else {//If n.next is not the last element
				n.setNext(n.getNext().getNext());
				this.length--;
			}
		}
	}

	//Inner class SinglyLinkedNode
	class SinglyLinkedNode{
		private SinglyLinkedNode next = null;
		int data;
		public SinglyLinkedNode(int data){
			this.data = data;
		}
		public int getData(){
			return this.data;
		}
		public void setNext(SinglyLinkedNode next){
			this.next = next;
		}
		public SinglyLinkedNode getNext(){
			return this.next;
		}
	}
}