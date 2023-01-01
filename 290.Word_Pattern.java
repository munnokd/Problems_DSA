class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] splited = s.split(" ");
        if (splited.length != pattern.length())
            return false;
        
        Map<Character, String> hs = new HashMap<Character, String>();

        for(int i=0; i<splited.length; i++){
            char c = pattern.charAt(i);
            String str = splited[i];
            if(hs.containsKey(c)){
                if(!hs.get(c).equals(str))
                return false; 
            }
            else{
                if(hs.containsValue(str)) return false; 
                hs.put(c, str);
            } 
        }
        return true;
    }
}