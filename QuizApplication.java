import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApplication {

    // Scanner for user input
    static Scanner sc = new Scanner(System.in);

    // Questions
    static String[] questions = {
            "Which language is used to develop Android applications?",
            "Which keyword is used to create a class in Java?",
            "Which method is the starting point of a Java program?",
            "Which data type is used to store whole numbers?",
            "Which symbol is used to end a Java statement?"
    };

    // Options
    static String[][] options = {
            {
                    "A. Java",
                    "B. HTML",
                    "C. CSS",
                    "D. SQL"
            },
            {
                    "A. function",
                    "B. class",
                    "C. object",
                    "D. define"
            },
            {
                    "A. start()",
                    "B. run()",
                    "C. main()",
                    "D. execute()"
            },
            {
                    "A. double",
                    "B. String",
                    "C. int",
                    "D. boolean"
            },
            {
                    "A. :",
                    "B. .",
                    "C. ,",
                    "D. ;"
            }
    };

    // Correct answers
    static char[] correctAnswers = {
            'A',
            'B',
            'C',
            'C',
            'D'
    };

    // Quiz variables
    static int score = 0;
    static int correctAnswersCount = 0;
    static int incorrectAnswersCount = 0;
    static int unansweredCount = 0;

    // Time limit for each question
    static final int TIME_LIMIT = 10;

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("          JAVA QUIZ APPLICATION");
        System.out.println("==========================================");

        System.out.println(
                "Total Questions : " + questions.length
        );

        System.out.println(
                "Time per Question : "
                        + TIME_LIMIT + " seconds"
        );

        System.out.println(
                "Each correct answer gives 10 marks."
        );

        System.out.println("==========================================");

        System.out.print(
                "\nPress ENTER to start the quiz..."
        );

        sc.nextLine();

        // Display questions one by one
        for (int i = 0; i < questions.length; i++) {

            askQuestion(i);
        }

        // Display final result
        displayResult();

        sc.close();
    }

    // Ask one question
    public static void askQuestion(int questionNumber) {

        System.out.println("\n==========================================");

        System.out.println(
                "Question " + (questionNumber + 1)
                        + " of " + questions.length
        );

        System.out.println("==========================================");

        System.out.println(
                questions[questionNumber]
        );

        System.out.println();

        // Display options
        for (String option : options[questionNumber]) {
            System.out.println(option);
        }

        System.out.println();

        System.out.println(
                "You have " + TIME_LIMIT
                        + " seconds to answer."
        );

        System.out.print(
                "Enter your answer (A/B/C/D): "
        );

        // Executor for timed input
        ExecutorService executor =
                Executors.newSingleThreadExecutor();

        Future<String> future =
                executor.submit(() -> sc.nextLine());

        try {

            // Wait only TIME_LIMIT seconds
            String answer =
                    future.get(
                            TIME_LIMIT,
                            TimeUnit.SECONDS
                    );

            // Convert answer to uppercase
            answer = answer.trim().toUpperCase();

            checkAnswer(
                    answer,
                    correctAnswers[questionNumber]
            );

        } catch (TimeoutException e) {

            // Time expired
            future.cancel(true);

            unansweredCount++;

            System.out.println(
                    "\nTime is up!"
            );

            System.out.println(
                    "Question marked as unanswered."
            );

            System.out.println(
                    "Correct answer: "
                            + correctAnswers[questionNumber]
            );

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "Quiz interrupted."
            );

        } catch (ExecutionException e) {

            System.out.println(
                    "Error while reading the answer."
            );

        } finally {

            executor.shutdownNow();
        }
    }

    // Check user's answer
    public static void checkAnswer(
            String answer,
            char correctAnswer) {

        // Validate answer
        if (answer.length() != 1
                || !"ABCD".contains(answer)) {

            System.out.println(
                    "Invalid answer!"
            );

            incorrectAnswersCount++;

            System.out.println(
                    "Correct answer: "
                            + correctAnswer
            );

            return;
        }

        char userAnswer =
                answer.charAt(0);

        // Compare answer
        if (userAnswer == correctAnswer) {

            System.out.println(
                    "Correct Answer!"
            );

            score += 10;
            correctAnswersCount++;

        } else {

            System.out.println(
                    "Incorrect Answer!"
            );

            incorrectAnswersCount++;

            System.out.println(
                    "Correct answer: "
                            + correctAnswer
            );
        }
    }

    // Display final result
    public static void displayResult() {

        int totalQuestions =
                questions.length;

        int maximumScore =
                totalQuestions * 10;

        double percentage =
                ((double) score / maximumScore) * 100;

        System.out.println("\n==========================================");
        System.out.println("              QUIZ RESULT");
        System.out.println("==========================================");

        System.out.println(
                "Total Questions  : " + totalQuestions
        );

        System.out.println(
                "Correct Answers  : "
                        + correctAnswersCount
        );

        System.out.println(
                "Incorrect Answers: "
                        + incorrectAnswersCount
        );

        System.out.println(
                "Unanswered       : "
                        + unansweredCount
        );

        System.out.println(
                "Score            : "
                        + score + "/" + maximumScore
        );

        System.out.printf(
                "Percentage       : %.2f%%%n",
                percentage
        );

        System.out.println("==========================================");

        if (percentage >= 80) {

            System.out.println(
                    "Excellent performance!"
            );

        } else if (percentage >= 60) {

            System.out.println(
                    "Good performance!"
            );

        } else if (percentage >= 40) {

            System.out.println(
                    "Keep practicing!"
            );

        } else {

            System.out.println(
                    "You need more practice."
            );
        }

        System.out.println(
                "Thank you for taking the quiz!"
        );

        System.out.println(
                "=========================================="
        );
    }
}