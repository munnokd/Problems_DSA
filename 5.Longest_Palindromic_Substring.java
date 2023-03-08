class Solution {
    public String longestPalindrome(String s) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            String odd = makePalindrome(s, i, i);
            String even = makePalindrome(s, i, i + 1);

            ans = ans.length() > odd.length() ? ans : odd;
            ans = ans.length() > even.length() ? ans : even;

        }
        return ans;
    }

    public String makePalindrome(String s, int l, int r) {

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
