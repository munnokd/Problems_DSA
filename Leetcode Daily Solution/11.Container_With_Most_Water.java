class Solution {
    public int maxArea(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int maxArea = 0;

        while (start < end) {

            int base = Math.abs(start - end);

            maxArea = Math.max(maxArea, Math.min(arr[start], arr[end]) * base);

            if (arr[start] < arr[end]) {
                start++;
            }

            else {
                end--;
            }
        }
        return maxArea;
    }
}