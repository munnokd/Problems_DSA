class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        
        for(String str:tokens){
            if("+-/*".contains(str)){
                int val1=st.pop();
                int val2=st.pop();
                int res=calc(val2,val1,str);
                
                st.push(res);
            }else st.push(Integer.parseInt(str));
        }
        return st.pop();
    }
    public int calc(int val1,int val2,String str){
        int res=0;
        if(str.equals("+")) res=val1+val2;
        else if(str.equals("-")) res= val1-val2;
        else if(str.equals("*")) res= val1*val2;
        else if(str.equals("/")) res= val1/val2;
        return res;
    }
}