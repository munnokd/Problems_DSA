class Solution {
    int countSubstring(String str) {
        // code here
        int n = str.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int upperCount = 0;
            int lowerCount = 0;
            for (int j = i; j < n; j++) {
                char c = str.charAt(j);
                if (c >= 'A' && c <= 'Z') {
                    upperCount++;
                } else {
                    lowerCount++;
                }
                if (upperCount == lowerCount) {
                    count++;
                }
            }
        }
        return count;
    }
}