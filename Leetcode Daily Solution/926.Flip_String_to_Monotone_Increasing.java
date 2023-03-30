class Solution {
    public int minFlipsMonoIncr(String s) {
       int ans = 0, noOfFlip = 0;
       
       for(int i =0; i < s.length(); i++){
           if(s.charAt(i) == '0') ans = Math.min(noOfFlip,ans+1);
           else noOfFlip++;
       }
       return ans;
   }
}