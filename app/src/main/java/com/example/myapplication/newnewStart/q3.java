package com.example.myapplication.newnewStart;

import java.util.List;

public class q3 {
    /**
     * 寻找s的尾部是否与wordDict中的单词契合
     * if(与wordDict中的k契合){
     * s = dp[s.length-k.length]
     * }else{
     * return false
     * }
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        return isMatch(dp,s,wordDict,s.length());
    }

    // 是否尾部契合
    public boolean isMatch(int[] dp, String s, List<String> wordDict, int index) {
        if(index == 0){
            return true;
        }
        String value = s.substring(0, index);
        if(dp[index - 1] != 0){
            return dp[index - 1] == 1;
        }
        boolean isMatch = false;
        for (String word : wordDict) {
            // 如果已经得到了dp[index-1]是可以匹配的了，就不再匹配了
            // 例如 wordDict = ["dog","s","gs"]，当和"s"匹配成功之后，如果再次和"gs"匹配，那么就会把dp[index -1]和isMatch的值覆盖为false
            if (value.endsWith(word) && dp[index - 1] != 1) {
                isMatch = isMatch(dp, s, wordDict, value.length() - word.length());
                dp[index - 1] = isMatch ? 1 : -1;
            }
        }
        return isMatch;
    }
}
