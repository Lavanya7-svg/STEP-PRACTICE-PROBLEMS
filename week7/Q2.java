class Scorecard {
    private boolean[] results;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        recordedCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedCount < results.length) {
            results[recordedCount++] = correct;
        } else {
            System.out.println("Cannot record more answers than total questions.");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) score++;
        }
        return score;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Final Score: " + sc.getScore()); // 3
    }
}
