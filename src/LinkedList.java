import java.util.HashMap;


public class LinkedList{
	public static void main(String args[]){
		LinkedList1 list=new LinkedList1();
		Node head1=list.appendToList(7);
		Node three=list.appendToList(6);
		list.appendToList(5);
		list.appendToList(4);
		list.appendToList(3);
		list.appendToList(1);
		list.appendToList(2);
		list.printList(head1);
		list.DeleteInConstraint(head1, 2);
		list.printList(head1);
//		LinkedList1 linkedList=new LinkedList1();
//		linkedList.insert(1);
//		linkedList.insert(2);
//		linkedList.insert(3);
//		linkedList.insert(4);
//		linkedList.insert(5);
//		linkedList.insert(6);
//		
//		LinkedList1 linkedList1=new LinkedList1();
//		linkedList1.insert(7);
//		linkedList1.insert(8);
//		linkedList1.insert(9);
//		linkedList1.insert(10);
//		linkedList1.insert(4);
//		linkedList1.insert(15);
		
		
		//linkedList.findIntersect(linkedList, linkedList1);
		//Node newHead=list.partition(4, head1);
		//list.printList(newHead);
		
		
//		Node cur=head1;
//		while(cur.next!=null){
//			cur=cur.next;
//		}
//		Node high=cur;
//		Node mergedHead=list.mergeSort(head1,high);
//		list.printList(mergedHead);
		
		//list.swapElements(head1, 3, 5);
		//list.printList(head1);
		//LinkedList1 list2=new LinkedList1();
		//Node head2=list2.appendToList(8);
		//list2.appendToList(4);
		//Node newHead=list.swapAlternate(head1);
		//list.printList(newHead);
		//LinkedList1 list2=new LinkedList1();
		//Node head2=list2.appendToList(2);
		//list2.appendToList(4);
		//list2.appendToList(6);
		//list2.appendToList(8);
		//list.printList(head1);
		//list2.printList(head2);
		//Node sumHead=list.sumLists(head1,head2);
		//list.printList(sumHead);
		//Node first =  list.recursiveReverse(head1);
		//first.next = null;
		//list.printList(list.myHead);
		//list.printList(newHead);
		//list.appendToList(1);
		//head=list.appendToList(6);
		//list.printList(head1);
		//list.mergeAlternate(head1,head2);
		//list.remove(6);
		//list.printList(head1);
		//list.kthToLast(head, 1);
		//list.deleteMiddle(three);
		//list.divideList(3);
		//list.isPalindrome(head);
	}
}

class LinkedList1 {
	public Node head;
	
	LinkedList1(){
		head=null;
	}
	
	public int count(){
		Node cur=head;
		int counter=0;
		while(cur!=null){
			cur=cur.next;
			counter++;
		}
		return counter;
	}
	
	public void findIntersect(LinkedList1 list1,LinkedList1 list2){
		int count1=list1.count();
		int count2=list2.count();
		int diff=Math.abs(count1-count2);
		Node cur1=list1.head;
		Node cur2=list2.head;
		if(count1>count2){
			int count=0;
			while(count!=diff){
				cur1=cur1.next;
				count++;
			}
		}else{		
			int count=0;
			while(count!=diff){
				cur2=cur2.next;
				count++;
			}
		}
		while(cur1!=null&&cur2!=null){
			//if(cur1==cur2){
			//	System.out.println(cur1.data);
			//}
			System.out.println(cur1.data+" "+cur2.data);
			if(cur1.data==cur2.data){
				System.out.println(cur1.data);
			}
			cur1=cur1.next;
			cur2=cur2.next;
		}
	}
	
	public Node appendToList(int d){
		Node node=new Node(d);
		if(head==null){
			head=node;
			return node;
		}
		Node cur=head;
		while(cur.next!=null){
			cur=cur.next;
		}
		cur.next=node;
		return node;
		
	}
	
	public void printList(Node head){
		if(head==null){
			System.out.println("no elements in list");
			return;
		}
		Node cur=head;
		//int count=0;
		//double num=0;
		while(cur!=null){
			//num=num+cur.data*Math.pow(10, count);
			//count++;
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
		System.out.println();
	}
	
	public void remove(int d){
		if(head.data==d){
			head=head.next;
			return;
		}
		Node cur=head;
		
		
		while(cur.next.data!=d){
			
			cur=cur.next;
		}
		cur.next=cur.next.next;
	}
	
	public void kthToLast(Node head,int k){
		Node slowPointer=head;
		Node cur=head;
		int count=1;
		while(cur.next!=null){
			
			if(count==k){
				slowPointer=slowPointer.next;
				count=0;
			}	
			cur=cur.next;
			count=count+1;
		}
		System.out.println(slowPointer.data);
	}
	
	public void deleteMiddle(Node middle){
		Node cur=middle;
		while(cur.next.next!=null){
			cur.data=cur.next.data;
			cur=cur.next;
		}
		cur.data=cur.next.data;
		cur.next=null;
	}
	
	public void divideList(int d){
		Node newHead=null;
		Node cur=head;
		Node rightDataNode=null;
		Node leftDataNode=null;
		while(cur.next!=null){
			if(cur.data==d && rightDataNode==null){
				rightDataNode=cur;
			}else if(cur.data<d && leftDataNode==null){
				leftDataNode=cur;	
			}
			cur=cur.next;
		}
		cur=head;
		Node prev=null;
		head=leftDataNode;
		Node rightDataNodeNext=rightDataNode.next;
		Node leftDataNodeNext=leftDataNode.next;
		Node dupRightDataNode=rightDataNode;
		Node dupLeftDataNode=leftDataNode;
		while(cur.next!=null){
			
			if (cur==dupLeftDataNode){
				cur=leftDataNodeNext;
				continue;
			}else if(cur==dupRightDataNode){
				cur=rightDataNodeNext;
				continue;
			}
			if(cur.data>d){
				//prev=cur;
				//cur=cur.next;
				rightDataNode.next=cur;
				rightDataNode=cur;
				
				cur=cur.next;
				rightDataNode.next=null;
				
			}else{
				leftDataNode.next=cur;
				leftDataNode=cur;
				cur=cur.next;
				
			}
			
			
		}
		if(cur.data<d){
			leftDataNode.next=cur;
			cur.next=dupRightDataNode;
		}else if(cur.data>d){
		
			rightDataNode.next=cur;
			cur.next=null;
		}
	}
	
	public void hasLoop(Node head){
		Node slow=head;
		Node fast=head.next.next;
		while(slow!=fast){
			fast=fast.next.next;
			slow=slow.next;
		}
	}
	
	public void isPalindrome(Node head){
		Node cur=head;
		Node newHead=null;
		while(cur!=null){
			Node node=new Node(cur.data);
			node.next=newHead;
			newHead=node;
			cur=cur.next;		
		}
		printList(newHead);
		
		Node cur1=head;
		Node cur2=newHead;
		while(cur1!=null && cur2!=null){
			if(cur1.data!=cur2.data){
				break;
			}
			cur1=cur1.next;
			cur2=cur2.next;	
		}
		if(cur1==null && cur2==null){
			System.out.println("Palindrome");
		}else{
			System.out.println("Not palindrome");
		}
		
	}
	
	public void mergeAlternate(Node head1, Node head2){
		Node cur1=head1;
		Node cur2=head2;
		
		while(cur1!=null && cur2!=null){
			Node prev1=cur1;
			Node prev2=cur2;
			cur1=cur1.next;
			cur2=cur2.next;
			prev2.next=prev1.next;
			prev1.next=prev2;	
		}
	}

	
	//not working
	public Node swapAlternate(Node head){
		//Node swap1=head;
		//Node swap2=head.next;
		//Node newHead=swap1.next;
//		while(swap1!=null&&swap1.next!=null){
//			Node swap2=swap1.next;
//			swap1.next=swap2.next;
//			swap2.next=swap1;
//			swap1=swap1.next;
//			
//		}
		Node cur=head;
		Node newHead=cur.next;
		while(cur!=null){
			Node swap1=cur;
			Node swap2=cur.next;
			cur=swap2.next;
			swap1.next=swap2.next;
			swap2.next=swap1;
			//swap1=swap1.next;
		}
		return newHead;
	}
	
	public void findIntersectUnion(Node head1,Node head2){
		Node cur1=head1;
		Node cur2=head2;
		Node union=null;
		Node intersect=null;
		HashMap map=new HashMap();
		while(cur1!=null){
			map.put(cur1.data, true);
			Node node=new Node(cur1.data);
			
			cur1=cur1.next;
		}
	
		
	}
	
	public Node reverse(Node node){
		
		Node cur=node;
		Node next=cur.next;
		Node prev=null;
		while(cur.next!=null){
			cur.next=prev;
			prev=cur;
			cur=next;
			next=next.next;
		}
		cur.next=prev;
		
		return cur;
	}
	Node myHead;
	
	public Node recursiveReverse(Node node){
		if(node.next==null){
		
			myHead = node;
			return node;
		}
		
		Node cur=recursiveReverse(node.next);
		cur.next=node;
		System.out.println(cur.data + " " +cur.next.data);
		
		//System.out.println(node.data+" "+cur.data);
	
		return node;
		//System.out.print(node.data+" ");
		
		
	}
	
	public Node sumLists(Node head1,Node head2){
		Node sumHead=null;
		Node cur1=head1;
		Node cur2=head2;
		int carry=0;
		while(cur1!=null||cur2!=null){
			
			int sum=carry+(cur1==null?0:cur1.data)+(cur2==null?0:cur2.data);
			
			if(sum>=10){
				carry=1;
				sum=sum%10;
			}else{
				carry=0;
			}
			Node node=new Node(sum);
			if(sumHead==null){
				sumHead=node;
			}else{
				Node curNode=sumHead;
				while(curNode.next!=null){
					curNode=curNode.next;
				}
				curNode.next=node;
			}
			if(cur1!=null)
			cur1=cur1.next;
			if(cur2!=null)
			cur2=cur2.next;
			
		}
		return sumHead;
		
	}
	
	public void swapElements(Node head,int num1,int num2){
		Node cur=head;
		Node prev=null;
		Node swap1=null;
		Node swap1Prev=null;
		Node swap2Prev=null;
		Node swap2Next=null;
		Node swap2=null;
		while(cur!=null){
			if(cur.data==num1){
				swap1=cur;
				swap1Prev=prev;
			}
			else if(cur.data==num2){
				swap2=cur;
				swap2Prev=prev;
			}
			cur=cur.next;
			prev=cur;
		}
		
		if(swap1.data==swap2.data){
			return;
		}
		if(swap1Prev!=null && swap1Prev!=swap2){
		swap1Prev.next=swap2;
		}
		if(swap1Prev==null){
			head=swap2;
		}
		if(swap2Prev!=swap1 && swap2Prev!=null){
		swap2Prev.next=swap1;
		}
		if(swap2Prev==null){
			head=swap1;
		}
		if(swap1.next!=swap2){
		swap2.next=swap1.next;
		}else{
			swap2.next=swap1;
		}
		if(swap1!=swap2Next){
		swap1.next=swap2Next;
		}else{
			swap1.next=swap2;
		}
		
		
		
		
	}
	
	public void mergeSort(Node head){
		int low=0;
		int high=0;
		Node cur=head;
		
		while(cur.next!=null){
			cur=cur.next;
			
		}
		Node last=cur;
		mergeSort(head,last);
	}
	
	public Node mergeSort(Node low,Node high){
//		Node cur=low;
//		boolean isLowLess=false;
//		while(cur!=null){
//			cur=cur.next;
//			if(cur==high){
//				isLowLess=true;
//				break;
//				
//			}
//		}
		if(low.next==null){
			return low;
		}
		
		Node cur=low;
		Node mid=low;
		while(cur.next!=null && cur.next.next!=null){
			cur=cur.next.next;
			mid=mid.next;
		}
		Node list2=mid.next;
		mid.next=null;
		
		Node head1=mergeSort(low,mid);
		Node head2=mergeSort(list2,high);
		Node mergedHead=merge(head1,head2);
		return mergedHead;
		
		
	}
	
	private Node merge(Node head1, Node head2) {
		LinkedList1 list=new LinkedList1();
		Node cur1=head1;
		Node cur2=head2;
		while(cur1!=null && cur2!=null){
			if(cur1.data<cur2.data){
				//Node newNode=new Node(cur1.data);
				list.insert(cur1.data);
				cur1=cur1.next;
			}else{
				//Node newNode=new Node(cur2.data);
				list.insert(cur2.data);
				cur2=cur2.next;
			}
		}
		while(cur1!=null){
			list.insert(cur1.data);
			cur1=cur1.next;
		}
		while(cur2!=null){
			list.insert(cur2.data);
			cur2=cur2.next;
		}
		
		return list.head;
	}
		
	public void insert(int item){
		Node newNode=new Node(item);
		if(this.head==null){
			head=newNode;
		}else{
			Node cur=head;
			while(cur.next!=null){
				cur=cur.next;
			}
			cur.next=newNode;
		}
			
	}
	
	public Node partition(int key,Node head){
		Node cur=head;
		while(cur.next!=null){
			cur=cur.next;
		}
		Node last=cur;
		System.out.println(last.data);
		cur=head;
		Node prev=null;
		Node fixedLast=last;
		while(cur!=fixedLast.next){
			//System.out.println(cur.data);
			if(cur.data<key){
				prev=cur;
				cur=cur.next;
				
			}else if(cur.data==key){
				if(prev==null){
					head=cur.next;
					
				}else{
					prev.next=cur.next;
					
				}
				Node nextFixedLast=fixedLast.next;
				fixedLast.next=cur;
				Node nextCur=cur.next;
				cur.next=nextFixedLast;
				cur=nextCur;
				
			}else{
				last.next=cur;
				last=cur;
				if(prev==null){
					head=cur.next;
					prev=null;
				}else{
					prev.next=cur.next;
					prev=cur;
				}
				
				cur=cur.next;
				last.next=null;
			}
		}
		return head;
	}
	
	public void printList(){
		if(head==null){
			System.out.println("no elements in list");
			return;
		}
		Node cur=head;
		//int count=0;
		//double num=0;
		while(cur!=null){
			//num=num+cur.data*Math.pow(10, count);
			//count++;
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
		System.out.println();
		
	}
	
	public void DeleteInConstraint(Node head,int key){
		Node cur=head;
		Node prev=null;
		while(cur!=null){
			
			if(cur.data==key){
				if(cur==head){
					head.data=head.next.data;
					head.next=head.next.next;
				}else{
					prev.next=cur.next;
				}
			}
			prev=cur;
			cur=cur.next;
		}
	}
		
}

class Node{
	int data;
	Node next;
	//Node prev;
	public Node(int d){
		data=d;
		next=null;
	}
	
	public Node(){
		
	}

}

