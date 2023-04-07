class Solution {
    static int xmod11(String x) {
        // code here
        int fs = 0, ss = 0;
        for (int i = 0; i < x.length(); i += 2)
            fs += x.charAt(i) - '0';
        for (int i = 1; i < x.length(); i += 2)
            ss += x.charAt(i) - '0';
        return (ss - fs) % 11 >= 0 ? (ss - fs) % 11 : (ss - fs) % 11 + 11;

    }
}