import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.Math.pow;
public class Lab_1 {

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



    public static int validPosInt(Scanner input, String outputMessage){
        int value = -1;
        do{try{
            System.out.println(outputMessage);
            value = input.nextInt();
            if (value <= 0){
                System.out.println("Значення не може бути відʼємним!");
            }

        }catch(InputMismatchException e){
            System.out.println("Введіть число, будь ласка!!!");
            input.next();
        }
        }while(value <= 0);
        return value;
    }



    public static int validInt(Scanner input, String outputMessage){
        int value = 0;
        boolean valid = false;
        do{try{
            System.out.println(outputMessage);
            value = input.nextInt();
            valid = true;
        }catch(InputMismatchException e){
            System.out.println("Введіть число, будь ласка!!!");
            input.next();
            valid = false;
        }
        }while(!valid);
        return value;
    }



    public static double f(double x){
        return x - Math.pow(x, 3)/3 + Math.pow(x,5)/5;
    }


    //main
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int choice = validInt(input, "Номер задачі(1-5)? Ваш вибір:");

        switch (choice) {
            case 1: //1
                int side1 = validPosInt(input, "Введіть довжину сторони а:");
                int side2 = validPosInt(input, "Введіть довжину сторони b:");

                System.out.println("Периметр прямокутника: " + (2*side1 + 2*side2));
                System.out.println("Площа прямокутника: " + (side1 * side2));
                System.out.println("Діагональ прямокутника: " + Math.sqrt(side1*side1 + side2*side2));

                break;
            case 2: // 2
                double a = validDouble(input, "Введіть значення а з рівняння ах+b=0:");
                double b = validDouble(input, "Введіть значення b з рівняння ах+b=0:");

                if (a == 0 && b!=0){
                    System.out.println("Це рівняння не має коренів.");
                }else if (b ==0 && a==0){
                    System.out.println("Рівняння має безліч коренів");
                }else{
                    System.out.println("Корінь рівняння: " + (-b)/a);
                }




                break;
            case 3: // 3
                int n = validPosInt(input, "Введіть натуральне число n");
                double answer = 0;
                for (int k = 1; k<n+1; k++){
                    answer += (pow((-1), k))/(k*k*(k+1));
                }
                System.out.println("Відповідь: "+answer);

                break;

            case 4: //4
                double[] arr = {1.5, 26.3, 4.8, 2.1, 137.6, 46.2, 39.9, 304.4, 25.7, 7.3, 431.8, 216.5, 2.9, 290.1, 26.6, 324.0};
                double min = arr[0] - arr[15];
                for (int i = 0; i<8; i++){
                    double temp = arr[i]-arr[15-i];
                    if (temp < min){
                        min = temp;
                    }
                }

                System.out.println("Мінімальне число: "+ min);

                break;

            case 5: //5
                double[] arrx = new double[15];
                double[] arry = new double[15];

                int counter = 0;
                for (double i = 0; i <= 7; i += 0.5) {
                    arrx[counter] = i;
                    arry[counter] = f(i);
                    counter++;
                }

                // Convert double[] to String[]
                String[] arrxStr = new String[arrx.length];
                String[] arryStr = new String[arry.length];
                for (int i = 0; i < arrx.length; i++) {
                    arrxStr[i] = String.format("%.2f", arrx[i]);
                    arryStr[i] = String.format("%.2f", arry[i]);
                }

                //print
                System.out.printf("%-10s %-10s%n", "x", "y"); //header

                for (int i = 0; i < arrx.length; i++) {
                    System.out.printf("%-10s %-10s%n", arrxStr[i], arryStr[i]);
                }

                break;

            default:
                System.out.println("Такого варіанту не існує!");
        }
    }
}