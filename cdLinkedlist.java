import java.util.Scanner;
class Node{
	int data;
	Node prev;
	Node next;
	public Node(int data)
	{
		this.data=data;
	}
}
public class cdLinkedlist {
	Node start;
	public void create(int data) {
		Node l=start;
		Node newNode=new Node(data);
		if(start==null) {
			start=newNode;
			newNode.next=start;
			newNode.prev=l;

		}
		else {
			while(l.next != start) {
				l=l.next;
			}
			
			l.next=newNode;
			newNode.next=start;
			newNode.next=start;
			start.prev=newNode;
			l=l.next;
		}
	}

public void print(){
    Node l=start;
    while(l!=null)
    {
        System.out.print(l.data+"<->");
        l=l.next;
        if(l==start)
        {
           break;
        }
    }
    System.out.println();
    
    
    
}
public void inserAtbeing(int data){
    	Node l=start;
	Node newNode=new Node(data);
	System.out.println("insertAtbegin:");
	if(start==null) {
		System.out.println("list is empty");
	}
	else {
	   while(l.next!=start){
	        l=l.next;
	    
	   }
	   newNode.next=start;
	   start.prev=newNode;
	   start=newNode;
	   l.next=newNode;
	   
	    
	}
}
public void insertAtEnd(int data) {
	Node l=start;
	Node newNode=new Node(data);
	System.out.println("insert at end:");
	while(l.next!=start) {
		l=l.next;
	}
	l.next=newNode;
	newNode.prev=l;
    l=l.next;
    newNode.next=start;

}
public void insertAtMiddle(int data,int position) {
	int i;
	Node l=start;
	Node newNode=new Node(data);
	System.out.println("insert at middle:");
	if(start==null) {
		start=newNode;
	}
	for(i=1;i<position-1;i++) {
		
		l=l.next;
	}
	newNode.next=l.next;
	l.next=newNode;
	l.next.prev=newNode;
    newNode.prev=l;

}
public void deleteAtBegin() {
	Node d=start;
	System.out.println("deleting element at begin:");
	System.out.println("data deleting "+d.data);
	 Node l = start;
        while (l.next != start) {
            l= l.next;  
        }
        start = start.next;
        start.prev=d;
        l.next=start;
        
        d.next=null;

        
}
public void deleteAtEnd()
{
	Node l=start;
	System.out.println("deleteing end element the list");
	if (start==null) {
		System.out.println("list is empty");
	}
	else {
		while(l.next.next!=start) {
			l=l.next;
		}
		Node d=l.next;
		System.out.println("deleted element "+d.data);
		l.next=d.next;
		l.next=start;
		l.next=null;
	}
}
public void deleteAtMiddle()
{
	Node l=start;
	int position;
	
	System.out.println("enter position to delete the element ");
	Scanner sc=new Scanner(System.in);
	position=sc.nextInt();
	if(start==null) {
		System.out.println("Empty list");
	}
	else {
		for(int i=1;i<position-1;i++) {
			l=l.next;
		}
		Node d=l.next;
		System.out.println("deleted element "+d.data);
		l.next=d.next;
		d.next=l.next;
		
		d.next=null;
	}
}
public void count(){
     Node l=start;
	 int count=0;
	if(start==null) {
		System.out.println("list is empty");
	}
	else {
		while(l!=null) {
			l=l.next;
			count++;
			
		}
		System.out.println("count "+count);
	}
}
public void search(int elem){
    	Node l=start;
	int f=0;
	System.out.println("searching the element.........."+elem);
	if(start==null) {
		System.out.println("empty list");
	}
	else {
		while(l.next!=null) {
			if(l.data==elem) {
				f=1;
				break;
			}
			l=l.next;
		}
		if(f==1) {
			System.out.println("element found");
		}
		else {
			System.out.println("element not found");
		}
	}
}
public void sort() {
	Node pass,l;
	int temp;
	System.out.println("list is sorted");
	for(pass=start;pass.next!=null;pass=pass.next) {
		for(l=start;l.next!=null;l=l.next) {
			if(l.data>l.next.data) {
				temp=l.data;
				l.data=l.next.data;
				l.next.data=temp;
			}
		}
	}
}
public void reverse() {
	Node ll=null;
	Node l=start;
	Node t=null;
	System.out.println("list is reversed");
	while(l!=null) {
		t=l.next;
		l.next=ll;
		ll=l;
		l=t;
	}
	start=ll;
	
}

 public static void main(String[] args) {
		cdLinkedlist list=new cdLinkedlist();
		list.create(10);
		list.create(20);	
		list.create(30);
		list.create(40);
		list.create(50);
		list.create(60);
		list.print();
		list.inserAtbeing(100);
		list.print();
        list.insertAtEnd(20);
        list.print();
        list.insertAtMiddle(400,3);
        list.print();
        list.deleteAtBegin();
        list.print();
        list.deleteAtEnd();
        list.print();
        list.deleteAtMiddle();
        list.print();
        list.count();
        list.search(100);
        list.sort();
        list.print();
        list.reverse();
        list.print();
}
}