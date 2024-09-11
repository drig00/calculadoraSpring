package com.calculadoraSimples.operacoesBasicas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
	@GetMapping("/")
	public String Calculator() {
		return "index";
	}
	
	 @PostMapping("/calculate")
	    public String calculate(
	            @RequestParam("num1") double num1,
	            @RequestParam("num2") double num2,
	            @RequestParam("operation") String operation,
	            Model model) {
		double result = 0.0;
		switch(operation) {
			case "somar":
				result = num1+num2;
				break;
				
			case "subtrair":
				result = num1-num2;
				break;
				
			case "multiplicar":
				result = num1*num2;
				break;
				
			case "dividir":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    model.addAttribute("error", "Não é possível dividir por zero!");
                    return "index";
                }
                break;
				
			default:
				model.addAttribute("error","operação inválida");
				return "index";
					
		}
		
		model.addAttribute("result", result);
		return "index";

	}

}
