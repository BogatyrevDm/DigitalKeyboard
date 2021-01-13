package com.example.digitalkeyboard;

public class Calculator {
    private double result;//результат вычисления
    private double firstNumber;//вводимое в настоящий момент число.
    private String sign;//знак вычисления
    private boolean commaAdded;//флаг, указывающий на то, что вводятся числа дробной части
    private int quantityAfterComma;//хранит количество знаков после запятой
    public Calculator() {
        this.firstNumber = 0.0;
        this.result = 0.0;
        this.commaAdded = false;
        this.quantityAfterComma = 0;
        this.sign = "";
    }

    void setEqual() {
        if (sign == "") {//знак действия не нажат, не выполняем вычисления
            return;
        }
        if (firstNumber == 0.0) {//пользователь не ввел второе число. Делаем вычисление с самим собой
            makeCalculation(result, result);
        } else {
            makeCalculation(result, firstNumber);
        }
        resetNumbers();
        clearSing();

    }

    private void clearSing() {
        this.sign = "";
    }

    void resetNumbers() {

        result = firstNumber;
        firstNumber = 0.0;
        quantityAfterComma = 0;
        setComma(false);

    }

    void makeCalculation(double fNumber, double sNumber) {
        switch (sign) {
            case "+":
                firstNumber = fNumber + sNumber;
                break;
            case "-":
                firstNumber = fNumber - sNumber;
                break;
            case "/":
                firstNumber = fNumber / sNumber;
                break;
            case "*":
                firstNumber = fNumber * sNumber;
                break;

        }

    }

    void setChangeSing() {
        firstNumber = firstNumber * -1.0;

    }

    void cleatAll() {
        quantityAfterComma = 0;
        firstNumber = 0;
        result = 0;
        setComma(false);
        clearSing();

    }

    void clearOne() {
        if (quantityAfterComma == 0) {

            firstNumber = Math.floor(firstNumber / 10.0);
        } else {
            quantityAfterComma--;
            double scale = Math.pow(10, quantityAfterComma);//множитель для дробной части
            firstNumber = Math.floor(firstNumber * scale);
            firstNumber = firstNumber / scale;
        }
    }

    void setSing(String sign) {
        if (this.sign != "") {//Пользователь нажал знак вычисления второй раз. Выполним действия, равносильные нажатию =
            setEqual();
        } else {

            resetNumbers();
        }
        this.sign = sign;
    }

    void setComma(boolean commaValue) {
        commaAdded = commaValue;
    }

    void setNumber(String number) {
        //Приводим строку к числу
        int intNumber = Integer.parseInt(number);
        if (firstNumber == 0) {
            if (intNumber == 0) {
                //Если число равно 0 и передан 0 - устанавливаем признак дробной части
                setComma(true);
            } else {
                //Первая цифра в числе
                firstNumber = intNumber;
            }
        } else {
            if (commaAdded) { //увеличиваем дробную часть
                quantityAfterComma++; //увеличиваем количество цифр дробной части
                /*double scale = Math.pow(10, quantityAfterComma);//множитель для дробной части
                double floor = Math.floor(firstNumber);//определяем целую часть
                double numberBeforeScaling = floor + ((firstNumber - floor) * scale + (double)intNumber);
                numberBeforeScaling = Math.floor(numberBeforeScaling);
                firstNumber = numberBeforeScaling / scale;
                 */
                double scale = Math.pow(10, quantityAfterComma);//множитель для дробной части
                firstNumber = firstNumber * scale;
                firstNumber = firstNumber + (double) intNumber;
                firstNumber = firstNumber / scale;
            } else { //увеличиваем целую часть
                firstNumber = firstNumber * 10.0 + intNumber;
            }

        }

    }


    String getStringResult() {
        //return String.format("%s%s", stringResult, sign);
        return String.format("%f%s", result, sign);
    }

    String getStringFirstNumber() {

        String stringFormat = String.format("%%.%df", quantityAfterComma);//отформатируем по количеству знаков после запятой


        return String.format(stringFormat, firstNumber);
    }
}
