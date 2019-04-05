package cs10_cs03;

import java.util.Scanner;

public class Test {
    static int choice, i, j, t, index, index1,index2;
    static char var, var1;
    static int number;
    static float value;
    private static int[][] c = new int[100][100];
    private static boolean[] state = new boolean[4];

    private static int mapIndex(char poly) {
        int i = 0;
        switch (poly) {
        case 'A':
            i = 0;
            break;
        case 'B':
            i = 1;
            break;
        case 'C':
            i = 3;
            break;
        case 'R':
            i = 2;
            break;
        default:
            throw new RuntimeException();
        }
        return i;
    }

    public static void main(String[] args) {
        PolynomialSolver sss = new PolynomialSolver();
        while (choice != 8) {
            System.out.println("Please choose an action");
            System.out.println("-----------------------");
            System.out.println("1- Set a polynomial variable");
            System.out.println("2- Print the value of a polynomial variable");
            System.out.println("3- Add two polynomials");
            System.out.println("4- Subtract two polynomials");
            System.out.println("5- Multiply two polynomials");
            System.out.println("6- Evaluate a polynomial at some point");
            System.out.println("7- Clear a polynomial variable");
            System.out.println("8- Exit");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Insert the variable name: A, B or C");
                var = sc.next().charAt(0);
                index = mapIndex(var);
                state[index] = true;
                System.out.println("Insert the number of terms");
                number = sc.nextInt();
                System.out.println("Insert the polynomial terms in the form:");
                System.out.println(
                        "(coeff1, exponent1), (coeff2, exponent2), ..");
                for (i = 0; i < number; i++) {
                    for (j = 0; j < 2; j++) {
                        t = sc.nextInt();
                        c[i][j] = t;
                    }
                }
                sss.setPolynomial(var, c);
                System.out.println("Polynomial " + var + " is set");
                break;
            case 2:
                System.out.println("Insert the variable name: A, B, C or R");
                var = sc.next().charAt(0);
                index = mapIndex(var);
                while (state[index] == false) {
                    System.out.println("Variable not set");
                    System.out.println(
                            "Insert the variable name: A, B, C or R");
                    var = sc.next().charAt(0);
                    index = mapIndex(var);
                }
                System.out.println("Value in " + var + " : " + sss.print(var));
                break;
            case 3:
                System.out.println(
                        "Insert first operand variable name: A, B or C");
                var = sc.next().charAt(0);
                index = mapIndex(var);
                while (state[index] == false) {
                    System.out.println("Variable not set");
                    System.out.println(
                            "Insert first operand variable name: A, B or C");
                    var = sc.next().charAt(0);
                    index = mapIndex(var);
                }
                System.out.println(
                        "Insert second operand variable name: A, B or C");
                var1 = sc.next().charAt(0);
                index1 = mapIndex(var1);
                while (state[index1] == false) {
                    System.out.println("Variable not set");
                    System.out.println(
                            "Insert second operand variable name: A, B or C");
                    var1 = sc.next().charAt(0);
                    index1 = mapIndex(var1);
                }
                sss.setPolynomial('R', sss.add(var, var1));
                index2 = mapIndex('R');
                state[index2] = true;
                System.out.println("Result set in R: " + sss.print('R'));
                break;
            case 4:
                System.out.println(
                        "Insert first operand variable name: A, B or C");
                var = sc.next().charAt(0);
                index = mapIndex(var);
                while (state[index] == false) {
                    System.out.println("Variable not set");
                    System.out.println(
                            "Insert first operand variable name: A, B or C");
                    var = sc.next().charAt(0);
                    index = mapIndex(var);
                }
                System.out.println(
                        "Insert second operand variable name: A, B or C");
                var1 = sc.next().charAt(0);
                index1 = mapIndex(var1);
                while (state[index1] == false) {
                    System.out.println("Variable not set");
                    System.out.println(
                            "Insert second operand variable name: A, B or C");
                    var1 = sc.next().charAt(0);
                    index1 = mapIndex(var1);
                }
                sss.setPolynomial('R', sss.subtract(var, var1));
                index2 = mapIndex('R');
                state[index2] = true;
                System.out.println("Result set in R: " + sss.print('R'));
                break;

            case 5:
                System.out.println(
                        "Insert first operand variable name: A, B or C");
                var = sc.next().charAt(0);
                index = mapIndex(var);
                while (state[index] == false) {
                    System.out.println("Variable not set");
                    System.out.println(
                            "Insert first operand variable name: A, B or C");
                    var = sc.next().charAt(0);
                    index = mapIndex(var);
                }
                System.out.println(
                        "Insert second operand variable name: A, B or C");
                var1 = sc.next().charAt(0);
                index1 = mapIndex(var1);
                while (state[index1] == false) {
                    System.out.println("Variable not set");
                    System.out.println(
                            "Insert second operand variable name: A, B or C");
                    var1 = sc.next().charAt(0);
                    index1 = mapIndex(var1);
                }
                sss.setPolynomial('R', sss.multiply(var, var1));
                index2 = mapIndex('R');
                state[index2] = true;
                System.out.println("Result set in R: " + sss.print('R'));
                break;
            case 6:
                System.out.println("Insert the variable name: A, B, C or R");
                var = sc.next().charAt(0);
                index = mapIndex(var);
                while (state[index] == false) {
                    System.out.println("Variable not set");
                    System.out.println(
                            "Insert the variable name: A, B, C or R");
                    var = sc.next().charAt(0);
                    index = mapIndex(var);
                }
                System.out.println("Enter the value for evaluation");
                value = sc.nextFloat();
                System.out.println("Evaluation of " + var + " :"
                        + sss.evaluatePolynomial(var, value));
                break;
            case 7:
                System.out.println("Insert the variable name: A, B, C or R");
                var = sc.next().charAt(0);
                sss.clearPolynomial(var);
                System.out.println(var+" is cleared");
            default:throw new RuntimeException();

            }
            if (choice != 8) {
                System.out.println(
                        "====================================================================");
            }
        }

    }

}