import java.util.Locale;
import java.util.Scanner;

public class Laba1 {
    private Scanner scanner = new Scanner(System.in);

    // ===== Вспомогательные методы ввода (private) =====

    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите целое число: ");
            scanner.next(); // сбрасываем некорректный ввод
        }
        return scanner.nextInt();
    }

    private double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print(" Ошибка! Введите дробное число: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private char readChar(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNext()) {
            System.out.print("Ошибка! Введите символ: ");
            scanner.next();
        }
        return scanner.next().charAt(0);
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }


    private int[] readArray() {
        int n = readInt("Введите размер массива: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readInt("arr[" + i + "] = ");
        }
        return arr;
    }


    private void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public double fraction (double x){
        return Math.abs( x - (int) x );
    }

    public int sumLastNums (int x){
        if (x>=100){
            int x1 = x % 10;
            int x2 = x / 10 % 10;
            return  x1+x2;
        }
        else{
            System.out.println("Ошибка! Число должно иметь более 3 знаков");
            return -1;
        }
    }


    public boolean is2Digits (int x){
        int x1 = Math.abs(x);
        if (x1>=10 && x1<=99){
            return true;
        }
            return false;
    }


    public boolean isInRange (int a, int b, int num){
        if ((num>=a && num<=b) || (num>=b && num<=a)){
            return  true;
        }
        return false;
    }

    public boolean isEqual(int a, int b, int c){
        if (a==b && b==c) return true;
        return false;
    }

    public double safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        }
        return (double) x / y;
    }


    public boolean is35 (int x){
        if(x%5==0 && x%3==0) return false;
        else{
            if (x%5==0 || x%3==0) return true;
        }
        return false;
    }

    // ===== Главный метод =====
    public static void main(String[] args) {
        Laba1 lab = new Laba1();
        lab.run();
    }


    public boolean sum3 (int x, int y, int z){
        if ((x+y==z) || (x+z==y) || (y+z==x)) return true;
        return false;
    }

    public String age (int x){
        if (x>=0){
            if(x%10==1 && x!=11) return "год";
            if ((x%10==2 || x%10==3 || x%10==4 ) && (x!=12 && x!=13 && x!=14)) return "года";

        }
        return "лет";
    }


    public void printDays (String x){
        switch (x.toLowerCase(Locale.ROOT)){
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }

    public String listNums (int x){
        String answer = " ";
        for (int i = 0; i<=x; i++){
            if (i>0) answer +=" ";
            answer += i;
        }
        return answer;
    }

    public int pow (int x, int y){
        int ansswer = 1;
        for(int i=0; i<y; i++){
            ansswer*=x;
        }
        return ansswer;
    }


    public int numLen (long x){
        long a=Math.abs(x);
        int i=0;
        while (a>0){
            a=a/10;
            i++;
        }
        return i;
    }


    public void square (int x){
        for (int i = 0; i<x; i++){
            for (int j = 0; j<x; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public void guessGame() {
        int secret = (int) (Math.random() * 10);  // случайное число 0-9
        int attempts = 0;
        int guess;

        do {
            guess = readInt("Введите число от 0 до 9: ");


            if (guess < 0 || guess > 9) {
                System.out.println("Число должно быть от 0 до 9!");

                continue;
            }
            attempts++;

            if (guess != secret) {
                System.out.println("Вы не угадали!");
            }
        } while (guess != secret);

        System.out.println("Вы угадали!");
        System.out.println("Вы отгадали число за " + attempts + " " +
                (attempts == 1 ? "попытку" :
                        (attempts >= 2 && attempts <= 4 ? "попытки" : "попыток")));
    }

    public int maxAbs(int[] arr) {
        int maxElem = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxElem)) {
                maxElem = arr[i];
            }
        }
        return maxElem;
    }


    public int[] add(int[] arr, int[] ins, int pos) {
        int [] arr2 = {0};
        if (arr.length + ins.length<pos) {
            System.out.println("Позиция не может быть больше длинны массива");
            return arr2;
        }
        int[] result = new int[arr.length + ins.length];


        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }

        for (int i = pos; i < arr.length; i++) {
            result[ins.length + i] = arr[i];
        }
        return result;
    }


    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        printArray(arr);
    }

    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }

        return result;
    }



    public int[] findAll(int[] arr, int x) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) count++;
        }


        int[] result = new int[count];


        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[idx] = i;
                idx++;
            }
        }

        return result;
    }
    // ===== Дружественный интерфейс =====
    public void run() {
        System.out.println("=== Лабораторная работа №1, вариант 9 ===\n");
        System.out.println("--- Задание 1.1 ---");
        double x1 = readDouble("Введите дробное число: ");
        double result1 = fraction(x1);
        System.out.println("Дробная часть:" + result1);
        System.out.println();


        System.out.println("--- Задание 1.2 ---");
        int x2 = readInt("Введите целое число >=100: ");
        int result2 = sumLastNums(x2);
        System.out.println("Сумма двух последних цифр:" + result2);
        System.out.println();

        System.out.println("--- Задание 1.5 ---");
        int x3 = readInt("Введите целое число: ");
        boolean result3 = is2Digits(x3);
        System.out.println("результат: " + result3);
        System.out.println();

        System.out.println("--- Задание 1.7 ---");
        int a4 = readInt("Введите целое число: ");
        int b4 = readInt("Введите целое число: ");
        int num = readInt("Введите целое число: ");
        boolean result4 = isInRange(a4,b4,num);
        System.out.println("результат: " + result4);
        System.out.println();


        System.out.println("--- Задание 1.9 ---");
        int a5 = readInt("Введите целое число: ");
        int b5 = readInt("Введите целое число: ");
        int c5 = readInt("Введите целое число: ");

        boolean result5 = isEqual(a5,b5,c5);
        System.out.println("результат: " + result5);
        System.out.println();


        System.out.println("--- Задание 2.2 ---");
        int a6 = readInt("Введите целое число: ");
        int b6 = readInt("Введите целое число: ");


        double result6 = safeDiv(a6,b6);
        System.out.println("результат: " + result6);
        System.out.println();



        System.out.println("--- Задание 2.3 ---");
        int a7 = readInt("Введите целое число: ");


        boolean result7 = is35(a7);
        System.out.println("результат: " + result7);
        System.out.println();


        System.out.println("--- Задание 2.6 ---");
        int a8 = readInt("Введите целое число: ");
        int b8 = readInt("Введите целое число: ");
        int c8 = readInt("Введите целое число: ");
        boolean result8 = sum3(a8,b8,c8);
        System.out.println("результат: " + result8);
        System.out.println();


        System.out.println("--- Задание 2.8 ---");
        int a9 = readInt("Введите целое число: ");
        String result9 = age(a9);
        System.out.println("результат: " + a9 + " " + result9);
        System.out.println();


        System.out.println("--- Задание 2.10 ---");
        String a10 = readString("Введите день недели: ");
        printDays(a10);
        System.out.println();


        System.out.println("--- Задание 3.1 ---");
        int a11 = readInt("Введите x: ");
        System.out.println("результат: " + listNums(a11));
        System.out.println();




        System.out.println("--- Задание 3.4 ---");
        int a12 = readInt("Введите x: ");
        int b12 = readInt("Введите y: ");
        System.out.println("результат: " + pow(a12, b12));
        System.out.println();



        System.out.println("--- Задание 3.5 ---");
        int a13 = readInt("Введите x: ");

        System.out.println("результат: " + numLen(a13));
        System.out.println();

        System.out.println("--- Задание 3.7 ---");
        int a14 = readInt("Введите x: ");
        square(a14);

        System.out.println("--- Задание 3.10 ---");
        guessGame();
        System.out.println();

        System.out.println("--- Задание 4.3 ---");
        System.out.println("результат: " + maxAbs(readArray()));
        System.out.println();

        System.out.println("--- Задание 4.5 ---");

        printArray(add(readArray(), readArray(), readInt("Введите позицию: ")));
        System.out.println("результат: " );
        System.out.println();

        System.out.println("--- Задание 4.6 ---");
        reverse(readArray());
        System.out.println();

        System.out.println("--- Задание 4.8 ---");

        printArray(concat(readArray(), readArray()));
        System.out.println("результат: " );
        System.out.println();


        System.out.println("--- Задача 4.9 ---");
        int[] result4_9 = findAll(readArray(), readInt("Введите число для поиска x: "));
        System.out.print("Индексы вхождений: ");
        printArray(result4_9);
        System.out.println();

    }
}