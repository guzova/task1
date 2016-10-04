import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Double.parseDouble;

/**
 * Created by GE70 on 05.09.2016.
 */
public class Calculator {
    public static void main(String[] args) throws Exception {
        Double result;
        try {
            result = setNumbers();
            System.out.println("Результат = " + result);
        } catch (NumberFormatException e) {
            System.out.println("вы ввели не число! ай-ай-ай!");
        } catch (Exceptions exception) {
            System.out.print(exception.getMessage());
        }
    }

    public static double setNumbers() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String buffer;
        System.out.println("Введите первое число: ");
        buffer = in.readLine();
        Double numberOne = Double.parseDouble(buffer);
        System.out.println("Введите второе число: ");
        buffer = in.readLine();
        Double numberTwo = Double.parseDouble(buffer);
        System.out.println("Введите знак оператора: ");
        String operatorSign = in.readLine();
        return getResults(numberOne, numberTwo, operatorSign);
    }

    public static double getResults(double numberOne, double numberTwo, String operatorSign) throws Exception {
        switch (operatorSign) {
            case "+":
                return (numberOne + numberTwo);
            case "-":
                return (numberOne - numberTwo);
            case "/":
                if (numberTwo == 0)
                    throw new Exceptions("Деление на ноль ");
                else
                    return (numberOne / numberTwo);
            case "*":
                return (numberOne * numberTwo);
            case "^":
                return (Math.pow(numberOne, numberTwo));
            case "%":
                return ((numberOne - numberTwo) / numberOne * 100);
        }
        throw new Exceptions("Неправильный знак операции ");
    }
}
