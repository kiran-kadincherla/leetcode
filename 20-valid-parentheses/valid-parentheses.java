class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> values = new HashMap<>();
        values.put('(',')');
        values.put('{','}');
        values.put('[',']');

        Stack<Character> parenthesis = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(values.containsKey(s.charAt(i))){
                parenthesis.push(values.get(s.charAt(i)));
            } else {
                if(parenthesis.isEmpty() || parenthesis.pop() != s.charAt(i)){
                    return false;
                }
            }
        }



        return parenthesis.isEmpty();

        
    }
}