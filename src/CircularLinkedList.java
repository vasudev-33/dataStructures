
public class CircularLinkedList {
	Node head;
	
	
	public void insert(int item){
		Node node=new Node(item);
		if(head==null){
			head=node;
			node.next=head;
		}else{
			Node cur=head;
			while(cur.next!=head){
				cur=cur.next;
			}
			cur.next=node;
			node.next=head;
		}
	}
	
	public void printList(){
		Node cur=head;
		while(cur.next!=head){
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
		System.out.print(cur.data);
	}
	
	public void recursivePrintList(Node node){
		if(node.next==head){
			System.out.print(node.data);
			return;
		}
		System.out.print(node.data+" ");
		recursivePrintList(node.next);
	}
	
	public boolean isCircular(Node head){
		Node cur=head;
		while(cur.next!=head){
			if(cur.next==null){
				return false;
			}
			cur=cur.next;
		}
		return true;
	}
	
	public boolean hasLoop(Node head){
		Node slow = head;
		Node fast=head;
		while(slow.next!=null && slow.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				return true;
			}
		}
		return false;
	}
	
	public int loopPos(Node head){
		Node slow = head;
		Node fast=head;
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				break;
			}
		}
		slow=head;
		System.out.println(slow.data);
		System.out.println(fast.data);
		while(fast.next!=null){// && fast.next.next!=null){
			
			if(slow==fast){
				return slow.data;
			}
			
			slow=slow.next;
			fast=fast.next;
			
		}
		return -1;
	}
	
	public void divideList(int splitPoint, LinkedList1 head1,LinkedList1 head2){
		Node cur=head;
		Node prev=null;
		
		if(head.data==splitPoint){
			head1.head=null;
			//head2.head=head;
			//return;
		}
		while(cur.next!=head){
			if(cur.data==splitPoint){
				if(prev!=null){
					prev.next=null;
				}
				head2.head=cur;
			}
			prev=cur;
			cur=cur.next;
		}
		
		if(cur.data==splitPoint){
			head1.head=cur;
			prev.next=null;
			cur.next=null;
			head2.head=head;
			return;
		}
		cur.next=null;
		if(head.data!=splitPoint)
		head1.head=head;	
	}
	
	public void iterReverse(){
		Node first=head;
		Node cur=head;
		Node prev=null;
		while(cur.next!=head){
			Node next=cur.next;
			cur.next=prev;
			
			prev=cur;
			cur=next;
			
		}
		cur.next=prev;
		
		head.next=cur;
		head=cur;
		
	}
	public Node recursiveReverse(Node node){
		if(node.next==head){
			head.next=node;
			head=node;
			return node;
		}
		Node cur=recursiveReverse(node.next);
		cur.next=node;
		return node;
	}
	
	
	public static void main(String args[]){
		CircularLinkedList cList=new CircularLinkedList();
		cList.insert(1);
		cList.insert(2);
		cList.insert(3);
		cList.insert(4);
		cList.printList();
		System.out.println();
		//cList.iterReverse();
		cList.recursiveReverse(cList.head);
		cList.printList();
		
		//cList.divideList(2);
		//cList.printList();
		//cList.recursivePrintList(cList.head);
		LinkedList1 linkedList=new LinkedList1();
		linkedList.insert(1);
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		linkedList.insert(5);
		linkedList.insert(6);
		
		LinkedList1 linkedList1=new LinkedList1();
		linkedList.insert(7);
		linkedList.insert(8);
		linkedList.insert(9);
		linkedList.insert(10);
		linkedList.insert(4);
		linkedList.insert(15);
		//LinkedList1 head1=new LinkedList1();
		//LinkedList1 head2=new LinkedList1();
		//cList.divideList(4,head1,head2);
		//head1.printList();
		//head2.printList();
		
		
		//System.out.println(cList.isCircular());
		//System.out.println(cList.isCircular(linkedList.head));
		//System.out.println(cList.loopPos(cList.head));
	}

}
