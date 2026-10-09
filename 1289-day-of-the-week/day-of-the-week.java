class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int[] noOfDaysInMonth = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

        Map<Integer, String> dayMap = new HashMap<>();
        dayMap.put(0,"Friday");
        dayMap.put(1,"Saturday");
        dayMap.put(2,"Sunday");
        dayMap.put(3,"Monday");
        dayMap.put(4,"Tuesday");
        dayMap.put(5,"Wednesday");
        dayMap.put(6,"Thursday");

        int noOfYears = year - 1971;

        int noOfLeapYears = (year - 1) / 4
                          - (year - 1) / 100
                          + (year - 1) / 400
                          - 1970 / 4
                          + 1970 / 100
                          - 1970 / 400;

        int noOfDaysinYear = 0;

        for(int i = 0; i < month - 1; i++){
            noOfDaysinYear += noOfDaysInMonth[i];
        }

        if(month > 2 && year % 4 == 0 &&
           (year % 100 != 0 || year % 400 == 0)){
            noOfDaysinYear++;
        }

        noOfDaysinYear += day - 1;

        int totalDays = noOfYears * 365
                      + noOfLeapYears
                      + noOfDaysinYear;

        return dayMap.get(totalDays % 7);
    }
}