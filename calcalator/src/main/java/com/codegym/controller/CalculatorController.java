package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/calculate")
    public String calculate(ModelMap model, @RequestParam(name = "number1", defaultValue = "0") double number1, @RequestParam(name = "number2", defaultValue = "0") double number2, @RequestParam(name = "calculation", defaultValue = "") String calcul) {

        double result = 0;
        switch (calcul) {
            case "Addition(+)":
                result = number1 + number2;
                calcul = "Addition";
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                calcul = "Subtraction";
                break;
            case "Multiplication(X)":
                result = number1 * number2;
                calcul = "Multiplication";
                break;
            case "Division(/)":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    model.addAttribute("message", "wrong math !");
                }
                calcul = "Division";
                break;
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("calcul", calcul);
        model.addAttribute("result", result);
        return "index";
    }
}
