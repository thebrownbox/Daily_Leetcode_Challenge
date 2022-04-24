public class _1854_Maximum_Population_Year {
    //level 1
    public int maximumPopulation(int[][] personArr) {
        
        int[] danSo = new int[2051];

        for (int[] person : personArr) {
            int birthYear = person[0];
            int deathYear = person[1];
            for (int year = birthYear; year < deathYear; year++) {
                danSo[year]++;
            }
        }

        int maxCount = 0;
        int maxYear = 0;
        for (int year = 1950; year <= 2050; year++) {
            if(danSo[year] > maxCount){
                maxCount = danSo[year];
                maxYear = year;
            }
        }

        return maxYear;
    }

    //level 2: 
}
