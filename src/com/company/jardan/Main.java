package com.company.jardan;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static double[][] inputArray;
    public static String[][] resultArray;

    public static void main(String[] args) {
    Scanner number = new Scanner(System.in);
    System.out.println("Введите размер матрицы");
    int a = number.nextInt();
    int b = number.nextInt();
	CreateMatrix(a, b);
    SecondChange();
    String answer;
    boolean temp = true;
        while (temp) {
            System.out.println("Продолжить вычисления? y=Да, f=Результат");
            answer = number.next();
            if (Objects.equals(answer, "y")) {
                SecondChange();
            } else {
//                Result();
                temp = false;
            }
        }
    }


    static void printMatrix (double[][] inputArray, int a, int b) {
        resultArray[0][b+1] = "  0";
        resultArray[a+1][0] = "x" + b;

        for (int i = 1; i < resultArray.length; i++){
            for (int j = 1; j < resultArray[i].length; j++){
                if (inputArray[i-1][j-1] < 10.0 && inputArray[i-1][j-1] > 0.0) {
                    resultArray[i][j] = "  " + inputArray[i - 1][j - 1];
                }
                if (inputArray[i-1][j-1] >= 10.0) {
                    resultArray[i][j] = " " + inputArray[i - 1][j - 1];
                }
                if (inputArray[i-1][j-1] < 0.0 && inputArray[i-1][j-1] > -10.0) {
                    resultArray[i][j] = " " + inputArray[i - 1][j - 1];
                }
                if (inputArray[i-1][j-1] <= -10.0) {
                    resultArray[i][j] = String.valueOf(inputArray[i-1][j-1]);
                }
                if (inputArray[i-1][j-1] == 0.0) {
                    resultArray[i][j] = "  " + inputArray[i - 1][j - 1];
                }
            }
        }
        for (int i = 1; i < resultArray.length; i++){
            for (int j = 1; j < resultArray[i].length; j++){
                resultArray[i][b+1] = "  0";
            }
        }
        for (int i = 1; i < resultArray.length; i++){
            for (int j = 1; j < resultArray[i].length; j++){
                if (resultArray[0][j].equals("  0")) {
                    resultArray[i][j] = "  0";
                }
            }
        }

        Arrays.stream(resultArray).map(Arrays::toString).forEach(System.out::println);
    }

    static void CreateMatrix(int a, int b) {
        inputArray = new double[a][b];
        resultArray = new String[a+1][b+1];
        Scanner number = new Scanner(System.in);

        for (int i = 0; i < inputArray.length; i++){
            for (int j = 0; j < inputArray[i].length; j++){
                System.out.println("Введите значения для i: " + i + ", и j: " + j);
                inputArray[i][j]= number.nextDouble();
            }
        }

        for (int i = 0; i < resultArray.length; i++){
            for (int j = 2; j < resultArray[i].length; j++){
                resultArray[0][j] = "  -x" + (j-1);
                resultArray[i][0] = " 0";
            }
        }
        resultArray[0][0] = " 0";
        resultArray[0][1] = "    1";
        System.out.println("Input Matrix: ");
        for (int i = 1; i < resultArray.length; i++){
            for (int j = 1; j < resultArray[i].length; j++){
                resultArray[i][j] = String.valueOf(inputArray[i-1][j-1]);
            }
        }
        for (int i = 1; i < resultArray.length; i++){
            for (int j = 1; j < resultArray[i].length; j++){
                if (inputArray[i-1][j-1] < 10.0 && inputArray[i-1][j-1] > 0.0) {
                    resultArray[i][j] = "  " + inputArray[i - 1][j - 1];
                }
                if (inputArray[i-1][j-1] >= 10.0) {
                    resultArray[i][j] = " " + inputArray[i - 1][j - 1];
                }
                if (inputArray[i-1][j-1] < 0.0 && inputArray[i-1][j-1] > -10.0) {
                    resultArray[i][j] = " " + inputArray[i - 1][j - 1];
                }
                if (inputArray[i-1][j-1] <= -10.0) {
                    resultArray[i][j] = String.valueOf(inputArray[i-1][j-1]);
                }
                if (inputArray[i-1][j-1] == 0.0) {
                    resultArray[i][j] = "  " + inputArray[i - 1][j - 1];
                }
            }
        }
        Arrays.stream(resultArray).map(Arrays::toString).forEach(System.out::println);

    }

    static void SecondChange() {
        Scanner number = new Scanner(System.in);
        System.out.println("Выберете координаты разрешаюшего элемента");
        int xAks = number.nextInt();
        int yAks = number.nextInt();
        double aks = inputArray[xAks][yAks];

        System.out.println("Resolving element: " + aks);
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (i != xAks && j != yAks) {
                    inputArray[i][j] = ((inputArray[i][j] * inputArray[xAks][yAks]) - (inputArray[i][yAks] * inputArray[xAks][j])) / inputArray[xAks][yAks];
                }
            }
        };

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {

                if (i == xAks && j != yAks) {
                    inputArray[i][j] =  inputArray[i][j] / inputArray[xAks][yAks];
                }
                if (j == yAks && i != xAks) {
                    inputArray[i][j] = -1 * inputArray[i][j] / inputArray[xAks][yAks];
                }

            }
        };
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                if (i == xAks && j == yAks) {
                    inputArray[xAks][yAks] = 1 / inputArray[xAks][yAks];

                }
            }
        };

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                inputArray[i][j] = Math.round (inputArray[i][j] * 100) / 100.00;
            }
        };


        System.out.println("Second Matrix: ");
        printMatrix(inputArray, xAks, yAks);
    }

//    static void Result() {
//        String[][] res = new String[resultArray.length][1];
//        for (int i = 1; i < resultArray.length; i++){
//            for (int j = 1; j < resultArray[i].length; j++){
//                res[i][j] = String.valueOf(resultArray[0][j] + " = " + inputArray[i][j]);
//            }
//        }
//        System.out.println(Arrays.toString(res));
//    }
}
