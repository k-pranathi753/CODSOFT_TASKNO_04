# CODSOFT_TASKNO_04
Java Quiz Application developed as part of my CodSoft internship Task 4. The application presents multiple-choice Java questions with a 10-second timer for each question, validates answers, calculates scores, tracks correct, incorrect and unanswered questions, and displays the final percentage and performance.
# 🧠 Java Quiz Application with Timer

## 📌 Internship Task

This project is developed as **Task 4** of the **CodSoft Java Development Internship**.

## 📖 Project Description

The Java Quiz Application is a console-based quiz program that presents multiple-choice Java programming questions to the user.

Each question has four options (A/B/C/D) and a time limit of 10 seconds to answer. The application validates the user's answer, provides immediate feedback, calculates the score, and keeps track of correct, incorrect, and unanswered questions.

At the end of the quiz, a detailed result is displayed with the total score, percentage, and performance message.

## ✨ Features

- 🧠 Multiple-choice Java programming questions
- 🔤 Four options for each question
- ⏱️ 10-second time limit for each question
- ✅ Validates user answers
- 🎯 Provides immediate feedback
- 🏆 Awards 10 marks for each correct answer
- ❌ Tracks incorrect answers
- ⏰ Tracks unanswered questions when time expires
- 📊 Calculates final score
- 📈 Calculates percentage
- 💬 Displays performance feedback
- 📋 Displays a detailed final result

## 🛠️ Technologies Used

- **Java**
- **Scanner**
- **ExecutorService**
- **Future**
- **TimeUnit**
- **Arrays**
- **Loops**
- **Conditional Statements**
- **Methods**
- **Exception Handling**
- **User Input Validation**

## 📝 Quiz Details

- **Total Questions:** 5
- **Options:** A, B, C, D
- **Time per Question:** 10 seconds
- **Marks per Correct Answer:** 10
- **Maximum Score:** 50

## ❓ Quiz Questions

The application contains questions related to basic Java programming concepts, including:

- Java and Android development
- Java class declaration
- The `main()` method
- Integer data types
- Java statement termination

## ⏱️ Timer Functionality

Each question has a **10-second time limit**.

The application uses Java's concurrency utilities to wait for the user's answer only for the specified time.

If the user does not answer within 10 seconds:

```text
Time is up!
Question marked as unanswered.
```
# 🧮 Scoring System

Each correct answer awards 10 marks.

For example:
| Correct Answers | Score | Percentage |
| --------------: | ----: | ---------: |
|               5 | 50/50 |       100% |
|               4 | 40/50 |        80% |
|               3 | 30/50 |        60% |
|               2 | 20/50 |        40% |
|               1 | 10/50 |        20% |
|               0 |  0/50 |         0% |

# 📊 Performance Levels

The application displays a performance message based on the final percentage:

Percentage	Performance
80% or above	Excellent performance!
60% – 79%	Good performance!
40% – 59%	Keep practicing!
Below 40%	You need more practice.

# 🔄 How the Program Works
The application displays the quiz introduction.
The user presses ENTER to start.
A question and four options are displayed.
The user has 10 seconds to enter an answer.
The answer is validated.
Correct and incorrect answers are recorded.
If the timer expires, the question is marked as unanswered.
The quiz continues until all questions are completed.
The final score and percentage are calculated.
A detailed result and performance message are displayed.
