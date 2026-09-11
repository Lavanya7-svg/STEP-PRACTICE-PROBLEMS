public class Q4 {
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int score : row) sum += score;
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            if (avg < threshold) {
                result.append("Row ").append(i).append(": Quiet Zone | ");
            } else {
                result.append("Row ").append(i).append(": Buzzing Zone | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
    }
}
