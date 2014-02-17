import java.util.ArrayList;


public class MyTree {
	MyNode root;
	
	public void insert(Object obj){
		MyNode myNode=new MyNode(obj);
		myNode.left=null;
		myNode.right=null;
		if(root==null){
			root=myNode;
			
		}else{
			insert(myNode);//,root);
			//System.out.println(root.left);
		}
	}
	
	public void insert(MyNode myNode){//,MyNode insertPos){
		if(this.root==null){
			this.root=myNode;
			return;
		}
		if((Integer)myNode.data<=(Integer)this.root.data){
			this.root.left=new MyTree();
			this.root.left.insert(myNode);//,insertPos.left);
		}else{
			this.root.right=new MyTree();
			this.root.right.insert(myNode);//,insertPos.right);
		}
		
		
	}
	
	public void inorder(){
		if(this.root==null){
			return;
		}
		this.root.left.inorder();
		System.out.print(this.root.data);
		this.root.right.inorder();
	}
	
	public void iterInorder(){
		ArrayList list=new ArrayList();
		MyStack stack=new MyStack();
		MyTree myNode=this;
		while(myNode.root!=null){
			//if(myNode.root!=null){
			stack.push(myNode);
			System.out.println(myNode.root.data);
			myNode=myNode.root.left;
			//}
		}
		MyTree popNode=null;
		while(stack.top!=null){
			popNode=(MyTree) stack.pop();
			System.out.print(popNode.root.data);
			popNode=popNode.root.right;
			while(popNode!=null){
				//if(popNode.root!=null){
				stack.push(popNode);
				//System.out.print(myNode.left.root.data);
				popNode=popNode.root.left;
				//}
			}
		}
		//stack.push(myNode);
//		while(myNode!=null){
//			stack.push(myNode.left.root);
//			myNode=myNode.left.root;
//		}
//		while(stack.top!=null){
//			MyNode popNode=(MyNode) stack.pop();
//			if(popNode!=null && !list.contains(popNode.data) ){
//				System.out.print(popNode.data);
//			}
//			if(popNode!=null && !list.contains(popNode.data) ){
//				System.out.print(popNode.data);
//			}
//			if(popNode!=null && !list.contains(popNode.data) ){
//				System.out.print(popNode.data);
//			}
//			if(!list.contains(popNode.root.data)){
//				System.out.print(popNode.root.data);
//				list.add(popNode.root.data);
//			}
//			MyTree curNode=popNode;
//			MyStack newStack=new MyStack();
//			while(curNode.root!=null){
//				newStack.push(curNode);
//				curNode=curNode.root.right;
//			}
//			while(newStack.top!=null){
//				MyTree popRight=(MyTree) newStack.pop();
//				if(!list.contains(popRight.root.data)){
//					System.out.print(popRight.root.data);
//					list.add(popRight.root.data);
//				}
//			}
//		}
		
		
	}
	
	public void preorder(){
		if(this.root==null){
			return;
		}
		System.out.print(this.root.data);
		this.root.left.preorder();
		this.root.right.preorder();
	}
	
	public static void main(String args[]){
		MyTree myTree=new MyTree();
		myTree.insert(6);
		myTree.insert(2);
		myTree.insert(7);
		myTree.insert(9);
		myTree.insert(1);
		myTree.insert(3);
		myTree.insert(8);
		//System.out.println(myTree.root.left);
		//myTree.inorder();
		System.out.println();
		myTree.iterInorder();
		//myTree.preorder();
		System.out.println();
		//myTree.postorder();
	}
	
	public void postorder(){
		if(this.root==null){
			return;
		}
		this.root.left.postorder();
		this.root.right.postorder();
		System.out.print(this.root.data);
		
	}
}




class MyNode{
	Object data;
	MyTree left;
	MyTree right;
	
	MyNode(Object data){
		this.data=data;
		this.left=new MyTree();
		this.right=new MyTree();
	}
}