package HackerRank;

import java.util.Scanner;

/**
 * created by megupta on 5/2/19
 */
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate() );
    }
}

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idNumber);
    }

}

class Student extends Person {
    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the AgeCalculator's first name.
     *   @param lastName - A string denoting the AgeCalculator's last name.
     *   @param id - An integer denoting the AgeCalculator's ID number.
     *   @param scores - An array of integers denoting the AgeCalculator's test scores.
     */
    Student(String firstName, String lastName, int identification, int[] testScores) {
        super(firstName, lastName, identification);
        this.testScores = testScores;
    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    public char calculate() {
        char grade = 'T';
        int totalSubjects = testScores.length;
        int sum = 0;
        if(totalSubjects>1){

            for(int i=0; i<totalSubjects; i++){
                sum+= testScores[i];
            }
            int avg = sum/totalSubjects;
            if(avg>=90){
                grade = 'O';
            }else if( avg>=80){
                grade = 'E';
            }else if(avg >= 70){
                grade = 'A';
            }else if(avg >= 55){
                grade = 'P';
            }else if(avg >=40){
                grade = 'D';
            }else {
                grade = 'T';
            }
        }

        return grade;
    }


}