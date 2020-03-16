// Nicholas Harris
// harris.nicholas1998@gmail.com

/* Write a java program with the following requirements:
- It defines a class (the class implements Comparable) that represents a Time with 3
attributes; hour, minute and second.
- The program asks the user to enter the size of an array and then creates an array of time
objects. The array is filled with a set of time objects. The values (hour, minute, second) of
each object can be created randomly or it is entered by the user.
- The program sorts the array of time objects in an ascending order and then shows the
results. It should also check if all the time objects are distinct and print a proper message
accordingly. */

import java.util.Random;
import java.util.Scanner;
public class Time implements Comparable<Time> {

    private int hour,minute,second;

    public Time(int h, int m, int s){
        this.hour = h;
        this.minute = m;
        this.second = s;
    }

    public int compareHour(Time t){
        int comp = this.hour - t.hour;
        return comp;
    }
    public int compareMin(Time t){
        int comp = this.minute - t.minute;
        return comp;
    }
    public int compareSec(Time t){
        int comp = this.second - t.second;
        return comp;
    }

    public int compareTo(Time t){
        int comp = this.compareHour(t);
        if(comp == 0){
            comp = this.compareMin(t);
        }
        if(comp == 0){
            comp = this.compareSec(t);
        }
        return comp;
    }

    public static void sort(Time[] t){
        for(int i = 1; i < t.length; i++){
            for(int j = 0; j < t.length - 1; j++){
                if(t[j].compareTo(t[j+1]) > 0){
                    Time temp = t[j];
                    t[j] = t[j+1];
                    t[j+1] = temp;
                }
            }
        }
    }

    public static boolean isDistinct(Time[] t){
        for(int i = 0; i < t.length; i++){
            for(int j = i+1; j < t.length; j++){
                if(t[i].compareTo(t[j]) == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void print(Time[] t){
        for(int i = 0; i < t.length; i++){
            System.out.println(t[i].hour + ":" + t[i].minute + ":" + t[i].second);
        }
    }
    public static void main(String[] args){
        int size = 0;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of an array: ");
        size = scanner.nextInt();

        Time time[] = new Time[size];
        for(int i = 0; i < size; i++){
            time[i] = new Time(rand.nextInt(24), rand.nextInt(60), rand.nextInt(60));
        }
        System.out.println("Sorted times: ");
        sort(time);
        print(time);
        if(isDistinct(time)){
            System.out.println("All time objects are distinct");
        }
        else{
            System.out.println("Time objects are not distinct");
        }
    }
}