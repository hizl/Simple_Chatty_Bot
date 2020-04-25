package bot;

import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    SimpleBot bot = new SimpleBot("Alice", "1998");
    bot.run();
  }
}

public class SimpleBot {
    private String name;
    private String birthYear;
    
    final static Scanner scanner = new Scanner(System.in); // Do not change this line

    public SimpleBot(String name, String birthYear) {
      this.name = name;
      this.birthYear = birthYear;
    }

    protected void greet() {
        System.out.println("Hello! My name is " + this.name + ".");
        System.out.println("I was created in " + this.birthYear + ".");
        System.out.println("Please, remind me your name.");
    }

    protected void remindName() {
        String name = scanner.nextLine();
        System.out.println("What a great name you have, " + name + "!");
    }

    protected void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Say me remainders of dividing your age by 3, 5 and 7.");
        int rem3 = scanner.nextInt();
        int rem5 = scanner.nextInt();
        int rem7 = scanner.nextInt();
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");
    }

    protected void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int num = scanner.nextInt();
        for (int i = 0; i <= num; i++) {
            System.out.printf("%d!\n", i);
        }
    }


    protected void test() {
        System.out.println("Let's test your programming knowledge.");

        System.out.println("Which of the following operators is used to allocate memory to an array?");
        String answ1 = ".create";
        String answ2 = ".aloc";
        String answ3 = ".new";
        String answ4 = ".array";

        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;

        System.out.println(num1 + answ1 + "\n" + num2 + answ2 + "\n" + num3 + answ3 + "\n" + num4 + answ4);
        int number;


        do {
            number = scanner.nextInt();
            {
                System.out.println("Please, try again.");
            }


        } while (number != 3);

    }


    protected void end() {
        System.out.println("Congratulations, have a nice day!"); // Do not change this text
    }

    public void run() {
        this.greet(); // change it as you need
        this.remindName();
        this.guessAge();
        this.count();
        this.test();
        this.end();
    }
}