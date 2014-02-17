
public class Strings {
	
	public static void main(String args[]){
		Strings s=new Strings();
		String inp=new String("geeksforgeeks");
		//s.removeAdj(inp);
	    s.findNonRepeat(inp);
	}
	
	public String removeAdj(String inp){
		for(int i=0;i<inp.length()-1;i++){
			if(inp.charAt(i)==inp.charAt(i+1)){
				
			}
		}
		return inp;
	}
	
	public void findNonRepeat(String s){
		CountIndex count[]=new CountIndex[256];
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(count[ch]==null){
			count[ch]=new CountIndex(i);
			}else{
				count[ch].incCount();
			}
		}
		
//		for(int i=0;i<s.length();i++){
//			if(count[s.charAt(i)]==1){
//				System.out.println(s.charAt(i));
//				return;
//			}
//		}
		int min=s.length();
		for(int i=0;i<count.length;i++){
			if(count[i]!=null)
			if(count[i].getCount()==1&&count[i].getPos()<min){
				min=count[i].getPos();
				
			}
		}
		System.out.println(s.charAt(min));
	}
	
	class CountIndex{
		int count;
		int pos;
		
		CountIndex(int pos){
			this.pos=pos;
			this.count=1;
		}
		
		public int getPos() {
			// TODO Auto-generated method stub
			return this.pos;
		}

		public int getCount(){
			return this.count;
		}
		
		public void incCount(){
			this.count++;
		}
		
	}

}
