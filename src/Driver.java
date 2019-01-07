import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static final String[] subjects = {"CALCULUS", "SPANISH", "ENGLISH", "COMPUTER SCIENCE"
            , "CHEMISTRY"};
    private static ArrayList<String> scores = new ArrayList<>();
    private static int totalPoints[] = new int[5];
    private static int points[] = new int[5];

    public static void main(String[] args) throws Exception {
        read();

        execute();

        display();
    }

    private static void read() throws Exception {
        Scanner data = new Scanner(new File("raw.txt"));

        data.nextLine();

        while (data.hasNextLine()) {
            scores.add(data.nextLine());
        }
    }

    private static void execute() {
        for (String score : scores) {
            int subject = Integer.parseInt(score.substring(0, 1));
            String[] point = score.substring(2).split("/");

            points[subject] += Integer.parseInt(point[0]);
            totalPoints[subject] += Integer.parseInt(point[1]);
        }
    }

    private static void display() {
        for (int subject = 0; subject < subjects.length; subject++) {
            System.out.printf("%s: %.2f%% | %d / %d\n", subjects[subject],
                    points[subject] / (double) totalPoints[subject] * 100, points[subject],
                    totalPoints[subject]);
        }
    }
}