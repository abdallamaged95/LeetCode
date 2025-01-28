class Solution {
    public boolean isValid(String s) {
         Map<Character, Character> m = new HashMap<>();
        m.put(')', '(');
        m.put(']', '[');
        m.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                if (stack.empty())
                    return false;
                if (stack.pop() != m.get(s.charAt(i)))
                    return false;
            }
            else
                stack.push(s.charAt(i));
        }
        return stack.empty();
    }
}