class Solution {
    public String simplifyPath(String path) {
        Deque<String> dir_stack = new ArrayDeque<>();
        for (String dir : path.split("/")) {
            if (!dir_stack.isEmpty() && dir.equals("..")) {
                dir_stack.removeLast();
            } else if (!dir.equals(".") && !dir.equals("") && !dir.equals("..")) {
                dir_stack.addLast(dir);
            }
        }
        StringBuilder simplified_path = new StringBuilder();
        for (String dir : dir_stack) {
            simplified_path.append("/").append(dir);
        }
        return simplified_path.length() == 0 ? "/" : simplified_path.toString();
    }
}
