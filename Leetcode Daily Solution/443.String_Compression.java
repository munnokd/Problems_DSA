class Solution {
    public int compress(char[] chars) {
        int i=0,j=0;
        while(i<chars.length){
            int count=1;
            char c=chars[i];
            while(i<chars.length-1 && chars[i]==chars[i+1]){
                i++;
                count++;
            }
            chars[j++] = chars[i++];
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (int k = 0; k < countStr.length(); k++) {
                    chars[j++] = countStr.charAt(k);
                }
            }
        }
        return j;
    }
}