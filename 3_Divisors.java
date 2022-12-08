class Solution{
    static boolean isPrime(long n){
        //boolean p = false;
        for(int i=2;i<=n/2;i++)
            if(n%i == 0) return false;
        return true;
    }
    static int findDivisor(long num){
        int ans = 0;
        for(long i=2;i<=num;i++){
            if(i*i <= num){
                if(isPrime(i)) ans++;
            }
        }
        return ans;
    }
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<q;i++){
            if(query.get(i) <= 3) res.add(0);
            else{
                int temp = findDivisor(query.get(i));
                res.add(temp);
            }
        }
        return res;
    }
}