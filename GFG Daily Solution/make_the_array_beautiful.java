
class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || (stack.peek() >= 0 && arr[i] >= 0) || (stack.peek() < 0 && arr[i] < 0))
                stack.push(arr[i]);
            else
                stack.pop();
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty())
            list.add(stack.pop());
        Collections.reverse(list);
        return list;
    }
}
