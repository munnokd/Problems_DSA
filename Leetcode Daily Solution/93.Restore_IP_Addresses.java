class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String>al=new ArrayList<>();
        if(s.length()>12) return al;
        help(0,s,al,new ArrayList<>());
        return al;
    }
    public static void help(int ind,String s,List<String>al,ArrayList<String>ds){
        if(ind==s.length()&&ds.size()==4){
            al.add(String.join(".",ds));
            return;
        }
        for(int i=1;i<=3;i++){
            if(ind+i>s.length()) return;
            String add=s.substring(ind,ind+i);
            if(!(add.charAt(0)=='0'&&add.length()>1||Integer.parseInt(add)>255)){
                ds.add(add);
                help(ind+i,s,al,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
}