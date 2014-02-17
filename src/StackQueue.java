
public class StackQueue {
	
	MyStack one=new MyStack();
	MyStack two=new MyStack();
	StackNode first;
	StackNode last;
	
	void enque(Object obj){
		one.push(obj);
		//two.push(obj);
		//one.pop();
		//if(first==null){
		//	first=one.top;
		//	two.top=one.top;
		//}
		//last=one.top;
		
		//first.next=last;
	}
	
	Object deque(){
		StackNode cur=last;
		while(one.top!=null){
			two.push(one.pop());
			
		}
		Object obj=two.pop();
		while(two.top!=null){
			one.push(two.pop());
			
		}
		//first=two.top;
		//first.next=null;
		return obj;
	}
	
	void print(){
		StackNode cur=last;
		while(cur!=first){
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
	}
	
	public static void main(String args[]){
		StackQueue stackQueue=new StackQueue();
		stackQueue.enque(1);
		stackQueue.enque(2);
		stackQueue.enque(3);
		System.out.println(stackQueue.deque());
		System.out.println(stackQueue.deque());
		stackQueue.enque(4);
		System.out.println(stackQueue.deque());
		System.out.println(stackQueue.deque());
		//stackQueue.deque();
		//stackQueue.print();
	}

}
