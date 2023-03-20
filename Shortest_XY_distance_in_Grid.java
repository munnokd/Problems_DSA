class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,int M) {
        // code here
        ArrayList<List<Integer>> xpl=new ArrayList<>(); 
        ArrayList<List<Integer>> ypl=new ArrayList<>(); 
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid.get(i).get(j) == 'X'){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    xpl.add(list);
                }else if(grid.get(i).get(j) == 'Y'){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ypl.add(list);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<xpl.size();i++){
            List<Integer> r=xpl.get(i);
            int ror=r.get(0);
            int roc=r.get(1);
            for(int j=0;j<ypl.size();j++){
                List<Integer> c=ypl.get(j);
                int cor=c.get(0);
                int coc=c.get(1);
                
                int dif=Math.abs(ror-cor)+Math.abs(roc-coc);
                if(dif<ans){
                    ans=dif;
                }
            }
        }
        return ans;
    }}