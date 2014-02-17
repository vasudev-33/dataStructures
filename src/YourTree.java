import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

class YourTree{
    private TreeNode root;
    
    YourTree(TreeNode root){
    	this.root=root;
    }
    
    public TreeNode getRoot(){
    	return root;
    }
    
    
    
    public TreeNode convertListToBinary(Node head){
    	ArrayBlockingQueue q=new ArrayBlockingQueue(1000);
    	Node cur=head;
    	TreeNode root=new TreeNode(cur.data);
    	q.add(root);
    	while(cur!=null){
    		TreeNode popNode=(TreeNode)q.remove();
    		if(popNode!=null){
    		cur=cur.next;
    		if(cur!=null){
    		TreeNode left=new TreeNode(cur.data);
    		popNode.setLeft(left);
    		q.add(left);
    		}
    		cur=cur.next;
    		if(cur!=null){
    		TreeNode right=new TreeNode(cur.data);
    		popNode.setRight(right);
    		q.add(right);
    		}
    		
    		
    		}
    	}
    	return root;
    }
    
    public void findRight(TreeNode root){
       
    }
    
    public void traverse(TreeNode node){//, int level){
    	if(node==null)
    		return;
    	traverse(node.getLeft());
    	System.out.print(node.getData() + " " );
    	traverse(node.getRight());      
    }
    
    public void showLevel(TreeNode node,int level){
    	if(node==null){
    		return;
    	}
    	showLevel(node.getLeft(),level-1);
    	showLevel(node.getRight(),level-1);
    	System.out.print(node.getData()+"-"+level+" ");
    	
    }
    
    public int getHeight(TreeNode node){
    	if(node==null){
    		return 0;
    	}
    	return Math.max(getHeight(node.getLeft()),getHeight(node.getRight())) + 1;
    }
    
    public void showEveryLevel(TreeNode node,int level,int key , int levelToFind){
    	if(node==null){
    		return;
    	}
    	
    	if(level==levelToFind){
    		System.out.println("Next Element:" +node.getData());
    		return;
    	}
    	
    	if(node.getData()==key){
    		levelToFind = level;
    		System.out.println(levelToFind);
		}
		//System.out.print(node.getData());
    	showEveryLevel(node.getLeft(),level-1,key, levelToFind);
    	showEveryLevel(node.getRight(),level-1,key, levelToFind);
    	
    	//System.out.print(node.getData()+"-"+level+" ");
    	
    }
    
    public void getLeaves(TreeNode node){
    	if(node.getLeft()==null&&node.getRight()==null){
    		System.out.print(node.getData());
    		return;
    	}
    	getLeaves(node.getLeft());
    	getLeaves(node.getRight());
    }
    
    public int getSum(TreeNode node,int sum,int key){
    	
    	if(node==null){
    		return sum;
    	}
    	sum+=node.getData();
    	int leftsum=getSum(node.getLeft(),sum,key);
    	int rightsum=getSum(node.getRight(),sum,key);
    	if(leftsum<key && rightsum<key){
    		System.out.println("deleteing "+node.getData());
    	}
    	return Math.max(leftsum, rightsum);
    }
    
    public int reverseInOrder(TreeNode node,int sum){
    	if(node==null){
    		return sum;
    	}
    	
    	int rightsum=reverseInOrder(node.getRight(),sum);
    	
    	sum = node.getData()+ rightsum;
    	//rightSum=node.getData()+sum;
    	//sum=sum+node.getData();
    	System.out.print(node.getData()+" ");
    	System.out.println(sum);
    	int leftsum=reverseInOrder(node.getLeft(),sum);
    	
    	
    	return leftsum;
    }
    int maxLevel=1;
    public void levelOrderTraversal(TreeNode node,int level){
    	if(node==null){
    		return;
    	}
    	if(level==maxLevel){
    		System.out.println(node.getData());
    		maxLevel++;
    		
    	}
    	levelOrderTraversal(node.getLeft(),level+1);
    	levelOrderTraversal(node.getRight(),level+1);
    	
    }
    int curLevel=-1;
    public boolean areLeavesSameLevel(TreeNode node,int level){
    	//if(node==null){
    		//return;
    	//}
    	if(node.getLeft()==null && node.getRight()==null){
    		if(curLevel!=-1&&curLevel!=level){
    			return false;
    		}else{
    			curLevel=level;
    			return true;
    		}
    	}
    	
    	if(node.getLeft() !=null)
    	if(!areLeavesSameLevel(node.getLeft(), level+1)){
    		return false;
    	}
    	if(node.getRight() !=null)
    	if(!areLeavesSameLevel(node.getRight(), level+1)){
    		return false;
    	}
    	return true;
    }
    //int maxOddLevel=-1;
    public int findDeepestTreeNode(TreeNode node,int level){
    	int maxOddLevel=-1;
    	if(node==null){
    		return maxOddLevel;
    	}
    	if(node.getLeft()==null && node.getRight()==null){
    		if(level%2!=0){
    			maxOddLevel=level;
    			return maxOddLevel;
    		}
    		
    	}
    	int leftOddLevel=findDeepestTreeNode(node.getLeft(), level+1);
    	int rightOddLevel=findDeepestTreeNode(node.getRight(), level+1);
    	return Math.max(leftOddLevel, rightOddLevel);
    	//System.out.println(maxOddLevel);
    }
    	
    	public void printAncestors(TreeNode node,int key){
    		Stack stack=new Stack();
    		
    		while(node!=null){
    			if(node.getData()==key){
    				while(!stack.isEmpty()){
    					System.out.print(((TreeNode) stack.pop()).getData()+" ");
    				}
    				break;
    			}
    			stack.push(node);
    			
    			if(node.getLeft()!=null){
    				node=node.getLeft();
    				continue;
    			}
    			if(node.getRight()==null){
    				TreeNode popNode=(TreeNode)stack.pop();
    				TreeNode peekNode=(TreeNode) stack.peek();
    				while(!stack.isEmpty() && peekNode.getRight().getData()==popNode.getData())
    					popNode=(TreeNode)stack.pop();
    					peekNode=(TreeNode)stack.peek();
    				node=peekNode.getRight();
    			}else{
    			node=node.getRight();
    			}
    			
    			
    		}
    		
    		
    		
    	}
    	//TreeNode last=null;
    	TreeNode head=null;
    	public void inOrderDoublyLink(TreeNode node){
    		if(node==null){
    			return;
    		}
    		inOrderDoublyLink(node.getLeft());
    		if(head==null){
    			head=node;
    		}else{
    			TreeNode cur=head;
    			while(cur.getLeft()!=null){
    				cur=cur.getLeft();
    			}
    		}
    		inOrderDoublyLink(node.getRight());
    	}
    	
    	public void deleteInRange(TreeNode node,int min,int max){
    		if(node.getLeft()==null&&node.getRight()==null){
    			return;
    		}
    		
//    		if(node.getData()<=min){
//    			node.setLeft(null);
//    		}
    		if(node.getLeft().getData()<=min){
    			if(node.getLeft().getRight()!=null){
    				node.setLeft(node.getLeft().getRight());
    			}
    			//node.setLeft(null);
    		}
//    		if(node.getData()>=max){
//    			node.setRight(null);
//    		}
    		if(node.getRight().getData()>=max){
    			if(node.getRight().getLeft()!=null){
    				node.setRight(node.getRight().getLeft());
    			}
    			//node.setRight(null);
    		}
    		if(node.getLeft()!=null)
    			deleteInRange(node.getLeft(),min,max);
    		
    		if(node.getRight()!=null)
    			deleteInRange(node.getRight(),min,max);
    		
    	}
    	
    	public void inorderTraverse(TreeNode node){
    		if(node==null){
    			return;
    		}
    		inorderTraverse(node.getLeft());
    		System.out.print(node.getData()+" ");
    		inorderTraverse(node.getRight());
    	}
    	
    	public void preorderTraverse(TreeNode node){
    		if(node==null){
    			return;
    		}
    		System.out.print(node.getData()+" ");
    		preorderTraverse(node.getLeft());
    		preorderTraverse(node.getRight());
    	}
    	
    	public void postOrder(TreeNode node){
    		TreeNode cur=node;
    		Stack<TreeNode> s=new Stack<TreeNode>();
    		while(true){
    			
    			//System.out.println(cur);
    			
    			
    			
    			
    			if(cur!=null){
    				
    				
    				s.push(cur);
    				cur=cur.getLeft();
    				
    				continue;
    			}
    			
    			
    			if(s.isEmpty()){
    				
    				break;
    			}
    			
    			
    			//System.out.println(s);
    			//TreeNode popNode=(TreeNode)s.pop();
    			
    			
    			cur = s.pop();
    			
    			
    			if(cur.getRight() != null){
    				
    				//System.out.println(cur + "has right");
    				s.push(cur);
    				cur=cur.getRight();
    				continue;
    			
    				
    				
    			}else{
    				//System.out.println(cur +" :Doesnot have right");
    				TreeNode popNode = cur;
    				
    				System.out.print(cur+" ");
    				
    				while(!s.isEmpty() && popNode.getData()==((TreeNode)s.peek()).getRight().getData()){
    					popNode=s.pop();
    					System.out.print(popNode+" ");
    				}
    				
    				//if(cur.getData() != popNode.getData()){
    				//}
    				
    				cur = null;
    				
    			}
    				
    			
    			
    			
    			
    			
    			
    			
    			
    			/*
    			if(cur.getRight()!=null){
    				s.push(cur);
    				cur=cur.getRight();
    				continue;
    			
    			}else{
    				TreeNode popNode=(TreeNode)s.pop();
//    				if(popNode==null){
//    					break;
//    				}
    				System.out.print(popNode.getData()+" ");
    				while(popNode.getData()==((TreeNode)s.peek()).getRight().getData()){
    					popNode=s.pop();
    					System.out.print(popNode.getData()+" ");
    				}
    				if(popNode.getRight()!=null){
    					cur=popNode.getRight();
    				}
    				
    			
    				//cur = s.peek();
    				
    				
    				
    				
    				if(s.isEmpty()){
    					break;
    				}
//    				cur=s.peek().getRight();
//    				}
    				
    				
    				
    				//System.out.println(popNode.getData());
    				
    			}
    	
    				*/
    			
    		}
    		
    	
    		
    	}
    	TreeNode swap1=null;
    	TreeNode swap2=null;
    	TreeNode prev=null;
    	TreeNode middle=null;
    	public void inOrderTraversal(TreeNode node){
    		if(node==null){
    			return;
    		}
    		
    		inOrderTraversal(node.getLeft());
    		prev=node;
    		if(prev.getData()>node.getData()){
    			if(swap1!=null){
    				swap1=prev;
    				middle=node;
    			}else{
    				swap2=node;
    			}
    		}
    		inOrderTraversal(node.getRight());
    		
    		
    	}
    	
    	public void print(int i){
    		if(i==5){
    			return;
    		}
    		
    		print(++i);
    		System.out.println(i);
    	}
    	
    	public int fib(int n){
    		if(n==1){
    			return 0;
    		}
    		if(n==2){
    			return 1;
    		}
    		return fib(n-2)+fib(n-1);
    		//System.out.println();
    		
    	}
    	
    	public void boundryTraversal(TreeNode root){
    		printLeftNodes(root);
    		printLeaves(root);
    		printRightNodes(root.getRight());
    		
    	}
    	
    	public void printRightNodes(TreeNode node){
    		if(node.getRight()==null){
    			return;
    		}
    		printRightNodes(node.getRight());
    		System.out.print(node.getData()+" ");
    		
    		
    	}
    	public void printLeftNodes(TreeNode node){
    		if(node.getLeft()==null){
    			return;
    		}
    		System.out.print(node.getData()+" ");
    		printLeftNodes(node.getLeft());
    	}
    	
    	public void printLeaves(TreeNode node){
    		if(node==null){
    			return;
    		}
    		if(node.getRight()==null && node.getLeft()==null){
    			System.out.print(node.getData()+" ");
    		}
    		printLeaves(node.getLeft());
    		printLeaves(node.getRight());
    	}
    	
    	public TreeNode specialBin(int[] tree,int low,int high){
//    		if(low>high){
//    			System.out.println(low+" "+high);
//    			//System.out.println(high);
//    			return null;
//    		}
//    		
    		//if(low==high){
    		//	return new TreeNode(tree[0]);
    		//}
    		if(low<=high){
    		//else{
    			int max=findMax(tree,low,high);
    			//System.out.println();
    			TreeNode node=new TreeNode(tree[max]);
    			TreeNode left=specialBin(tree,low,max-1);
    			node.setLeft(left);
    			TreeNode right=specialBin(tree,max+1,high);
    			node.setRight(right);
    			return node;
    		}
    		else{
    			return null;
    		}
    		
    	}
    	
    	public int findMax(int[] a,int low,int high){
    		int max=low;
    		int maxValue = a[low];
    		for(i=low;i<=high;i++){
    			
    			if(a[i]>maxValue){
    				maxValue = a[i];
    				max=i;
    			}
    		}
    		return max;
    	}
    	
    	
    	int i=0;
    	public TreeNode specialTree(int pre[],char preLN[]){
//    		if(i==pre.length){
//    			return null;
//    		}
    		
    		TreeNode node=new TreeNode(pre[i]);
    		i=i+1;
    		if(preLN[i-1]=='N'){
    			TreeNode left=specialTree(pre,preLN);
    			node.setLeft(left);
    			TreeNode right=specialTree(pre,preLN);
    			node.setRight(right);
    		}
    		return node;
    	}
    	
    	public int sumLeaftToRoot(TreeNode root){
    		if(root==null){
    			return 0;
    		}
    		int leftsum=sumLeaftToRoot(root.getLeft())+root.getData();
    		int rightsum=sumLeaftToRoot(root.getRight())+root.getData();
    		return Math.max(leftsum, rightsum);
    	}
    	
//    	public TreeNode specialTreeInOrder(){
//    		
//    	}
    	HashMap vertical=new HashMap();
    	public void verticalSum(TreeNode node,int hd){
    		if(node==null){
    			return;
    		}
    		if(vertical.containsKey(hd)){
    			List l=(List) vertical.get(hd);
    			l.add(node.getData());
    			vertical.put(hd, l);
    		}else{
    			List myList=new ArrayList();
    			myList.add(node.getData());
    			vertical.put(hd, myList);
    		}
    		
    		verticalSum(node.getLeft(),hd-1);
    		verticalSum(node.getRight(), hd+1);
    	}
    	
    	public boolean isBST(TreeNode node){
    		if(node==null){
    			return true;
    		}
    		boolean left=isBST(node.getLeft());
    		boolean right=isBST(node.getRight());
    		
    		
    		if(!left||!right){
    			return false;
    		}
    		
    		if(node.getLeft()==null){
    			left=true;
    		}else{
    			if(node.getData()>node.getLeft().getData()){
    				left= true;
    			}else{
    				left= false;
    			}
    		}
    		
    		if(node.getRight()==null){
    			right=true;
    		}else{
    			if(node.getData()<node.getRight().getData()){
    				right= true;
    			}else{
    				right= false;
    			}
    			
    		}
    		System.out.println(node.getData()+" "+left+" "+right);
    		return left && right;
    	}
    	
    	public int sumTree(TreeNode node){
    		if(node==null){
    			return 0;
    		}
    		int leftSum=sumTree(node.getLeft());
    		int rightSum=sumTree(node.getRight());
    		int totalSum=leftSum+rightSum+node.getData();
    		node.setData(leftSum+rightSum);
    		return totalSum;
    	}
    	
    	
    	public static void main(String args[]){
        	TreeNode root=new TreeNode(10);
            //myTree.root=new TreeNode(1);
            root.setLeft(new TreeNode(5));
            root.setRight(new TreeNode(15));
            root.getLeft().setLeft(new TreeNode(2));
            root.getLeft().setRight(new TreeNode(9));
            root.getRight().setLeft(new TreeNode(13));
            root.getRight().setRight(new TreeNode(18));
            root.getRight().getRight().setLeft(new TreeNode(17));
            root.getRight().getRight().setRight(new TreeNode(19));
//        	root.setLeft(new TreeNode(-2));
//            root.setRight(new TreeNode(6));
//            root.getLeft().setLeft(new TreeNode(8));
//            root.getLeft().setRight(new TreeNode(-4));
//            root.getRight().setLeft(new TreeNode(7));
//            root.getRight().setRight(new TreeNode(5));
          //  root.getRight().getRight().setLeft(new TreeNode(20));
           // root.getRight().getRight().setRight(new TreeNode(19));
            YourTree myTree=new YourTree(root);
            //myTree.iterativeInOrder(root);
            //myTree.postOrder(root);
            //myTree.iterativePostOrder(root);
            //myTree.preorderTraverse(root);
           // myTree.dfs(root);
           // System.out.println();
           // myTree.iterativePreOrder(root);
           // System.out.println();
           // myTree.preorderTraverse(root);
           // System.out.println();
            int a[]=new int[11];
            for(int i=1;i<a.length;i++){
    			a[i]=i;
    		}
            myTree.heapify(a);
            
            //myTree.iterativePreOrder(root);
            //myTree.inOrderTraversal(root);
            //myTree.boundryTraversal(root);
            //int pre[] = {10, 30, 20, 5, 15};  
           // char preLN[] = {'N', 'N', 'L', 'L', 'L'};
            //TreeNode newRoot=myTree.specialTree(pre, preLN);
            //myTree.preorderTraverse(newRoot);
            
//            int inorder[]= {1, 5, 10, 40, 30, 15, 20, 28};
//            TreeNode newRoot=myTree.specialBin(inorder,0, inorder.length-1);
//            
//            System.out.println("My root");
//            myTree.inorderTraverse(newRoot);
           // System.out.println(myTree.sumLeaftToRoot(root));
//            myTree.verticalSum(root, 0);
//            Set keys =myTree.vertical.keySet();
//            Iterator<Integer> iter=keys.iterator();
//            while(iter.hasNext()){
//            	int key=iter.next();
//            	List list=(List) myTree.vertical.get(key);
//            	System.out.print(key+"--->");
//            	for(int j=0;j<list.size();j++){
//            		System.out.print(list.get(j)+" ");
//            	}
//            	System.out.println();
//            }
           
//            if(myTree.isBST(root)){
//            	System.out.println("BST");
//            }else{
//            	System.out.println("Not a BST");
//            }
//            
//            myTree.inorderTraverse(root);
            //System.out.println(myTree.sumTree(root));
            //myTree.sumTree(root);
//            myTree.inorderTraverse(root);
//            myTree.inOrderSuc(root);
//            myTree.printInOrderSuc(root);
            
           // myTree.traverse(root);
           // for(int i=3;i>0;i--){
            	//myTree.showEveryLevel(root,4,4,-1);
            //myTree.getSum(root,0,8);
            	//System.out.println();
            //myTree.reverseInOrder(root,0);
            //myTree.levelOrderTraversal(root, 1);
            //System.out.println(myTree.getHeight(root));
            //}
            //System.out.println(myTree.areLeavesSameLevel(root, 1));
            //myTree.findDeepestTreeNode(root, 1);
            //System.out.println(myTree.findDeepestTreeNode(root, 1));
            //myTree.printAncestors(root, 0);
            //myTree.inorderTraverse(root);
            //myTree.deleteInRange(root, 5, 10);
            //System.out.println();
            //myTree.inorderTraverse(root);
            // myTree.showEveryLevel(root, 0);
            
            LinkedList1 list=new LinkedList1();
            Node head=list.appendToList(1);
            list.appendToList(2);
            list.appendToList(3);
            list.appendToList(4);
            list.appendToList(5);
            list.appendToList(6);
            //TreeNode newRoot=myTree.convertListToBinary(head);
            //myTree.inorderTraverse(newRoot);
            //myTree.postOrder(root);
            //myTree.print(1);
        }
    	TreeNode inOrderSuccesor;
    	public void inOrderSuc(TreeNode node){
    		if(node==null){
    			return;
    		}
    		inOrderSuc(node.getLeft());
    		if(inOrderSuccesor!=null){
    			inOrderSuccesor.setInSuc(node);
    		}
    		inOrderSuccesor=node;
    		inOrderSuc(node.getRight());
    		
    	}
    	
    	public void printInOrderSuc(TreeNode node){
    		while(node.getLeft()!=null){
    			node=node.getLeft();
    		}
    		System.out.println();
    		while(node!=null){
    			System.out.print(node.getData()+" ");
    			node=node.getInSuc();
    		}
    	}
    	
    	public void sortedArrayToBST(){
    		
    	}
    	
    	public void iterativeInOrder(TreeNode root){
    		Stack<TreeNode> s=new Stack<TreeNode>();
    		TreeNode node=root;
    		s.push(node);
    		while(!s.isEmpty()){
    			if(node.getLeft()!=null){
    				node=node.getLeft();
    				s.push(node);
    				//System.out.println(node.getData());
    				continue;
    			}
    			TreeNode popNode=s.pop();
    			System.out.print(popNode.getData()+" ");
    			if(popNode.getRight()!=null){
    				node=popNode.getRight();
    				s.push(node);
    			}
    			
    		}
    	}
    	
    	public void iterativePreOrder(TreeNode root){
    		Stack<TreeNode> s=new Stack<TreeNode>();
    		TreeNode node=root;
    		s.push(node);
    		while(!s.isEmpty()){
    			TreeNode popNode=s.pop();
    			System.out.print(popNode.getData()+" ");
    			if(popNode.getRight()!=null){
    				s.push(popNode.getRight());
    			}
    			if(popNode.getLeft()!=null){
    				s.push(popNode.getLeft());
    			}
    			
    		}
    	}
    		
    	public void iterativePostOrder(TreeNode root){
    		Stack<TreeNode> s=new Stack<TreeNode>();
    		TreeNode node=root;
    		s.push(node);
    		while(!s.isEmpty()){
    			
    			//if(s.isEmpty())
    				//break;
    			
    			if(node.getLeft()!=null){
    				node=node.getLeft();
    				s.push(node);
    				//System.out.println(node.getData());
    				continue;
    			}
    			
    			if(s.peek().getRight()!=null){
    				node=s.peek().getRight();
    				s.push(node);
    				continue;
    			}
    			
    			TreeNode popNode=s.pop();
    			System.out.print(popNode.getData()+" ");
    			while(!s.isEmpty() && (popNode==s.peek().getRight()||s.peek().getRight()==null)){
    				popNode=s.pop();
    				System.out.print(popNode.getData()+" ");
    			}
    			if(!s.isEmpty()){
    			node=s.peek().getRight();
    			s.push(node);
    			}
    		}	
    	}
    	
    	public void bfs(TreeNode root){
    		Queue<TreeNode> queue=new ArrayBlockingQueue<TreeNode>(100);
    		queue.add(root);
    		while(!queue.isEmpty()){
    			TreeNode popNode=queue.remove();
    			System.out.print(popNode.getData()+" ");
    			if(popNode.getLeft()!=null)
    			queue.add(popNode.getLeft());
    			if(popNode.getRight()!=null)
    			queue.add(popNode.getRight());
    		}
    	}
    	
    	public void dfs(TreeNode root){
    		Stack<TreeNode> stack=new Stack<TreeNode>();
    		stack.add(root);
    		while(!stack.isEmpty()){
    			TreeNode popNode=stack.pop();
    			System.out.print(popNode.getData()+" ");
    			if(popNode.getRight()!=null)
        			stack.add(popNode.getRight());
    			if(popNode.getLeft()!=null)
    			stack.add(popNode.getLeft());
    			
    		}
    	}
        
    	
    	public void heapify(int a[]){
    		for(i=1;i<a.length;i++){
    			int j=i;
    			while(j>=1){
    				if(a[j]>a[j/2]){
    					swap(a,j,j/2);
    					
    				}else{
    					break;
    				}
    				j=j/2;
    			}
    		}
    		for(int i=1;i<a.length;i++){
    			System.out.print(a[i]+" ");
    		}
    	}
    	
    	public void swap(int a[],int index1,int index2){
    		int temp=a[index1];
    		a[index1]=a[index2];
    		a[index2]=temp;
    		
    	}
}

//class DoubleLinkedNode{
	//private int data;
	//private 
//}

class TreeNode{
    private int data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode inSuc;
    
    public TreeNode getInSuc() {
		return inSuc;
	}

	public void setInSuc(TreeNode inSuc) {
		this.inSuc = inSuc;
	}

	TreeNode(int data){
    	this.data=data;
    	this.left=null;
    	this.right=null;
    }
    
    public TreeNode getLeft(){
    	return this.left;
    }
    
    public TreeNode getRight(){
    	return this.right;
    }
    
    public void setLeft(TreeNode node){
    	this.left=node;
    }
    
    public void setRight(TreeNode node){
    	this.right=node;
    }
    
    public int getData(){
    	return this.data;
    }
    
    public void setData(int data){
    	this.data=data;
    }
    
    public String toString(){
    	
    	return "["+this.data+"]";
    }
}


