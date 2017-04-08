// AvgGPA.java: Reads from standard input a list of letter grades and computes
// and prints the average GPA (the average of the numbers corresponding to
// the grades).

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AvgGPA {
    public static void main(String[] args) {
        String[] letter = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
        double[] grade = { 4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00};
        ArrayST<String, Double> grades = new ArrayST<String, Double>();
        for (int i = 0; i < letter.length; i++) {
            grades.put(letter[i], grade[i]);
        }
        double sum = 0.0;
        int counter = 0; 
        while(!StdIn.isEmpty()) {
            String g = StdIn.readString();
            double number = grades.get(g);
            sum += number;
            counter++; }
        double gpa = sum / counter;
        StdOut.println(gpa);
    }
}

