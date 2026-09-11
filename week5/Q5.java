import java.util.Arrays;

class Q5 implements Comparable<Q5> {
    String name;
    double cgpa;
    int codingScore;

    public Q5(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Overloaded eligibility checks
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5; // threshold for direct CGPA
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 7.0 && codingScore >= 60; // borderline CGPA + good coding score
    }

    // Composite score for ranking
    double compositeScore() {
        return cgpa * 10 + codingScore; // weighting scheme
    }

    @Override
    public int compareTo(Q5 other) {
        return Double.compare(other.compositeScore(), this.compositeScore()); // descending
    }

    static String shortlistAndRank(Q5[] candidates) {
        Q5[] shortlisted = Arrays.stream(candidates)
                .filter(c -> isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore))
                .toArray(Q5[]::new);

        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append((i + 1)).append(". ")
              .append(shortlisted[i].name)
              .append(" (").append(shortlisted[i].compositeScore()).append(")");
            if (i < shortlisted.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q5[] candidates = {
            new Q5("Aisha", 8.2, 40),
            new Q5("Rohit", 6.8, 65),
            new Q5("Meena", 6.0, 90),
            new Q5("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
