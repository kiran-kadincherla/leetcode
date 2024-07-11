class Solution {
     public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        String result = new String();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                String concatValue = new String();
                char poppedChar = stack.pop();
                while(poppedChar != '('){
                    concatValue += String.valueOf(poppedChar);
                    poppedChar = stack.pop();
                }
                for(int j = 0;j< concatValue.length();j++){
                    stack.push(concatValue.charAt(j));
                }
            } else
                stack.push(s.charAt(i));
        }
        int size = stack.size();
        for(int j = 0;j< size;j++){
            result += stack.pop();
        }
        StringBuilder sb = new StringBuilder(result);
        return sb.reverse().toString();
    }
}