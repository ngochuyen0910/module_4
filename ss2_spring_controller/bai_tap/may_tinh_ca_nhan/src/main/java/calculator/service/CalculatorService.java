package calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String result(String number1, String number2, String calculator) {
        try {
            double num = Double.parseDouble(number1);
            double num1 = Double.parseDouble(number2);
            double result = 0;
            switch (calculator) {
                case "Addition":
                    result = num + num1;
                    break;
                case "Subtraction":
                    result = num - num1;
                    break;
                case "Multiplication":
                    result = num * num1;
                    break;
                case "Division":
                    if (num1 == 0) {
                        return "Khong chia duoc";
                    }
                    result = num / num1;
                    break;
            }
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Khong duoc nhap chu";
        }
    }
}
