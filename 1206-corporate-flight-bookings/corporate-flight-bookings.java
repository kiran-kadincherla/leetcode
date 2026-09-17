class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] preSumArr = new int[n+1];
        int[] result = new int[n];
        int differentialSum = 0;

        for(int i=0;i<n+1;i++){
            preSumArr[i]=0;
        }
        //System.out.print("len"+preSumArr.length + " .. "+bookings.length+1);
        for(int i=0;i<bookings.length;i++){
            int[] bookingArr = bookings[i];
            preSumArr[bookingArr[0]-1] += bookingArr[2];
            preSumArr[bookingArr[1]] -= bookingArr[2];
        }

        for(int i=0;i<n;i++){
            differentialSum+=preSumArr[i];
            result[i]=differentialSum;
        }

        return result;

        
    }
}