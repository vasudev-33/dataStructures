import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class CTCITree {
	
	TreeNode root;
	
	CTCITree(TreeNode root){
		this.root=root;
	}
	
	CTCITree(){
		this.root=null;
	}
	
	public static void main(String args[]){
	  CTCITree tree=new CTCITree(new TreeNode(10));
	  tree.root.setLeft(new TreeNode(5));
	  tree.root.setRight(new TreeNode(15));
	  tree.root.getLeft().setLeft(new TreeNode(2));
	  tree.root.getLeft().setRight(new TreeNode(9));
	  tree.root.getRight().setLeft(new TreeNode(13));
	  tree.root.getRight().setRight(new TreeNode(18));
	  tree.root.getRight().getRight().setLeft(new TreeNode(17));
	  tree.root.getRight().getRight().setRight(new TreeNode(19));
	  tree.getInorderSuccessor(tree.root, 9);
	  //System.out.println(tree.isBalanced());
	//  tree.createLinkedListLevelWise(tree.root);
	  //System.out.println(tree.isBinSearchTree(tree.root));
	 
	  
//	  CTCITree tree=new CTCITree();
//	  int arr[]={1,2,3,4,5,6,7,8,9,10,11};
//	  tree.root=tree.createBinSearchTree(arr, 0, arr.length-1);
//	  System.out.println(tree.root.getData());
//	  System.out.println(tree.root.getLeft().getData());
//	  tree.inOrder(tree.root);
	  
	}
	
	public boolean isBalanced(){
		int leftHeight=getHeight(root.getLeft());
		int rightHeight=getHeight(root.getRight());
		if(Math.abs(leftHeight-rightHeight)>1){
			return false;
		}else{
			return true;
		}
	}
	
	public int getHeight(TreeNode node){
		if(node==null){
			return 0;
		}
		int leftHeight=1+getHeight(node.getLeft());
		int rightHeight=1+getHeight(node.getRight());
		return Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode createBinSearchTree(int arr[],int low,int high){
		if(low==high){
			TreeNode node=new TreeNode(arr[low]);
			node.setLeft(null);
			node.setRight(null);
			return node;
		}
		if(low>high){
			return null;
		}
		int mid=(low+high)/2;
		TreeNode treeNode=new TreeNode(arr[mid]);
		treeNode.setLeft(createBinSearchTree(arr,low,mid-1));
		treeNode.setRight(createBinSearchTree(arr, mid+1, high));
		return treeNode;
	}
	
	public void createLinkedListLevelWise(TreeNode node){
		Queue myQueue=new ArrayBlockingQueue(100);
		int level=0;
		if(node==null)
			return;
		LinkedList1[] list=new LinkedList1[10];
		myQueue.add(new QueueObj(node,level));
		int curLevel=0;
		LinkedList1 curList=new LinkedList1();
		list[curLevel]=curList;
		while(!myQueue.isEmpty()){
			QueueObj queueObj=(QueueObj) myQueue.remove();
			if(queueObj.level==curLevel){
				curList.appendToList(queueObj.node.getData());
				//System.out.println(queueObj.node.getData()+" "+queueObj.level);
			}else{
				//list[curLevel]=curList;
				LinkedList1 newList=new LinkedList1();
				newList.appendToList(queueObj.node.getData());
				//System.out.println(queueObj.node.getData()+" "+queueObj.level);
				curList=newList;
				curLevel=queueObj.level;
				list[curLevel]=curList;
			}
			if(queueObj.node.getLeft()!=null)
			myQueue.add(new QueueObj(queueObj.node.getLeft(),queueObj.level+1));
			if(queueObj.node.getRight()!=null)
			myQueue.add(new QueueObj(queueObj.node.getRight(),queueObj.level+1));
		}
		
		
		for(int i=0;i<list.length;i++){
			//System.out.println(i);
			LinkedList1 tempList=list[i];
			if(tempList!=null)
			tempList.printList();
		}
		
	}
	
	public void inOrder(TreeNode node){
		if(node==null){
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getData()+" ");
		inOrder(node.getRight());
	}
	
	public boolean isBinSearchTree(TreeNode node){
		if(node==null){
			return true;
		}
		
		boolean isRight=isBinSearchTree(node.getLeft());
		boolean isLeft=isBinSearchTree(node.getRight());
		if(!(isRight && isLeft))
			return false;
		
		if(node.getRight()!=null){
			if(node.getRight().getData()>node.getData()){
				isRight=true;
			}else{
				isRight=false;
			}
		}
		if(node.getLeft()!=null){
			if(node.getLeft().getData()<node.getData()){
				isLeft=true;
			}else{
				isLeft=false;
			}
		}
		return isRight && isLeft;
		
	}
	
	public TreeNode getInorderSuccessor(TreeNode node,int data){
		if(node==null){
			return null;
		}
		if(node.getData()==data){
			return node;
		}
		TreeNode leftNode=getInorderSuccessor(node.getLeft(), data);
		TreeNode next=node;
		//if(leftNode!=null)
			//System.out.println(leftNode.getData()+next.getData());
		TreeNode rightNode=getInorderSuccessor(node.getRight(), data);
		if(leftNode!=null && leftNode.getData()==data)
			System.out.println(leftNode.getData()+" "+next.getData());
		if(rightNode!=null && rightNode.getData()==data)
			System.out.println(rightNode.getData()+" "+next.getData());
		return null;
		//System.out.println(node.getData()+" "+next.getData());
	}
	
	class QueueObj{
		TreeNode node;
		int level;
		
		QueueObj(TreeNode node,int level){
			this.node=node;
			this.level=level;
		}
	}

}
