/*
 ==============================================================
 == Date:           6/21/2011 
 == Programmer:     Joshua Stacy 
 == Program:        Tape_Calculator
 == Class Name:     Evaluate
 == Purpose:        This class contains methods for calculating
 == values.
 ==============================================================
 ==               _____
 ==      ________//__{\_____
 ==     /_(O)___//___/__(O)_/
 */
package ten.pkg;
//import necessary packages
import java.math.*;
import javax.swing.*;

public class Evaluate {

    public static BigDecimal num1, num2, num3, result;
    public static int activeTape;

    public static String Evaluate(String numStr1, String numStr2, char op) {
        activeTape = Main.GUI.getActiveTape();
        try {
            num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
            num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
            switch (op) {
                case '+':
                    result = num1.add(num2, Main.CFG.GetDefaultMath());
                    break;
                case '-':
                    result = num1.subtract(num2, Main.CFG.GetDefaultMath());
                    break;
                case '*':
                    result = num1.multiply(num2, Main.CFG.GetDefaultMath());
                    break;
                case '/':
                    if (num2.equals(BigDecimal.ZERO)) {
                        ErrorMessages.DivideByZero();
                        numStr2 = "0";
                        Main.VAR.SetNumStr2(numStr2);
                        Main.VAR.SetLogicState(activeTape, 2);
                        return "";
                    }
                    result = num1.divide(num2, Main.CFG.GetDefaultMath());
                    break;
            }
            return String.valueOf(result);
        } catch (ArithmeticException e) {
            ErrorMessages.GeneralError();
            return "";
        } catch (NumberFormatException e) {
            ErrorMessages.InvalidNumber();
            Main.VAR.SetNumStr1("0");
            Main.VAR.SetNum1("0.0");
            return "";
        } catch (Exception e) {
            ErrorMessages.GeneralError();
            return "";
        }
    }

    public static String Evaluate(String numStr1, String numStr2, String numStr3, char op, char op2) {
        try {
            num1 = new BigDecimal(numStr1, Main.CFG.GetDefaultMath());
            num2 = new BigDecimal(numStr2, Main.CFG.GetDefaultMath());
            num3 = new BigDecimal(numStr3, Main.CFG.GetDefaultMath());
            if (op == '+') {
                switch (op2) {
                    case '+':
                        result = num1.add(num2, Main.CFG.GetDefaultMath());
                        result = result.add(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '-':
                        result = num1.add(num2, Main.CFG.GetDefaultMath());
                        result = result.subtract(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '*':
                        result = num2.multiply(num3, Main.CFG.GetDefaultMath());
                        result = num1.add(result, Main.CFG.GetDefaultMath());
                        break;
                    case '/':
                        if (num3.equals(BigDecimal.ZERO)) {
                            ErrorMessages.DivideByZero();
                            numStr3 = "0";
                            Main.VAR.SetNumStr3(numStr3);
                            Main.VAR.SetLogicState(activeTape, 5);
                            return "";
                        }
                        result = num2.divide(num3, Main.CFG.GetDefaultMath());
                        result = num1.add(result, Main.CFG.GetDefaultMath());
                        break;
                }
            } else if (op == '-') {
                switch (op2) {
                    case '+':
                        result = num1.subtract(num2, Main.CFG.GetDefaultMath());
                        result = result.add(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '-':
                        result = num1.subtract(num2, Main.CFG.GetDefaultMath());
                        result = result.subtract(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '*':
                        result = num2.multiply(num3, Main.CFG.GetDefaultMath());
                        result = num1.subtract(result, Main.CFG.GetDefaultMath());
                        break;
                    case '/':
                        if (num3.equals(BigDecimal.ZERO)) {
                            ErrorMessages.DivideByZero();
                            numStr3 = "0";
                            Main.VAR.SetNumStr3(numStr3);
                            Main.VAR.SetLogicState(activeTape, 5);
                            return "";
                        }
                        result = num2.divide(num3, Main.CFG.GetDefaultMath());
                        result = num1.subtract(result, Main.CFG.GetDefaultMath());
                        break;
                }
            } else if (op == '*') {
                switch (op2) {
                    case '+':
                        result = num1.multiply(num2, Main.CFG.GetDefaultMath());
                        result = result.add(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '-':
                        result = num1.multiply(num2, Main.CFG.GetDefaultMath());
                        result = result.subtract(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '*':
                        result = num1.multiply(num2, Main.CFG.GetDefaultMath());
                        result = result.multiply(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '/':
                        if (num3.equals(BigDecimal.ZERO)) {
                            ErrorMessages.DivideByZero();
                            numStr3 = "0";
                            Main.VAR.SetNumStr3(numStr3);
                            Main.VAR.SetLogicState(activeTape, 5);
                            return "";
                        }
                        result = num1.multiply(num2, Main.CFG.GetDefaultMath());
                        result = result.divide(num3, Main.CFG.GetDefaultMath());
                        break;
                }
            } else if (op == '/') {
                switch (op2) {
                    case '+':
                        if (num2.equals(BigDecimal.ZERO)) {
                            ErrorMessages.DivideByZero();
                            numStr2 = "0";
                            numStr3 = "0";
                            Main.VAR.SetNumStr2(numStr2);
                            Main.VAR.SetNumStr3(numStr3);
                            Main.VAR.SetLogicState(activeTape, 2);
                            return "";
                        }
                        result = num1.divide(num2, Main.CFG.GetDefaultMath());
                        result = result.add(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '-':
                        if (num2.equals(BigDecimal.ZERO)) {
                            ErrorMessages.DivideByZero();
                            numStr2 = "0";
                            numStr3 = "0";
                            Main.VAR.SetNumStr2(numStr2);
                            Main.VAR.SetNumStr3(numStr3);
                            Main.VAR.SetLogicState(activeTape, 2);
                            return "";
                        }
                        result = num1.divide(num2, Main.CFG.GetDefaultMath());
                        result = result.subtract(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '*':
                        if (num2.equals(BigDecimal.ZERO)) {
                            ErrorMessages.DivideByZero();
                            numStr2 = "0";
                            numStr3 = "0";
                            Main.VAR.SetNumStr2(numStr2);
                            Main.VAR.SetNumStr3(numStr3);
                            Main.VAR.SetLogicState(activeTape, 2);
                            return "";
                        }
                        result = num1.divide(num2, Main.CFG.GetDefaultMath());
                        result = result.multiply(num3, Main.CFG.GetDefaultMath());
                        break;
                    case '/':
                        if (num2.equals(BigDecimal.ZERO)) {
                            ErrorMessages.DivideByZero();
                            numStr2 = "0";
                            numStr3 = "0";
                            Main.VAR.SetNumStr2(numStr2);
                            Main.VAR.SetNumStr3(numStr3);
                            Main.VAR.SetLogicState(activeTape, 2);
                            return "";
                        }
                        result = num1.divide(num2, Main.CFG.GetDefaultMath());
                        if (num3.equals(BigDecimal.ZERO)) {
                            ErrorMessages.DivideByZero();
                            numStr3 = "0";
                            Main.VAR.SetNumStr3(numStr3);
                            Main.VAR.SetLogicState(activeTape, 5);
                            return "";
                        }
                        result = result.divide(num3, Main.CFG.GetDefaultMath());
                        break;
                }
            }
            return String.valueOf(result);
        } catch (ArithmeticException e) {
            ErrorMessages.GeneralError();
            return "";
        } catch (NumberFormatException e) {
            ErrorMessages.InvalidNumber();
            Main.VAR.SetNumStr1("0");
            Main.VAR.SetNum1("0.0");
            return "";
        } catch (Exception e) {
            ErrorMessages.GeneralError();
            return "";
        }
    }

    public static String Trim(int decimalPlaces, String inputString) {
        int index = 0;
        index = inputString.lastIndexOf(".");
        if (index > 0 && inputString.length() > (index + decimalPlaces)) {
            inputString = inputString.substring(0, (index + decimalPlaces + 1));
        }
        return inputString;
    }

    public static String DecimalPlaces(int decimalPlaces, String input) {
        BigDecimal inputNum, exponent, output;
        BigDecimal half = new BigDecimal(".5");
        BigInteger integerNum;
        double inputDouble = Double.parseDouble(input);
        String outputStr, compare, tail;

        tail = "no";//if (input.contains)
        inputNum = new BigDecimal(input);
        //TestMessages.VoidMessage(inputNum.toString());
        exponent = BigDecimal.TEN.pow(decimalPlaces + 1);
        output = inputNum.multiply(exponent);
        if (inputDouble < 0) {
            output = output.subtract(half);
        } else {
            output = output.add(half);
        }
        integerNum = output.toBigInteger();
        output = new BigDecimal(integerNum.toString());
        output = output.divide(exponent, Main.CFG.GetConfigurationMath(Main.VAR.GetOpLogic(activeTape)));
        //return output.toEngineeringString();
        outputStr = output.toString();

        if (outputStr.contains(".")) {
            if (outputStr.contains("E")) {
                tail = outputStr.substring(outputStr.indexOf("E"));
                outputStr = outputStr.substring(0, outputStr.indexOf("E"));
            }
            for (int i = outputStr.length(); i >= outputStr.indexOf("."); i--) {
                compare = outputStr.substring(i - 1, i);
                if (compare.equals("0")) {
                    outputStr = outputStr.substring(0, i - 1);
                } else if (compare.equals(".")) {
                    outputStr = outputStr.substring(0, i - 1);
                    break;
                } else {
                    break;
                }
            }
        }
        
        if (tail.equals("no") == false) {
            outputStr+=tail;
        }
        return outputStr;
    }

    public static String Engineering(BigDecimal input) {
        int exponent = 0;
        double inputDouble = input.doubleValue();
        String outputString = "";
        if (input.compareTo(BigDecimal.ZERO) == 1) {
            while (inputDouble >= 10) {
                inputDouble /= 10;
                exponent++;
            }
        } else {
            while (inputDouble <= -10) {
                inputDouble /= 10;
                exponent++;
            }
        }
        outputString = Double.toString(inputDouble);
        return outputString;
    }

    public static BigDecimal nRoot(int n, BigDecimal number) {
        double num = number.doubleValue();
        double epsilon = .00000000000000000001;
        int ctr = 0;
        double root = 1;
        if (n <= 0) {
            return number;
        }
        if (num < 0 && n % 2 == 0) {
            ErrorMessages.RootOfNegativeNumber();
            return BigDecimal.ZERO;
        }
        if (num == 0) {
            return BigDecimal.ZERO;
        }
        while ((Math.abs(Math.pow(root, n) - num) > epsilon) && (ctr++ < 1000)) {
            root = ((1.0 / n) * (((n - 1.0) * root) + (num / Math.pow(root, n - 1.0))));
            number = new BigDecimal(Double.toString(root), Main.CFG.GetDefaultMath());
        }
        return number;
    }

    public static String xyPower(String powerStr, String numberStr) {
        BigDecimal power = new BigDecimal(powerStr, Main.CFG.GetDefaultMath());
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        BigDecimal powerResult = BigDecimal.ONE;
        String powerResultStr;
        boolean negative = false;
        BigDecimal maximum = new BigDecimal("9999");
        BigDecimal minimum = new BigDecimal("-9999");
        int compare = power.compareTo(minimum);

        if (power.compareTo(maximum) == 1) {
            ErrorMessages.MaximumPower();
            return "0";
        } else if (power.compareTo(minimum) == -1) {
            ErrorMessages.MaximumPower();
            return "0";
        }

        if (power.compareTo(BigDecimal.ZERO) < 0) {
            power = power.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
            negative = true;
        }
        int wholePower = power.intValue();
        int divisorInt = 0;
        int denominatorPower = 1;
        BigDecimal denominator;
        BigDecimal fractalResult = BigDecimal.ONE;
        BigDecimal bigDecWholePower = new BigDecimal(wholePower, Main.CFG.GetDefaultMath());
        BigDecimal remainingPower = power.subtract(bigDecWholePower);
        String fractalPower = remainingPower.toString();

        //Evaluate Whole Powers
        for (int i = 0; i < wholePower; i++) {
            powerResult = powerResult.multiply(number);
        }

        //Fractal Powers
        if (remainingPower.compareTo(BigDecimal.ZERO) != 0) {
            for (int i = 2; i < fractalPower.length(); i++) {
                remainingPower = remainingPower.multiply(BigDecimal.TEN);
                divisorInt = i - 1;
            }

            for (int j = 0; j < divisorInt; j++) {
                denominatorPower = denominatorPower * 10;
            }

            denominator = nRoot(denominatorPower, number);

            for (int i = 0; i < remainingPower.intValue(); i++) {
                fractalResult = fractalResult.multiply(denominator);
            }

            powerResult = powerResult.multiply(fractalResult);
        }

        //Negative Powers
        if (negative == true) {
            powerResult = BigDecimal.ONE.divide(powerResult, Main.CFG.GetDefaultMath());
        }

        //Return Results
        powerResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (powerResult.toString()));
        return powerResultStr;
    }

    public static String xyRoot(String rootStr, String numberStr) {
        BigDecimal root = new BigDecimal(rootStr, Main.CFG.GetDefaultMath());
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        BigDecimal rootResult = BigDecimal.ONE;
        String rootResultStr;
        boolean negative = false;

        if (root.compareTo(BigDecimal.ZERO) < 0) {
            root = root.multiply(BigDecimal.valueOf(-1), Main.CFG.GetDefaultMath());
            negative = true;
        }

        int wholeRoot = root.intValue();
        BigDecimal bigDecWholeRoot = new BigDecimal(wholeRoot, Main.CFG.GetDefaultMath());

        //Evaluate Whole Roots
        if (bigDecWholeRoot.compareTo(root) == 0) {
            rootResult = nRoot(wholeRoot, number);
            return rootResult.toString();
        } //Fractal Roots
        else {
            BigDecimal rootReciprocal = BigDecimal.ONE.divide(root, Main.CFG.GetDefaultMath());
            String rootReciprocalStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), rootReciprocal.toString());
            rootResultStr = Evaluate.xyPower(rootReciprocalStr, numberStr);
            rootResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), rootResultStr);
            rootResult = new BigDecimal(rootResultStr, Main.CFG.GetDefaultMath());
        }

        //Negative Powers
        if (negative == true) {
            rootResult = BigDecimal.ONE.divide(rootResult, Main.CFG.GetDefaultMath());
        }

        //Return Results
        rootResultStr = rootResult.toString();
        return rootResultStr;
    }

    public static String Log(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        double numberDouble = number.doubleValue();
        double resultDouble = Math.log10(numberDouble);
        BigDecimal logResult = new BigDecimal(resultDouble);
        String logResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (logResult.toString()));
        return logResultStr;
    }

    public static String NaturalLog(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        double numberDouble = number.doubleValue();
        double resultDouble = Math.log(numberDouble);
        BigDecimal logResult = new BigDecimal(resultDouble);
        String logResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (logResult.toString()));
        return logResultStr;
    }

    public static String Sine(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        double numberDouble = number.doubleValue();
        double resultDouble = Math.sin(numberDouble);
        BigDecimal logResult = new BigDecimal(resultDouble);
        String logResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (logResult.toString()));
        return logResultStr;
    }

    public static String Cosine(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        double numberDouble = number.doubleValue();
        double resultDouble = Math.cos(numberDouble);
        BigDecimal logResult = new BigDecimal(resultDouble);
        String logResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (logResult.toString()));
        return logResultStr;
    }

    public static String Tangent(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        double numberDouble = number.doubleValue();
        double resultDouble = Math.tan(numberDouble);
        BigDecimal logResult = new BigDecimal(resultDouble);
        String logResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (logResult.toString()));
        return logResultStr;
    }

    public static String ArcSine(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        double numberDouble = number.doubleValue();
        double resultDouble = Math.asin(numberDouble);
        BigDecimal logResult = new BigDecimal(resultDouble);
        String logResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (logResult.toString()));
        return logResultStr;
    }

    public static String ArcCosine(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        double numberDouble = number.doubleValue();
        double resultDouble = Math.acos(numberDouble);
        BigDecimal logResult = new BigDecimal(resultDouble);
        String logResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (logResult.toString()));
        return logResultStr;
    }

    public static String ArcTangent(String numberStr) {
        BigDecimal number = new BigDecimal(numberStr, Main.CFG.GetDefaultMath());
        double numberDouble = number.doubleValue();
        double resultDouble = Math.atan(numberDouble);
        BigDecimal logResult = new BigDecimal(resultDouble);
        String logResultStr = Evaluate.DecimalPlaces(Main.CFG.GetDecimalPlaces(1), (logResult.toString()));
        return logResultStr;
    }
}
