class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        stringPart(0,s,res,path);
        return res;
    }
    void stringPart(int ind,String s,List<List<String>> res,List<String> path){
        if(ind==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPal(s,ind,i)){
                path.add(s.substring(ind,i+1));
                stringPart(i+1,s,res,path);
                path.remove(path.size()-1);
            }
        }
        
    }
    boolean isPal(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}