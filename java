/****************************************************************
 * Exercise 1: Write a program to swap two numbers in Java
 ****************************************************************/
public class SwapNumbers {
    public static void main(String[] args) {
        int a = 10, b = 20;
        
        System.out.println("Before swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        // Swap using a temporary variable
        int temp = a;
        a = b;
        b = temp;
        
        System.out.println("\nAfter swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

/****************************************************************
 * Exercise 2: Write a program to print all the elements of Fibonacci series
 ****************************************************************/
public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to print
        
        System.out.println("First " + n + " Fibonacci numbers:");
        
        int first = 0, second = 1;
        
        System.out.print(first + " " + second + " ");
        
        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
    }
}

/****************************************************************
 * Exercise 3: Check if a given number is palindrome or not
 ****************************************************************/
public class PalindromeCheck {
    public static void main(String[] args) {
        int number = 12321;
        int originalNumber = number;
        int reversed = 0;
        
        while (number > 0) {
            int remainder = number % 10;
            reversed = reversed * 10 + remainder;
            number = number / 10;
        }
        
        if (originalNumber == reversed) {
            System.out.println(originalNumber + " is a palindrome.");
        } else {
            System.out.println(originalNumber + " is not a palindrome.");
        }
    }
}

/****************************************************************
 * Exercise 4: Write a program to reverse a string
 ****************************************************************/
public class ReverseString {
    public static void main(String[] args) {
        String original = "Hello World";
        String reversed = "";
        
        // Manual reversal
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }
        
        System.out.println("Original string: " + original);
        System.out.println("Reversed string: " + reversed);
    }
}

/****************************************************************
 * Exercise 5: Write a program to create a class Student2 along with two method 
 * getData(), printData() to get the value through argument and display the 
 * data in printData()
 ****************************************************************/
// Save this in StudentDemo.java, not Student2.java
class Student2 {
    private String name;
    private int id;
    
    // Method to get data through arguments
    public void getData(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    // Method to display the data
    public void printData() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        // Create objects s1, s2
        Student2 s1 = new Student2();
        Student2 s2 = new Student2();
        
        // Set data for s1
        s1.getData("John", 1);
        
        // Set data for s2
        s2.getData("Alice", 2);
        
        // Display data
        System.out.println("Student 1 details:");
        s1.printData();
        
        System.out.println("\nStudent 2 details:");
        s2.printData();
    }
}

/****************************************************************
 * Exercise 6: Write a program in java to generate an abstract class A, 
 * also class B inherits the class A, generate the object for class B 
 * and display the text "call me from B"
 ****************************************************************/
// Abstract class A
abstract class A {
    // Abstract method
    abstract void callMe();
}

// Class B inheriting from abstract class A
class B extends A {
    // Implementation of abstract method
    @Override
    void callMe() {
        System.out.println("call me from B");
    }
}

// Main class
public class AbstractClassDemo {
    public static void main(String[] args) {
        // Create object of class B
        B b = new B();
        
        // Call method
        b.callMe();
    }
}

/****************************************************************
 * Exercise 7: Write a java program in which you will declare an abstract 
 * class Vehicle. Inherit two classes car and truck using the method engine 
 * in both display "car has good engine" and "truck has bad engine"
 ****************************************************************/
// Abstract Vehicle class
abstract class Vehicle {
    // Abstract method
    abstract void engine();
}

// Car class inheriting from Vehicle
class Car extends Vehicle {
    @Override
    void engine() {
        System.out.println("car has good engine");
    }
}

// Truck class inheriting from Vehicle
class Truck extends Vehicle {
    @Override
    void engine() {
        System.out.println("truck has bad engine");
    }
}

// Main class
public class VehicleDemo {
    public static void main(String[] args) {
        // Create car object
        Car car = new Car();
        
        // Create truck object
        Truck truck = new Truck();
        
        // Display engine status
        car.engine();
        truck.engine();
    }
}

/****************************************************************
 * Exercise 8: Write a program in java to enter the number through 
 * command line argument if first and second number is not entered 
 * it will generate the exception. Also generate the arithmetic exception.
 ****************************************************************/
public class CommandLineArgs {
    public static void main(String[] args) {
        try {
            // Check if two arguments are provided
            if (args.length < 2) {
                throw new IllegalArgumentException("Please provide two numbers as command line arguments");
            }
            
            // Parse arguments to integers
            int firstNumber = Integer.parseInt(args[0]);
            int secondNumber = Integer.parseInt(args[1]);
            
            // Potential arithmetic exception
            int result = firstNumber / secondNumber;
            
            System.out.println("Result of division: " + result);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        }
    }
}

/****************************************************************
 * Exercise 9: Write a java program to make thread sleep for 5 sec 
 * and change the name of thread
 ****************************************************************/
public class ThreadDemo {
    public static void main(String[] args) {
        // Create a new thread
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    // Get current thread
                    Thread currentThread = Thread.currentThread();
                    
                    System.out.println("Initial thread name: " + currentThread.getName());
                    
                    // Sleep for 5 seconds
                    System.out.println("Thread sleeping for 5 seconds...");
                    Thread.sleep(5000);
                    
                    // Change thread name
                    currentThread.setName("RenamedThread");
                    System.out.println("Thread name changed to: " + currentThread.getName());
                    
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        });
        
        // Set initial name
        thread.setName("OriginalThread");
        
        // Start thread
        thread.start();
    }
}

/****************************************************************
 * Exercise 10: Write a java program to read and append a file 
 * and display the content on screen
 ****************************************************************/
import java.io.*;

public class FileOperations {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        
        try {
            // Create file if it doesn't exist and write initial content
            File file = new File(fileName);
            if (!file.exists()) {
                FileWriter writer = new FileWriter(file);
                writer.write("Initial content of the file.");
                writer.close();
                System.out.println("File created with initial content.");
            }
            
            // Read current file content
            System.out.println("\nCurrent file content:");
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            
            // Append to file
            FileWriter appendWriter = new FileWriter(fileName, true);
            appendWriter.write("\nThis text is appended to the file.");
            appendWriter.close();
            System.out.println("\nContent appended to file.");
            
            // Read file after appending
            System.out.println("\nFile content after appending:");
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            
        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }
}

/****************************************************************
 * Exercise 11: Write a program to demonstrate the use of AWT component 
 * like label, textfield, textarea, button, checkbox, radiobutton and etc.
 ****************************************************************/
import java.awt.*;
import java.awt.event.*;

public class AWTComponentsDemo extends Frame {
    public AWTComponentsDemo() {
        // Set layout
        setLayout(new FlowLayout());
        
        // Create components
        Label label = new Label("Name:");
        TextField textField = new TextField(20);
        TextArea textArea = new TextArea("Comments", 5, 20);
        Button button = new Button("Submit");
        Checkbox checkbox = new Checkbox("Agree to terms");
        
        // Radio buttons
        CheckboxGroup radioGroup = new CheckboxGroup();
        Checkbox radio1 = new Checkbox("Male", radioGroup, false);
        Checkbox radio2 = new Checkbox("Female", radioGroup, false);
        
        // Add components to frame
        add(label);
        add(textField);
        add(textArea);
        add(checkbox);
        add(radio1);
        add(radio2);
        add(button);
        
        // Add event listener to button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Name: " + textField.getText());
                System.out.println("Comments: " + textArea.getText());
                System.out.println("Agreed: " + checkbox.getState());
                System.out.println("Gender: " + radioGroup.getSelectedCheckbox().getLabel());
            }
        });
        
        // Set frame properties
        setTitle("AWT Components Demo");
        setSize(300, 300);
        setVisible(true);
        
        // Add window closing event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {
        new AWTComponentsDemo();
    }
}

/****************************************************************
 * Exercise 12: Write a program to demonstrate different types of layout in AWT
 ****************************************************************/
import java.awt.*;
import java.awt.event.*;

public class AWTLayoutsDemo {
    public static void main(String[] args) {
        // Create a tabbed frame to demonstrate different layouts
        Frame mainFrame = new Frame("AWT Layouts Demo");
        mainFrame.setSize(500, 400);
        mainFrame.setLayout(new GridLayout(2, 2));
        
        // Flow Layout Panel
        Panel flowPanel = new Panel();
        flowPanel.setLayout(new FlowLayout());
        Label flowLabel = new Label("Flow Layout");
        flowPanel.add(flowLabel);
        for (int i = 1; i <= 5; i++) {
            flowPanel.add(new Button("Button " + i));
        }
        
        // Border Layout Panel
        Panel borderPanel = new Panel();
        borderPanel.setLayout(new BorderLayout(5, 5));
        borderPanel.add(new Button("North"), BorderLayout.NORTH);
        borderPanel.add(new Button("South"), BorderLayout.SOUTH);
        borderPanel.add(new Button("East"), BorderLayout.EAST);
        borderPanel.add(new Button("West"), BorderLayout.WEST);
        borderPanel.add(new Button("Center"), BorderLayout.CENTER);
        
        // Grid Layout Panel
        Panel gridPanel = new Panel();
        gridPanel.setLayout(new GridLayout(2, 3, 5, 5));
        for (int i = 1; i <= 6; i++) {
            gridPanel.add(new Button("B" + i));
        }
        
        // Card Layout Panel
        Panel cardPanel = new Panel();
        final CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        
        Panel card1 = new Panel();
        card1.add(new Label("Card 1"));
        card1.add(new Button("Card 1 Button"));
        
        Panel card2 = new Panel();
        card2.add(new Label("Card 2"));
        card2.add(new TextField(10));
        
        cardPanel.add(card1, "First");
        cardPanel.add(card2, "Second");
        
        // Button to switch cards
        Button switchButton = new Button("Switch Card");
        switchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });
        card1.add(switchButton);
        card2.add(new Button("Back") {
            {
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.previous(cardPanel);
                    }
                });
            }
        });
        
        // Add panels to main frame
        mainFrame.add(flowPanel);
        mainFrame.add(borderPanel);
        mainFrame.add(gridPanel);
        mainFrame.add(cardPanel);
        
        // Add window closing event
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mainFrame.dispose();
                System.exit(0);
            }
        });
        
        mainFrame.setVisible(true);
    }
}


// Problem 1: Write a Java program to display characters from A to Z

public class DisplayAtoZ {
    public static void main(String[] args) {
        System.out.println("Characters from A to Z:");
        
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
    }
}

// Problem 2: Write a Java program to display all the vowels from the given string

public class DisplayVowels {
    public static void main(String[] args) {
        String input = "This is a sample string to extract vowels from";
        System.out.println("Original string: " + input);
        System.out.print("Vowels: ");
        
        for (int i = 0; i < input.length(); i++) {
            char c = Character.toLowerCase(input.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                System.out.print(c + " ");
            }
        }
    }
}

// Problem 3: Write a Java program to check whether given number is Armstrong or not (use static keyword)

public class ArmstrongNumber {
    // Static method to check if a number is Armstrong
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();
        
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        
        return sum == originalNumber;
    }
    
    public static void main(String[] args) {
        int numToCheck = 153; // Example: 153 is an Armstrong number (1^3 + 5^3 + 3^3 = 153)
        
        if (isArmstrong(numToCheck)) {
            System.out.println(numToCheck + " is an Armstrong number");
        } else {
            System.out.println(numToCheck + " is not an Armstrong number");
        }
    }
}

// Problem 4: Write a Java program to display alternate characters from a given string

public class AlternateCharacters {
    public static void main(String[] args) {
        String input = "This is a sample string";
        System.out.println("Original string: " + input);
        System.out.print("Alternate characters: ");
        
        for (int i = 0; i < input.length(); i += 2) {
            System.out.print(input.charAt(i));
        }
    }
}

// Problem 5: Write a Java program for the pattern
/*
5
45
345
2345
12345
*/

public class PatternPrinting {
    public static void main(String[] args) {
        int rows = 5;
        
        for (int i = rows; i >= 1; i--) {
            for (int j = i; j <= rows; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

// Problem 6: Define an interface Shape with abstract method area. Write a Java program to calculate area of circle and sphere

interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Sphere implements Shape {
    private double radius;
    
    public Sphere(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        // Surface area of a sphere
        return 4 * Math.PI * radius * radius;
    }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Sphere sphere = new Sphere(5.0);
        
        System.out.println("Area of circle with radius 5.0: " + circle.area());
        System.out.println("Surface area of sphere with radius 5.0: " + sphere.area());
    }
}
// Problem 7: Write a Java program to validate "PAN and Mobile Number". If it is invalid then throw user-define exception "Invalid data", otherwise display it.

import java.util.Scanner;

// Custom exception class
class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

public class ValidateData {
    // Validate PAN (Assuming PAN format is ABCDE1234F - 5 letters, 4 digits, 1 letter)
    public static boolean validatePAN(String pan) {
        if (pan.length() != 10) {
            return false;
        }
        
        // Check first 5 characters are letters
        for (int i = 0; i < 5; i++) {
            if (!Character.isLetter(pan.charAt(i))) {
                return false;
            }
        }
        
        // Check middle 4 characters are digits
        for (int i = 5; i < 9; i++) {
            if (!Character.isDigit(pan.charAt(i))) {
                return false;
            }
        }
        
        // Check last character is letter
        return Character.isLetter(pan.charAt(9));
    }
    
    // Validate Mobile (Assuming 10 digits, may start with optional +91)
    public static boolean validateMobile(String mobile) {
        if (mobile.startsWith("+91")) {
            mobile = mobile.substring(3);
        }
        
        if (mobile.length() != 10) {
            return false;
        }
        
        for (int i = 0; i < mobile.length(); i++) {
            if (!Character.isDigit(mobile.charAt(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter PAN number: ");
        String pan = scanner.nextLine();
        
        System.out.print("Enter Mobile number: ");
        String mobile = scanner.nextLine();
        
        try {
            if (!validatePAN(pan)) {
                throw new InvalidDataException("Invalid PAN number");
            }
            
            if (!validateMobile(mobile)) {
                throw new InvalidDataException("Invalid Mobile number");
            }
            
            System.out.println("PAN: " + pan);
            System.out.println("Mobile: " + mobile);
            System.out.println("Both PAN and Mobile are valid!");
            
        } catch (InvalidDataException e) {
            System.out.println("Invalid data: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Problem 8: Write a Java program to count the frequency of each character in a given string

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Using HashMap to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Count frequency of each character
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Display the frequency of each character
        System.out.println("Character frequencies:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
        
        scanner.close();
    }
}

// Problem 9: Write a menu driven program using command line argument (+, -, *, /)

public class Calculator {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculator <number1> <operator> <number2>");
            System.out.println("Operators: + - * /");
            return;
        }
        
        try {
            double num1 = Double.parseDouble(args[0]);
            String operator = args[1];
            double num2 = Double.parseDouble(args[2]);
            double result = 0;
            
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operator. Please use +, -, * or /");
                    return;
            }
            
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numbers");
        }
    }
}

// Problem 10: Display the following pattern
/*
1
01
010
1010
*/

public class BinaryPattern {
    public static void main(String[] args) {
        int rows = 4;  // Number of rows in the pattern
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                // Print 1 if i+j is odd, otherwise print 0
                System.out.print((i + j) % 2);
            }
            System.out.println();
        }
    }
}

// Problem 11: Write a Java program to copy only non-numeric data from one file to another file

import java.io.*;

public class CopyNonNumericData {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String targetFile = "target.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder nonNumeric = new StringBuilder();
                
                // Extract non-numeric characters from each line
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (!Character.isDigit(c)) {
                        nonNumeric.append(c);
                    }
                }
                
                // Write non-numeric data to target file
                writer.write(nonNumeric.toString());
                writer.newLine();
            }
            
            System.out.println("Non-numeric data copied successfully from " + sourceFile + " to " + targetFile);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Problem 1: Display all .txt files from a given directory
import java.io.*;

public class TxtFileLister {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\YourUsername\\Documents"; // Change this to your directory
        File directory = new File(directoryPath);
        
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
            if (files != null && files.length > 0) {
                System.out.println("List of .txt files:");
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}

// Problem 2: Accept Employee details and display in a GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EmployeeDetails extends JFrame {
    JTextField enoField, enameField, esalField;
    JButton submitButton;
    
    EmployeeDetails() {
        setTitle("Employee Details");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));
        
        add(new JLabel("Emp No:"));
        enoField = new JTextField();
        add(enoField);
        
        add(new JLabel("Emp Name:"));
        enameField = new JTextField();
        add(enameField);
        
        add(new JLabel("Emp Salary:"));
        esalField = new JTextField();
        add(esalField);
        
        submitButton = new JButton("Submit");
        add(submitButton);
        
        submitButton.addActionListener(e -> {
            String empDetails = "Emp No: " + enoField.getText() + "\nEmp Name: " + enameField.getText() + "\nEmp Salary: " + esalField.getText();
            JOptionPane.showMessageDialog(this, empDetails);
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new EmployeeDetails();
    }
}

// Problem 3: File operations - Create, Rename, Delete, Display Path
import java.io.*;
public class FileOperations {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        
        // Create a file
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getAbsolutePath());
        } else {
            System.out.println("File already exists.");
        }
        
        // Rename file
        File renamedFile = new File("renamed_test.txt");
        if (file.renameTo(renamedFile)) {
            System.out.println("File renamed to: " + renamedFile.getAbsolutePath());
        }
        
        // Display path
        System.out.println("File Path: " + renamedFile.getAbsolutePath());
        
        // Delete file
        if (renamedFile.delete()) {
            System.out.println("File deleted.");
        }
    }
}

// Problem 4: Package SUBSCIT with Student and Teacher classes
package SUBSCIT;

class Student {
    int rno;
    String name;
    float per;
    
    Student(int rno, String name, float per) {
        this.rno = rno;
        this.name = name;
        this.per = per;
    }
    
    void disp() {
        System.out.println("Student Details: " + rno + " " + name + " " + per);
    }
}

class Teacher {
    int tid;
    String tname, subj;
    
    Teacher(int tid, String tname, String subj) {
        this.tid = tid;
        this.tname = tname;
        this.subj = subj;
    }
    
    void disp() {
        System.out.println(tname + " is teaching " + subj);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Alice", 85.5f);
        Teacher t1 = new Teacher(101, "Mr. Smith", "Java");
        s1.disp();
        t1.disp();
    }
}
import java.util.*;

// Problem 16: Accept a number from the user. If it's greater than 1000, throw a user-defined exception "No is out of range", otherwise display its factors.

class OutOfRangeException extends Exception {
    public OutOfRangeException(String message) {
        super(message);
    }
}

public class FactorCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        
        try {
            if (num > 1000) {
                throw new OutOfRangeException("No is out of range");
            }
            
            System.out.println("Factors of " + num + " are: ");
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.print(i + " ");
                }
            }
            
        } catch (OutOfRangeException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

// Problem 17: Count integers from a given array and display compound interest of every year.

class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Counting integers from array
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Total integers in the array: " + numbers.length);

        // Compound interest calculation
        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter rate of interest: ");
        double rate = scanner.nextDouble();
        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        System.out.println("Year-wise Compound Interest:");
        for (int i = 1; i <= years; i++) {
            double amount = principal * Math.pow((1 + rate / 100), i);
            System.out.printf("Year %d: %.2f%n", i, amount);
        }

        scanner.close();
    }
}

// Problem 18: Accept age from user and check voting eligibility.

class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        scanner.close();
    }
}

