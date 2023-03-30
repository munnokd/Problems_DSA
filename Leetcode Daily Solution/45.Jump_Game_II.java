class Solution {
    public int jump(int[] A) {
    int sc = 0;
    int e = 0;
    int max = 0;
    for(int i=0; i<A.length-1; i++) {
        max = Math.max(max, i+A[i]);
        if( i == e ) {
            sc++;
            e = max;
        } 
    }
    return sc;
}
}