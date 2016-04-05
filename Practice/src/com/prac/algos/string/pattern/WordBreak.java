package com.prac.algos.string.pattern;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("i");
		wordDict.add("like");
		wordDict.add("sam");
		wordDict.add("sung");
		wordDict.add("samsung");
		wordDict.add("mobile");
		wordDict.add("ice");
		wordDict.add("cream");
		wordDict.add("man");
		wordDict.add("icecream");
		wordDict.add("man");
		wordDict.add("go");
		wordDict.add("mango");
		wordDict.add("and");
		
		String str = "ilikeicecreamandmango";
		
		List<String> resultList = wordBreak(str, wordDict);
		for(String key : resultList) {
			System.out.println(key);
		}
		
		
		
	}
	private static boolean[] hasWordBreaks(String s, Set<String> wordDict) {
		boolean[] wordBreakDp = new boolean[s.length() + 1];
		wordBreakDp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				if (wordBreakDp[j] && wordDict.contains(word)) {
					wordBreakDp[i] = true;
					break;
				}
			}
		}// end for i
		return wordBreakDp;
	}

	private static List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> words = new LinkedList<>();
		// check whether this s can be breaked or not, which will save a lot of
		// time.
		boolean[] canBeBreaked = hasWordBreaks(s, wordDict);

		if (canBeBreaked[s.length()] == false) {
			return words;
		}

		breakToWords(s, 0, wordDict, canBeBreaked, new StringBuilder(), words);
		return words;
	}

	private static void breakToWords(String string, int start, Set<String> wordDict,
			boolean[] canBeBreaked, StringBuilder aWordString,
			List<String> words) {

		if (start >= string.length()) {
			words.add(aWordString.toString());
			return;
		}

		int nextIdx = start;

		while (nextIdx < string.length()) {
			// first check whether string [0, nextIdx + 1) can be breaked or not
			if (canBeBreaked[nextIdx + 1] == false) {
				nextIdx++;
				continue;
			}
			// even if string [0, nextIdx + 1) can be breaked, we still need to
			// check whether string [start, nextidx + 1) is a valid word or not.
			String word = string.substring(start, nextIdx + 1);
			if (!wordDict.contains(word)) {
				nextIdx++;
				continue;
			}
			// remember original len, when backtracking, it is easy to get to
			// original state
			int len = aWordString.length();

			if (aWordString.length() == 0) {
				aWordString.append(word);
			} else {
				aWordString.append(" " + word);
			}

			breakToWords(string, nextIdx + 1, wordDict, canBeBreaked, aWordString,
					words);

			aWordString.setLength(len);
			nextIdx++;
		}
	}
}
