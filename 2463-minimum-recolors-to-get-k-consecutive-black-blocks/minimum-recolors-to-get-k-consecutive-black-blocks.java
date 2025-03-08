class Solution {
    public int minimumRecolors(String blocks, int k) {

        int minNoOfReplacements = Integer.MAX_VALUE;

        for(int i=0;i<blocks.length();i++){
            int tempReplacements = 0;
            int strLength = 0;
            if(blocks.length()-i < k){
                return minNoOfReplacements;
            }
            if(blocks.charAt(i) == 'W'){
                tempReplacements++;
            }
            strLength++;
            if(k == strLength) {
                minNoOfReplacements = Math.min(tempReplacements, minNoOfReplacements);

            } else {
                for(int j=i+1;j<blocks.length();j++){
                    if(blocks.charAt(j) == 'W'){
                        tempReplacements++;
                    }
                    strLength++;
                    if(k == strLength){
                        minNoOfReplacements = Math.min(tempReplacements, minNoOfReplacements);
                        break;
                    }
                }
            }

        }
        return minNoOfReplacements;
    }
}