/* GROUP A: Write a program thar can calculate students GPA
 *
 * Program should be able to:
 * 1. Request for class name, grade, and credit
 * 2. Detects when some class name is entered twice (needs to happen)
 * 3. Calculate the GPA for one class (done)
 * 4. Request for more class i.e. name, grade, credit (done)
 * 5. Combine the classes and calculate the total GPA (done)
 *
 * so I need three objects (name, grade, credit)
 * I need buttons to add another name, grade, and credit
 * another button to compute the total gpa and credits
 */

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

class HelperClass {
    public Double gpa;
    public int credits;
    public int points;
    public int status;
    HelperClass(Double gpa, int credits, int points) {
        this.points = points;
        this.credits = credits;
        this.gpa = gpa;
        this.status = 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

class Asker {

    HelperClass helper;

    public HelperClass askForStuff(Scanner scanner, HelperClass helper) {

        int totalPoints = 0;
        int totalCredits = 0;

        boolean moreClasses;
        ArrayList<String> classNames = new ArrayList<>();
        do {
            int credits = 0;
            boolean validCredits;
            validCredits = true;

            boolean duplicate;
            duplicate = false;
            System.out.println("Enter name of class:");
            String nameString = scanner.nextLine();
            if(!classNames.contains(nameString)) {
                classNames.add(nameString);
            }
            else {
                System.out.println("You already added this class!");
                duplicate = true;
            }

            if(duplicate) {
                helper.status = 1;
                return helper;
            }

            System.out.println("Enter number of credits:");
            String creditsString = scanner.nextLine();

            try {
                credits = Integer.parseInt(creditsString);
            }
            catch (NumberFormatException nfe){
                System.out.println("Please enter a valid integer");
                classNames.remove(classNames.size() - 1);
                validCredits = false;
            }
                
            if(validCredits == false) {
                helper.status = 1;
                return helper;
            }

            boolean validGrade;

            Double gradeValue = 0.0;
            String grade;

            validGrade = true;
                
            System.out.println("Enter grade:");
            grade = scanner.nextLine();

            if (grade.equalsIgnoreCase("A+")) {
                gradeValue = 4.5;
            } else if (grade.equalsIgnoreCase("A")) {
                gradeValue = 4.0;
            } else if (grade.equalsIgnoreCase("A-")) {
                gradeValue = 3.75;
            } else if (grade.equalsIgnoreCase("B+")) {
                gradeValue = 3.5;
            } else if (grade.equalsIgnoreCase("B")) {
                gradeValue = 3.0;
            } else if (grade.equalsIgnoreCase("B-")) {
                gradeValue = 2.75;
            } else if (grade.equalsIgnoreCase("C+")) {
                gradeValue = 2.5;
            } else if (grade.equalsIgnoreCase("C")) {
                gradeValue = 2.0;
            } else if (grade.equalsIgnoreCase("C-")) {
                gradeValue = 1.75;
            } else if (grade.equalsIgnoreCase("D")) {
                gradeValue = 1.0;
            } else if (grade.equalsIgnoreCase("F")) {
                gradeValue = 0.0;
            } else {
                System.out.println("You didn't enter a valid grade :(");
                validGrade = false;
                classNames.remove(classNames.size() - 1);
            }
            if(validGrade == false) {
                helper.status = 1;
                return helper;
            }


            Double points = gradeValue * credits;

            totalPoints += points;
            totalCredits += credits;

            System.out.println("Would you like to enter another class? (Y/N)");
            String moreClassesString = scanner.nextLine();

            moreClasses = moreClassesString.equalsIgnoreCase("Y");

        }
        while (moreClasses);

        DecimalFormat df = new DecimalFormat("0.00");

        Double gpa = (double) totalPoints / (double) totalCredits;

        helper.gpa += gpa;
        helper.points += totalPoints;
        helper.credits += totalCredits;


        System.out.println("Credits: " + helper.credits);
        System.out.println("Points: " + helper.points);
        System.out.println("GPA: " + df.format(helper.gpa));

        
        helper.status = 0;
        return helper;
    }
    public Asker(Scanner scanner) {
        this.helper = new HelperClass(0.0, 0, 0);
        HelperClass result = this.askForStuff(scanner, this.helper);
        while(result.status == 1) {
            int status2 = this.askForStuff(scanner, result).status;
            if(status2 == 0) {
                break;
            }
        }

    }
}

class GPACalculator {

    public static void main(String[] args) {
        // Total points / total credits
        // points for a class = grade value * credits
        // A = 4, B = 3....

        Scanner scanner = new Scanner(System.in);
        Asker asker = new Asker(scanner);
        
        scanner.close();
    }
}