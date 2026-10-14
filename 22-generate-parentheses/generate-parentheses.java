class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        validParenthesis(n, new StringBuilder(), 0, 0);
        return result;
    }

    private void validParenthesis(int n, StringBuilder parenthesis, int openCount, int closeCount){
        
        if(openCount == n && closeCount == n){
            result.add(parenthesis.toString());
            return;
        }
        if (openCount < n) {
            parenthesis.append('(');
            validParenthesis(n, parenthesis, openCount + 1, closeCount);
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }

        if (closeCount < openCount) {
            parenthesis.append(')');
            validParenthesis(n, parenthesis, openCount, closeCount + 1);
            parenthesis.deleteCharAt(parenthesis.length()-1);
        }

    }
}