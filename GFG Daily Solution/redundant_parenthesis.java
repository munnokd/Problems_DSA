class Solution {
    public static String removeBrackets(String expression) {
        char[] expressionArr = expression.toCharArray();
        int n = expression.length();

        int[] ans = new int[n + 1];
        Arrays.fill(ans, 1);
        int[] lastOperator = new int[n + 1];
        int[] nextOperator = new int[n + 1];

        int l = -1;
        for (int i = 0; i < n; i++) {
            lastOperator[i] = l;
            if (expressionArr[i] == '*' || expressionArr[i] == '+' || expressionArr[i] == '-'
                    || expressionArr[i] == '/') {
                l = expressionArr[i];
            }
        }
        l = -1;
        for (int i = n - 1; i >= 0; i--) {
            nextOperator[i] = l;
            if (expressionArr[i] == '*' || expressionArr[i] == '+' || expressionArr[i] == '-'
                    || expressionArr[i] == '/') {
                l = expressionArr[i];
            }
        }

        Stack<Integer> stack = new Stack<>();
        int[] sign = new int[256];
        int[] mp = new int[256];
        Arrays.fill(sign, -1);
        char[] operators = { '*', '+', '-', '/' };

        for (int p = 0; p < n; p++) {
            for (char x : operators) {
                mp[x] = 0;
                if (x == expressionArr[p]) {
                    sign[x] = p;
                }
            }
            if (expressionArr[p] == '(') {
                stack.push(p);
            } else if (expressionArr[p] == ')') {
                int i = stack.pop();
                int j = p;

                int nxt = nextOperator[j];
                int last = lastOperator[i];

                for (char x : operators) {
                    if (sign[x] >= i) {
                        mp[x] = 1;
                    }
                }
                int ok = 0;

                if (i > 0 && j + 1 < n && expressionArr[i - 1] == '(' && expressionArr[j + 1] == ')') {
                    ok = 1;
                }
                if (mp['+'] == 0 && mp['*'] == 0 && mp['-'] == 0 && mp['/'] == 0) {
                    ok = 1;
                }

                if (last == -1 && nxt == -1) {
                    ok = 1;
                }
                if (last == '/') {
                    // Handle division
                } else if (last == '-' && (mp['+'] == 1 || mp['-'] == 1)) {
                    // Handle subtraction
                } else if (mp['-'] == 0 && mp['+'] == 0) {
                    ok = 1;
                } else {
                    if ((last == -1 || last == '+' || last == '-') && (nxt == -1 || nxt == '+' || nxt == '-')) {
                        ok = 1;
                    }
                }
                if (ok == 1) {
                    ans[i] = 0;
                    ans[j] = 0;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (ans[i] > 0) {
                result.append(expressionArr[i]);
            }
        }
        return result.toString();
    }

}