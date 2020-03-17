// Nicholas Harris
// 4011193

/* 3.1.1 Write a client that creates a symbol table mapping letter grades to numerical scores, as in
the table below, then reads from standard input a list of letter grades and computes and prints the
GPA (the average of the numbers corresponding to the grades). */

import java.util.Scanner;
import java.lang.ST;
public class GpaCalc{
    public static void main(String[] args){
        ST<String, Double> grades = new ST<String, Double>();
        Scanner input = new Scanner(System.in);
        int numGrades = 0;
        double average = 0;

        grades.put("A+", 4.33);
        grades.put("A", 4.00);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B", 3.00);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C", 2.00);
        grades.put("C-", 1.67);
        grades.put("D", 1.00);
        grades.put("F", 0.00);

        while(numGrades < 10){
            String letterGrade = input.nextLine();
            double gpa = grades.get(letterGrade);
            average += gpa;
            numGrades++;
        }
        average = average/numGrades;
        System.out.println("Final GPA: " + average);
    }
}