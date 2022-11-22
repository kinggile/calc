
import java.util.Scanner;

class CalculatorHelper {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = sc.nextLine();
        System.out.println(Calculator.calc(input));
    }
}

public class Calculator {
    public static String calc(String input) throws Exception {
        int num1, num2;
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        input = sc.nextLine();
         */
        String[] regexInput = input.split(" ");
        boolean romIsTrue = false;
        int result;
        int counter = 0;
        String output = null;

        for (int i = 0; i < regexInput.length; i += 2) { // proverka exp like V + 1 => invalid exp AND проверка на римские цифры, если ввод их, то romIsTrue = true;
            try {
                Integer.parseInt(regexInput[i]);
            } catch (Exception exception) {
                romIsTrue = true;
                counter++;
            }
        }

        if (counter == 1) {
            throw new Exception("invalid format of expression");
        }


        if (regexInput.length > 3) {
            throw new Exception("you entered more than 3 operators");
        }

        num1 = getRomToInt(regexInput[0]);
        num2 = getRomToInt(regexInput[2]);
        result = getCalculate(num1, num2, regexInput[1]);

        if (romIsTrue) {
            output = getConvertNumToRom(result);
        } else if (num1 > 0 && num1 < 11 && num2 > 0 && num2 < 11) {
            output = String.valueOf(result);
            // output = Integer.toString(result);
        } else {
            throw new Exception("0<nums<11");
        }
        return output;
    }


    public static int getRomToInt(String romNum) throws Exception {
        int myInt = 0;
        try {
            myInt = Integer.parseInt(romNum);
        } catch (Exception e) {
            switch (romNum.toUpperCase()) {
                case "I":
                    myInt = 1;
                    break;
                case "II":
                    myInt = 2;
                    break;
                case "III":
                    myInt = 3;
                    break;
                case "IV":
                    myInt = 4;
                    break;
                case "V":
                    myInt = 5;
                    break;
                case "VI":
                    myInt = 6;
                    break;
                case "VII":
                    myInt = 7;
                    break;
                case "VIII":
                    myInt = 8;
                    break;
                case "IX":
                    myInt = 9;
                    break;
                case "X":
                    myInt = 10;
                    break;
                default:
                    throw new Exception("invalid counter of nums or other mistake");
            }
        }
        return myInt;
    }


    public static String getConvertNumToRom(int arabNum) throws Exception {
        String convert = null;
        if (arabNum > 0) {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
            convert = roman[arabNum];
            return convert;
        } else {
            throw new Exception("in romNums cannot be 0 or negatives");
        }


    }

    public static int getCalculate(int num1, int num2, String operation) throws Exception {
        int result = 0;
        switch (operation) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "." -> result = num1 / num2;
            case "*" -> result = num1 * num2;
            default -> throw new Exception("invalid operator");
        }

        return result;
    }
}

