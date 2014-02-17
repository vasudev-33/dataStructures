
public class DoublyLinkedList<T> {
	
	LinkNode<T> head;
	
	DoublyLinkedList(){
		this.head=null;
	}
	
	public void insert(T data){
		LinkNode<T> cur=head;
		LinkNode<T> node=new LinkNode<T>(data);
		if(head==null){
			head=node;
			return;
		}
		while(cur.next!=null){
			cur=cur.next;
		}
		cur.next=node;
		node.prev=cur;
	}
	
	public void printList(){
		LinkNode<T> cur=head;
		while(cur.next!=null){
			System.out.print(cur.data+" ");
			cur=cur.next;
			
		}
		System.out.print(cur.data);
		System.out.println();
		while(cur.prev!=null){
			System.out.print(cur.data+" ");
			cur=cur.prev;
		}
		System.out.print(cur.data+"\n");
	}
	
	public void delete(T key){
		LinkNode<T> cur=head;
		
		while(cur!=null){
			if(cur.data==key){
				if(cur.next!=null){
					cur.next.prev=cur.prev;
				}
				if(cur.prev!=null){
					cur.prev.next=cur.next;
				}
				else{
					head=cur.next;
					cur.next.prev=null;
				}
			}
			cur=cur.next;
			
		}
	}
	
	public void reverse(){
		LinkNode<T> cur=head;
		while(cur!=null){
			if(cur.next==null){
				head=cur;
			}
			
			LinkNode<T> node=cur.next;
			cur.next=cur.prev;
			cur.prev=node;
			
			cur=node;
			
			
		}
		
	}
	
	public static void main(String args[]){
		DoublyLinkedList<Integer> list=new DoublyLinkedList<Integer>();
		list.insert(1);;
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.printList();
		//list.delete(2);
		//list.printList();
		//list.delete(1);
		//list.printList();
		//list.delete(4);
		//list.printList();
		list.reverse();
		list.printList();
	}
	
	
}

class LinkNode<T>{
	T data;
	LinkNode<T> prev;
	LinkNode<T> next;
	
	LinkNode(T data){
		this.data=data;
		this.prev=null;
		this.next=null;
	}
}
