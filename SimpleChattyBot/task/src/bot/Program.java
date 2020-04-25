package bot;

import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    SimpleBot bot = new SimpleBot(
      "Alice", 
      "1998",
      new ConsoleInput(),
      new ConsoleOutput()
    );
    bot.run();
  }
}

public class ConsoleInput implements Input {
  private Scanner scanner = new Scanner(System.in);

  public String nextLine() {
    return this.scanner.nextLine();
  };

  public int nextInt() {
    return this.scanner.nextInt();
  };
}

public class ConsoleOutput implements Output {
  public void outLine(String message) {
    System.out.println(message);
  };

  public void outFormat(String format, Object... args) {
    System.out.printf(format, args);
  };
}

public interface Input {
  public String nextLine();
  public int nextInt();
}

public interface Output {
  public void outLine(String message);
  public void outFormat(String format, Object... args);
}

public class Converter {
  public static int[] stringToInt(String[] rawNumbers) {
    int[] numbers = new int[rawNumbers.length];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(rawNumbers[i]);
    }
    return numbers;
  }
}

public class SimpleBot {
    private String name;
    private String birthYear;
    private Input input;
    private Output output;

    final static Scanner scanner = new Scanner(System.in); // Do not change this line

    public SimpleBot(String name, String birthYear, Input input, Output output) {
      this.name = name;
      this.birthYear = birthYear;
      this.input = input;
      this.output = output;
    }

    protected void greet() {
        String format = "Hello! My name is %s.\n";
        format += "I was created in %s.\n";
        format += "Please, remind me your name.\n"; 

        this.output.outFormat(
          format,
          this.name,
          this.birthYear
        );
    }

    protected void remindName() {
        String name = this.input.nextLine();
        this.output.outFormat(
          "What a great name you have, %s!\n",
          name
        );
    }

    protected void guessAge() {
        this.output.outLine(
          "Let me guess your age.\n" +
          "Say me remainders of dividing your age by 3, 5 and 7. Separate them with space"
        );

        String line = this.input.nextLine();
        int[] remainders = Converter.stringToInt(
          line.split(" ", 3)
        );
        
        int age = (remainders[0] * 70 + remainders[1] * 21 + remainders[2] * 15) % 105;
        this.output.outFormat("Your age is %d; that's a good time to start programming!", age);
    }

    protected void count() {
        this.output.outLine("Now I will prove to you that I can count to any number you want.");
        int num = this.input.nextInt();
        for (int i = 0; i <= num; i++) {
            this.output.outFormat("%d!\n", i);
        }
    }


    protected void test() {
        this.output.outLine("Let's test your programming knowledge.");

        this.output.outLine("Which of the following operators is used to allocate memory to an array?");
        String answ1 = ".create";
        String answ2 = ".aloc";
        String answ3 = ".new";
        String answ4 = ".array";

        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;

        this.output.outLine(num1 + answ1 + "\n" + num2 + answ2 + "\n" + num3 + answ3 + "\n" + num4 + answ4);
        int number;


        do {
            number = this.input.nextInt();
            {
                this.output.outLine("Please, try again.");
            }


        } while (number != 3);

    }


    protected void end() {
        this.output.outLine("Congratulations, have a nice day!"); // Do not change this text
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