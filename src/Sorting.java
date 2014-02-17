
public class Sorting {
	
	public static void main(String args[]){
		int a[]={9,8,7,6,5,4,3,2,1};
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		Sorting s=new Sorting();
		s.quickSort(a,0,a.length-1);
		System.out.println();
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
	}
	
	public void printArray(int a[]){
		
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	
	public void mergeSort(int a[],int low,int high){
		if(low<high){
			int mid=(low+high)/2;
			mergeSort(a,low,mid);
			mergeSort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	
	public void merge(int a[],int low,int mid,int high){
		int b[]=new int[1000];
		int i=low;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=high){
			if(a[i]<a[j]){
				b[k]=a[i];
				k++;
				i++;
			}else{
				b[k]=a[j];
				k++;
				j++;
			}
		}
		while(i<=mid){
			b[k]=a[i];
			k++;
			i++;
		}
		while(j<=high){
			b[k]=b[j];
			k++;
			j++;
		}
		i=high;
		k=k-1;
		while(k>=0){
			a[i]=b[k];
			k--;
			i--;
		}
		
	}
	
	public void quickSort(int a[],int low,int high){
		if(low<high){
			int p=partition(a,low,high);
			quickSort(a,low,p-1);
			quickSort(a,p+1,high);
		}
	}

	private int partition(int[] a, int low, int high) {
		// TODO Auto-generated method stub
		int p=low;
		int left=low+1;
		int right=high;
		while(left<right){
		
			
			while(left<=high&&a[left]<a[p]){
				left++;
			}
			while(a[right]>a[p]&&left<right){
				right--;
			}
			//if(left>high){
			//	left--;
			//}
			
			if(left <= right){
				if(a[left] > a[p] && a[right] < a[p]){
					int temp=a[left];
					a[left]=a[right];
					a[right]=temp;
					//right--;
					
				}
			}
		}
		int temp=a[left-1];
		a[left-1]=a[p];
		a[p]=temp;
		return left-1;
	}
	
	public int partition1(int a[],int low, int high){
		int p=low;
		int left=low+1;
		int right=high;
		
		while(left<right){
			System.out.println("left" +left);
			
			System.out.println("right" +right);
			
			if(a[left]<a[p]){
				left++;
			}
			if(a[right]>a[p]){
				right--;
			}
			if(left<high&&right>low)
			if(a[left]>a[p]&&a[right]<a[p]){
				int temp=a[left];
				a[right]=a[left];
				a[left]=temp;
			printArray(a);
			}
			printArray(a);
			System.out.println();
		}
		int temp=a[left-1];
		a[left-1]=a[p];
		a[p]=temp;
		return left-1;
	}
	
	
	
	
}
