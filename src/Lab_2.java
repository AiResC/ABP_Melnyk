import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_2 {

    //validation functions

    public static double validDouble(Scanner input, String outputMessage){
        double value = 0;
        boolean valid = false;
        do{try{
            System.out.println(outputMessage);
            value = input.nextDouble();
            valid = true;
        }catch(InputMismatchException e){
            System.out.println("Введіть число, будь ласка!!!");
            input.next();
            valid = false;
        }
        }while(!valid);
        return value;
    }

    //task 11
    public static class Matrix2x3 {
        private double[][] data;

        public Matrix2x3(double[][] data) {
            this.data = new double[2][3];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    this.data[i][j] = data[i][j];
                }
            }
        }

        public void multiplyByNum(double num) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    data[i][j] *= num;
                }
            }
        }

        public void add(Matrix2x3 other) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    this.data[i][j] += other.data[i][j];
                }
            }
        }

        public double[][] transpose() {
            double[][] result = new double[3][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    result[j][i] = data[i][j];
                }
            }
            return result;
        }

        public void print() {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.printf("%-8.1f", data[i][j]);
                }
                System.out.println();
            }
        }
    }

    //main
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);


        System.out.println("Введення матриці А (2х3):");
        double[][] aValues = new double[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                aValues[i][j] = validDouble(input, "Елемент [" + i + "][" + j + "]: ");
            }
        }
        Matrix2x3 aMat = new Matrix2x3(aValues);

        System.out.println("\nМатриця А:");
        aMat.print();
        System.out.println("\n------------------------------------------\n");


        double num = validDouble(input, "\nВведіть число для множення: ");
        aMat.multiplyByNum(num);
        System.out.println("\nРезультат множення:");
        aMat.print();


        System.out.println("\n------------------------------------------\n");
        System.out.println("\nВведення матриці Б (2х3) для додавання:");
        double[][] bMatVal = new double[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                bMatVal[i][j] = validDouble(input, "Елемент [" + i + "][" + j + "]: ");
            }
        }
        Matrix2x3 bMat = new Matrix2x3(bMatVal);
        System.out.println("\nМатриця B:");
        bMat.print();


        System.out.println("\n------------------------------------------\n");
        aMat.add(bMat);
        System.out.println("Результат А + Б:");
        aMat.print();


        System.out.println("\n------------------------------------------\n");
        System.out.println("\nТранспонована матриця (3х2):");
        double[][] transposed = aMat.transpose();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("%-8.1f", transposed[i][j]);
            }
            System.out.println();
        }
    }
}