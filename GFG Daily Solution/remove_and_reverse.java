class Solution {
    String removeReverse(String S) {
        // code here
        int[] arr = new int[26];

        for (int i = 0; i < S.length(); i++) {
            arr[S.charAt(i) - 'a']++;
        }

        int n = 0;
        StringBuilder str = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        int i = 0;
        int j = S.length() - 1;
        boolean bool = true;

        while (i <= j) {

            if (bool) {
                if (arr[S.charAt(i) - 'a'] > 1) {
                    arr[S.charAt(i) - 'a']--;
                    bool = !bool;
                    n++;
                } else {
                    str.append(S.charAt(i));
                }
                i++;
            } else {
                if (arr[S.charAt(j) - 'a'] > 1) {
                    arr[S.charAt(j) - 'a']--;
                    bool = !bool;
                    n++;
                } else {
                    str2.append(S.charAt(j));
                }
                j--;
            }

        }

        return n % 2 == 0 ? str.toString() + str2.reverse().toString() : str2.toString() + str.reverse().toString();

    }
}