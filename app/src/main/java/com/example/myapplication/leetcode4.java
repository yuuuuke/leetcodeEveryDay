package com.example.myapplication;

public class leetcode4 {

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        char[] charList = s.toCharArray();
        String longestString = charList[0] + "";
        for (int i = 0; i < charList.length; i++) {
            start = end = i;
            start--;
            end++;
            boolean isStop = false;
            while (!isStop) {
                if (start >= 0 && end <= charList.length - 1) {
                    if (charList[start] == charList[end]) {
                        //头跟屁股一样，是回文
                        if (start - 1 < 0 || end + 1 >= charList.length) {
                            if (end - start + 1 > longestString.length()) {
                                //比最长的长，替换一下
                                longestString = s.substring(start, end + 1);
                            }
                            isStop = true;
                        } else {
                            start--;
                            end++;
                        }
                    } else {
                        //头跟屁股不一样，那么，就到此为止吧,此时start 和 end 都已经偏移了， 所以要 +1 -2 = -1
                        if (end - start - 1 > longestString.length()) {
                            //比最长的长，替换一下
                            longestString = s.substring(start + 1, end);
                        }
                        isStop = true;
                    }
                } else {
                    isStop = true;
                }
            }

            try {
                //要计算一下两个的
                if (charList[i] == charList[i - 1]) {
                    if (longestString.length() <= 2) {
                        longestString = charList[i] + "" + charList[i - 1];
                    }
                    start = i - 1;
                    end = i;
                } else if (charList[i] == charList[i + 1]) {
                    if (longestString.length() <= 2) {
                        longestString = charList[i] + "" + charList[i + 1];
                    }
                    start = i;
                    end = i + 1;
                }else{
                    continue;
                }

                start--;
                end++;
                isStop = false;
                while (!isStop) {
                    if (start >= 0 && end <= charList.length - 1) {
                        if (charList[start] == charList[end]) {
                            //头跟屁股一样，是回文
                            if (start - 1 < 0 || end + 1 >= charList.length) {
                                if (end - start + 1 > longestString.length()) {
                                    //比最长的长，替换一下
                                    longestString = s.substring(start, end + 1);
                                }
                                isStop = true;
                            } else {
                                start--;
                                end++;
                            }
                        } else {
                            //头跟屁股不一样，那么，就到此为止吧,此时start 和 end 都已经偏移了， 所以要 +1 -2 = -1
                            if (end - start - 1 > longestString.length()) {
                                //比最长的长，替换一下
                                longestString = s.substring(start + 1, end);
                            }
                            isStop = true;
                        }
                    } else {
                        isStop = true;
                    }
                }
            } catch (Exception e) {

            }
        }
        return longestString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
