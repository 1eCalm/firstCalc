import java.util.Scanner;

public  class Main {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String inputExample = scn.nextLine();
        String calcResult = calc(inputExample);
        System.out.println(calcResult);
    }

    public static String calc(String input) throws  Exception {
        String[] arrayExample = input.split(" ");

        if(arrayExample.length != 3) {
            throw new Exception();
        }
        try {
            Integer.parseInt(arrayExample[0]);
            return  arabSueta(arrayExample);

        } catch (Exception e) {
            return romeSueta(arrayExample);
        }
    }
        public static String arabSueta (String[]arrayExample) throws Exception {

            int num1;
            int num2;
            String number1 = arrayExample[0];
            String number2 = arrayExample[2];
            String mathOperation = arrayExample[1];


            if (arrayExample.length != 3) { //Если в примере не 3 составлящих --> исключение.
                throw new Exception();
            }

            try {
                num1 = Integer.parseInt(number1); //Если строку нельзя конвертировать в int == это не числа, --> исключение.
                num2 = Integer.parseInt(number2);
            } catch (Exception e) {
                throw new Exception();
            }

            if ((num1 < 0 || num1 > 10) || (num2 < 0 || num2 > 10)) { //Если вводимое 1-е и 2-е число -->
                throw new Exception(); // --> не в диапазоне от 0 до 10-и --> исключение.
            }

            String result;

            if (mathOperation.equals("+")) { //Если оператор не +, -, / или * --> исключение.
                result = num1 + num2 + "";
            } else if (mathOperation.equals("-")) {
                result = num1 - num2 + "";
            } else if (mathOperation.equals("/")) {
                result = num1 / num2 + "";
            } else if (mathOperation.equals("*")) {
                result = num1 * num2 + "";
            } else {
                throw new Exception();
            }
            return result;
        }

        public static String romeSueta (String[]arrayRomeExample) throws Exception {
            String[] romeNumbersI = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] romeNumbersX = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
            int[] arabicNumbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            int arabicOutputNumber1 = 0;
            int arabicOutputNumber2 = 0;
            int arabicResult;
            int arrayPos10;
            int arrayPos1;
            String romeResult;

            if (arrayRomeExample.length != 3) { // Если в примере не 3 составляющих --> исключение.
                throw new Exception();
            }

            String inputRomeNumber1 = arrayRomeExample[0];
            String inputRomeNumber2 = arrayRomeExample[2];
            String mathOperation = arrayRomeExample[1];

            // Ниже идет блок "кода", который нужен для проверки римские ли цифры были ввведены в примере.
            int firstRomeNumberCheck = 0; // Значение двух переменных становится "1", если в массиве romeNumbersI -->
            int secondRomeNumberCheck = 0; // Нашлось одинаковое значение с введеным числом на римском.
            for (int i = 0; i < romeNumbersI.length; i++) {
                if (inputRomeNumber1.equals(romeNumbersI[i])) {
                    firstRomeNumberCheck = firstRomeNumberCheck + 1;
                }
                if (inputRomeNumber2.equals(romeNumbersI[i])) {
                    secondRomeNumberCheck = secondRomeNumberCheck + 1;
                }
            }
            if ((firstRomeNumberCheck == 0) | (secondRomeNumberCheck == 0)) { //Если ввели не римское число --> исключение.
                throw new Exception();
            }


            for (int i = 0; i < romeNumbersI.length; i++) { //Ищем в массиве с римскими единицами значение, -->
                if (inputRomeNumber1.equals(romeNumbersI[i])) { //Чтобы предать его позицию в пременную, которая -->
                    arabicOutputNumber1 = arabicNumbers1[i]; //Нужна для решения примера сначала арабскими числами.
                }
                if (inputRomeNumber2.equals(romeNumbersI[i])) { // Так же ищем значение переменной, -->
                    arabicOutputNumber2 = arabicNumbers1[i]; // Но уже для второго арабского числа.
                }
            }

            if (mathOperation.equals("+")) { // После того, как мы конвертировали введеные римские числа в арабские -->
                arabicResult = arabicOutputNumber1 + arabicOutputNumber2; // Находим результат выражения и записываем -->
            } else if (mathOperation.equals("-")) { // Его в переменную arabicResult. Эта переменная нужна, чтобы -->
                arabicResult = arabicOutputNumber1 - arabicOutputNumber2; // Потом конвертировать ответ из арабских чисел в римские. -->
            } else if (mathOperation.equals("*")) { //Так же, если оператор не  +, -, / или * --> исключение.
                arabicResult = arabicOutputNumber1 * arabicOutputNumber2;
            } else if (mathOperation.equals("/")) {
                arabicResult = arabicOutputNumber1 / arabicOutputNumber2;
            } else {
                throw new Exception();
            }

            arrayPos10 = arabicResult / 10; //Находим позицию десяток. (64 / 10 == 6, значит 6-й символ в массиве с римскими десятками.)
            arrayPos1 = arabicResult % 10; //Находим позицию единиц. (64 % 10 == 4, значит 4-й символ в массиве с римскими единицами.)
            try {
                if (arabicResult / 10 == 0) { //Проверяю результат, если число/10 == 0, надо искать только единицы.
                    romeResult = romeNumbersI[arrayPos1 - 1];
                    return romeResult;
                } else if (arabicResult % 10 == 0) { //Проверяю резльутат, если число%10 == 0, надо искать только десятки.
                    romeResult = romeNumbersX[arrayPos10 - 1];
                    return romeResult;
                } else { //Если в числе есть и десятки, и единицы --> вывод реузльтата.
                    romeResult = romeNumbersX[arrayPos10 - 1] + romeNumbersI[arrayPos1 - 1];
                    return romeResult;
                }
            } catch (Exception e) { //Если результат отрицательное число или 0 --> исключение.
                throw new Exception();
            }
        }
    }