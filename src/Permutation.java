
public class Permutation {
	
	public static void main(String args[]){
		//boolean isPerm=isPermut("abbbs","asbb");
		//System.out.println(isPerm);
		char[] str={'A','B',' ','c',' ','g','$','$','$','$'};//jasj"};
		System.out.println(compress("aabbccddfaaaa"));
	}
	
	public static boolean isPermut(String str1,String str2){
		boolean charArray[]=new boolean[26];
		for(int i=0;i<str1.length();i++){
			int index=str1.charAt(i) - 'a';
			char ch=' ';
			System.out.println((int)ch);
			System.out.println(index);
			charArray[index]=true;
		}
		for(int j=0;j<str2.length();j++){
			int index=str2.charAt(j) - 'a'; 
			if(charArray[index]==false)
				return false;
		}
		return true;
	}
	
	public static char[] replaceSpace(char[] str,int length){
		int k=0;
		int i=0;
		int spaceCount=0;
		while(k<length){
			if(str[i]==' '){
				spaceCount=spaceCount+1;
				i=i+1;
			}
			else{
			i=i+1;
			}
			k=k+1;
		}
		//for(int j=0;j<)
		return str;
	}
	
	public static String compress(String str){
		int count=1;
		StringBuffer newStr=new StringBuffer();
		for (int i=1;i<str.length();i++){
			if(str.charAt(i)==str.charAt(i-1)){
				count++;
				if(i==str.length()-1){
					newStr.append(str.charAt(i));
					newStr.append(count);
				}
			}else{
				newStr.append(str.charAt(i-1));
				newStr.append(count);
				count=1;
				if(i==str.length()-1){
					newStr.append(str.charAt(i));
					newStr.append(count);
				}
			}
		}
		return newStr.toString();
	}
}
