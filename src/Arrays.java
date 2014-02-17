
public class Arrays {
	
	public void countTriangles(int arr[]){
//		int i=0,j=1;
//		int k=j+1;
//		int numTriangles=0;
//		while(i<arr.length-2){
//			for(;k<arr.length;k++){
//				if(arr[i]+arr[j]>arr[k]){
//					k++;
//					continue;
//				}
//				numTriangles=numTriangles+(k-j-1);
//				j=j+1;
//			}
//			if(k==arr.length){
//			i=i+1;
//			j=i+1;
//			k=j+1;
//			}
//		}
		int count=0;
		for(int i=0;i<arr.length-2;i++){
			int k=i+2;
			for(int j=i+1;j<arr.length;j++){
				while(k<arr.length && arr[i]+arr[j]>arr[k]){
					k++;
				}
				count+=k-j-1;
			}
		}
		System.out.println(count);
		
		
	}
	
	public void majorityElement(int arr[]){
		int count=1;
		int majIndex=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==arr[majIndex]){
				count++;
			}else{
				count--;
			}
			if(count==0){
				majIndex=i;
				count=1;
			}
		}
		count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==arr[majIndex]){
				count++;
			}
		}
		if(count>(arr.length/2)){
			System.out.println(arr[majIndex]);
		}else{
			System.out.println("No such element");
		}
	}
	
	public void getOdd(int arr[]){
		int res=0;
		for(int i=0;i<arr.length;i++){
			res=res ^ arr[i];
			
		}
		System.out.println(res);
	}
	
	public void sumToK(int arr[],int k){
		int sum=0;
		int start=0;
		for(int i=0;i<arr.length;i++){
			
			sum+=arr[i];
			if(sum<k){
				continue;
			}else if(sum==k){
				System.out.println(start+" "+i);
				return;
			}else{
				//sum=sum+arr[i];
				while(sum>=k){
					if(sum==k){
						System.out.println(start+" "+i);
						return;
					}
					sum=sum-arr[start];
					start=start+1;
				}
			}
		}
	}	
	
	public void largestContigSubArray(int arr[]){
		int sum=0;
		int largestSum=0;
		for(int i=0;i<arr.length;i++){
			sum=sum+arr[i];
			if(sum<0){
				sum=0;
			}
			if(sum>largestSum){
				largestSum=sum;
			}
		}
		System.out.println(largestSum);
		
	}
	
	public int binSearchPivot(int arr[],int low, int high){
		if(low<high){
			System.out.println("low="+low+" "+"high="+high);
			int mid=(low+high)/2;
			if(mid+1!=arr.length && arr[mid]>arr[mid+1]){
				
				return mid;
			}
				
			else if(arr[mid]>arr[high-1]){
				return binSearchPivot(arr,mid+1,high);
				//if(pivot!=-1){
				//	return pivot;
				//}
			}
			else{
				return binSearchPivot(arr,low,mid);
				//if(pivot!=-1){
				//	return pivot;
				//}
			}
		}
		return -1;
	}
	
	public boolean findLeaders(int arr[],int i){
		if(i==arr.length-1){
			System.out.println(arr[i]);
			return true;
		}
		boolean isLeader=findLeaders(arr,i+1) && arr[i]>arr[i+1];
		return isLeader;
	}
	
	public void shiftWithReversal(int a[],int d){
		for(int i=0,j=d-1;i<j;i++,j--){
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		for(int i=d,j=a.length-1;i<j;i++,j--){
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		for(int i=0,j=a.length-1;i<j;i++,j--){
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		for (int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
	}
	
	public void reverseRecursive(int a[],int low,int high){
		if(low>high){
			return;
		}
		int temp=a[low];
		a[low]=a[high];
		a[high]=temp;
		reverseRecursive(a, ++low,--high);
	}
	
	public void shiftWithRecursiveReverse(int a[],int d){
		reverseRecursive(a,0,d-1);
		reverseRecursive(a, d, a.length-1);
		reverseRecursive(a, 0, a.length-1);
	}
	
		
	
	public static void main(String args[]){
		Arrays a=new Arrays();
		int arr[]={1,2,3,4,5,6,7};
		//a.countTriangles(arr);
		//a.majorityElement(arr);
		//a.getOdd(arr);
		//a.sumToK(arr, 53);
		//a.largestContigSubArray(arr);
		//System.out.println(arr[a.binSearchPivot(arr, 0, arr.length)]);
		//a.shiftWithReversal(arr, 3);
		a.shiftWithRecursiveReverse(arr, 3);
		for (int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}

}
