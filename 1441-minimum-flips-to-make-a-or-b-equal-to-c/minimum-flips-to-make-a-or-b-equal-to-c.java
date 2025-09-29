class Solution {
    public int minFlips(int a, int b, int c) {
        StringBuilder aString = getBinaryBits(a);
        StringBuilder bString = getBinaryBits(b);
        StringBuilder cString = getBinaryBits(c);
        return getCount(aString, bString, cString);
    }

    private StringBuilder getBinaryBits(int number){
        StringBuilder bits = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<32;i++){
            bits.append("0");
        }
        while(number >= 1){
            temp.append(number%2);
            number/=2;
        }
        bits.replace(32-temp.length(), 32, temp.reverse().toString());
        return bits;
    }

    private int getCount(StringBuilder string1, StringBuilder string2, StringBuilder string3){
        int count = 0;
        for(int i=0;i<32;i++){
            if (((string1.charAt(i) - '0') | (string2.charAt(i) - '0')) != (string3.charAt(i) - '0')) {
                if(string3.charAt(i) - '0' == 0){
                    if (string1.charAt(i) - '0' == 1 && string2.charAt(i) - '0' == 1){
                        string1.replace(i, i+1, String.valueOf(0));
                        count++;
                        string2.replace(i, i+1, String.valueOf(0));
                        count++;
                    } else {
                        if (string1.charAt(i) - '0' == 1){
                            string1.replace(i, i+1, String.valueOf(0));
                            count++;
                        } else {
                            string2.replace(i, i+1, String.valueOf(0));
                            count++;
                        }
                    }
                } else {
                    char newVal = string1.charAt(i) == '0' ? '1' : '0';
                    string1.replace(i, i+1, String.valueOf(newVal));
                    count++;
                }
            }

        }
        return count;
    }
}