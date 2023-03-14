class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res=0;
        for(int i=0;i<rocks.length;i++) rocks[i]=capacity[i]-rocks[i];
        Arrays.sort(rocks);
        for(int i=0;i<rocks.length && (rocks[i]-additionalRocks)<=0; i++){
            res++;
            additionalRocks-=rocks[i];
        }
        return res;
    }
}