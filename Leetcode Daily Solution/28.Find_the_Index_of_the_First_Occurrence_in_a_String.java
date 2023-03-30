class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)return -1;
        if(!haystack.contains(needle)) return -1;
        
        int ind=0;
        int k=0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
               ind=i;
                break;
            }
        }
        return ind;
    }
}
