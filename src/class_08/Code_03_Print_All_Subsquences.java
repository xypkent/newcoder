package class_08;

import java.util.ArrayList;
import java.util.List;

public class Code_03_Print_All_Subsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);
		char tmp = chs[i];
		chs[i] = 0;//用空格代替字符
		process(chs, i + 1);
		chs[i] = tmp;//直接使用字符
	}
	
//	public static void function(String str) {
//		char[] chs = str.toCharArray();
//		process(chs, 0, new ArrayList<Character>());
//	}
//
//	public static void process(char[] chs, int i, List<Character> res) {
//		if(i == chs.length) {
//			printList(res);
//		}
//		List<Character> resKeep = copyList(res);
//		resKeep.add(chs[i]);
//		process(chs, i+1, resKeep);
//		List<Character> resNoInclude = copyList(res);
//		process(chs, i+1, resNoInclude);
//	}
//
//	public static void printList(List<Character> res) {
//		// ...;
//	}
//
//	public static List<Character> copyList(List<Character> list){
//		return null;
//	}

	//课堂上的版本
	public static void printAllSub(char[] str,int i,String res){
		if (i == str.length){//到达字符串的末尾，已经没有选择了
			System.out.println(res);
			return;
		}
		printAllSub(str,i+1,res+" ");//不要当前字符的路
		printAllSub(str,i+1,res+str[i]);//要当前字符的路
	}

	public static void printAllPermutation(){

	}

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
		printAllSub(test.toCharArray(),0,"");
	}

}




















