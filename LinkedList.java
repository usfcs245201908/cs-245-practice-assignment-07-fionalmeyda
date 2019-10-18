
import java.util.EmptyStackException;
import java.util.*;
import java.util.Iterator;
public class LinkedList<T> implements List<T>{
	Node<T> head = null;
	int N =0;

	public class Node<T>{
		T data;
		Node<T> next;
		Node(T d){
			data = d;
			next = null;
		}

	}
	public LinkedList(){
		head= null;
		N = 0;
	}


	public int size() {
		return N;
	}

	public void add(T item){
		if(head == null){
			head = new Node(item);
			++N;
		}else{
			Node<T> node = new Node<T>(item);
			Node<T> prev = head;
			while(prev.next != null){
				prev=prev.next;
			}
			prev.next = node;
			++N;
		}
	}
	public void add( int pos,T item){
		if(pos+1>N||pos<0){
			throw new EmptyStackException();
		}
		if(pos==0){
			Node<T> node = new Node<T>(item);
			node.next = head;
			head=node;
			++N;
		}else{
			Node<T> node = new Node<T>(item);
			Node<T> prev = head;


			for(int i=0;i<pos-1;i++){
				prev=prev.next;
			}
			
			node.next=prev.next;
			prev.next= node;
			++N;
		}
	}
	public T get(int pos){
		if(head==null) throw new EmptyStackException();
		Node<T> temp = head;
		for(int i = 0;i<pos;i++){
			temp = temp.next;
		}
		if(temp == null) throw new EmptyStackException();
		return temp.data;
	}
	public T remove(int pos){
		if(pos>N||pos<0){
			throw new EmptyStackException();
		}
		if(pos==0){
			Node<T> node =head;
			head=head.next;
			--N;
			return node.data;
		}else{
			Node<T> prev = head;
			for(int i = 0 ; i<pos;i++){
				prev=prev.next;
			}
			Node<T> node =prev.next;
			prev.next = node.next;
			--N;
			return node.data;
		}
		
	}






















}

    	