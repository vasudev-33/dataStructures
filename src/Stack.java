


class MyStack {
	StackNode top;
	
	MyStack(){
		
	}
	
	public void push(Object item){
		StackNode node=new StackNode(item);
		node.next=top;
		top=node;
	}
	
	public Object pop(){
		if(top==null){
			return null;
		}else{
			//System.out.println(top.data);
			Object data=top.data;
			top=top.next;
			return data;
		}
	}
	
	public Object peek(){
		return top.data;
	}
}

class StackNode{
	Object data;
	StackNode next;
	StackNode(Object data){
		this.data=data;
	}
}