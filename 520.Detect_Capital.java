class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 0 || word.length() == 1) return true;

        if(Character.isUpperCase(word.charAt(0))){
            boolean first=Character.isUpperCase(word.charAt(1));
            for(int i=2;i<word.length();i++){
                if(Character.isUpperCase(word.charAt(i))!=first) return false;
            }
        }else {
            for(int i=1;i<word.length();i++) 
                if(Character.isUpperCase(word.charAt(i))) return false;
        }
        return true;
    }
}