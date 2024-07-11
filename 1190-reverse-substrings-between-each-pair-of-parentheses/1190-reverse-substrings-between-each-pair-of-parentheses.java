public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
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
        return stack.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }