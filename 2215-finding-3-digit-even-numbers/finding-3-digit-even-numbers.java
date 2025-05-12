class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        for(int i=0;i<=digits.length-1;i++){
            if(digits[i]!=0){
                for(int j=0;j<=digits.length-1;j++){
                    if(j != i){
                        for(int k=0;k<=digits.length-1;k++){
                            if(digits[k]%2 == 0 && k!=i && k!=j){
                                result.add(digits[i]*100 + digits[j]*10 + digits[k]);
                            }
                        }
                    }
                }
            }
        }
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}