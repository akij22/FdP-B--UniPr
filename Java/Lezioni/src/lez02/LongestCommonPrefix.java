package lez02;

public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
		
		String finalStr = new String();
		
		boolean mustContinue = true;
		
		
		int k = 0;
		for(int i = 0; i < strs.length; i++) {
			
			mustContinue = true;
			
			for (int j = i + 1; j < strs.length; j++) {
				
				if (strs[i].charAt(k) != strs[j].charAt(k))
					mustContinue = false;
			}
			
			if(mustContinue)
				finalStr = finalStr + strs[i].charAt(k);
			else break;
			
		}
		k++;
		
		return finalStr;
	}

	public static void main(String[] args) {
		
		String[] strs = {"flower", "flow", "flight"};
		
		String finalStr = longestCommonPrefix(strs);
		
		System.out.println(finalStr);
		
		


	}

}
