package com.example.calculator.MathController;

import com.example.calculator.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/math")
public class MathController {
    @RequestMapping(value = "/sum/{num1}/{num2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "num1") String num1,
                      @PathVariable(value = "num2") String num2) throws Exception {
        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("The given number is not numeric");
        }
        return toDouble(num1) + toDouble(num2);
    }

    @RequestMapping(value = "/sub/{num1}/{num2}", method = RequestMethod.GET)
    public Double sub(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("The given number is not numeric");
        }
        return toDouble(num1) - toDouble(num2);
    }

    @RequestMapping(value = "/mul/{num1}/{num2}", method = RequestMethod.GET)
    public Double mul(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("The given number is not numeric");
        }
        return toDouble(num1) * toDouble(num2);
    }

    @RequestMapping(value = "/div/{num1}/{num2}", method = RequestMethod.GET)
    public Double div(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("The given number is not numeric");
        }
        return toDouble(num1) / toDouble(num2);
    }

    @RequestMapping(value = "/pow/{num1}/{num2}", method = RequestMethod.GET)
    public Double pow(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("The given number is not numeric");
        }
        return Math.pow(toDouble(num1), toDouble(num2));
    }

    private boolean isNumeric(String strNum){
        if(strNum == null){
            return false;
        }
        String num = strNum.replaceAll(",", ".");
        return num.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double toDouble(String strNum){
        if(strNum == null){
            return 0D;
        }
        String num = strNum.replaceAll(",", ".");
        return Double.parseDouble(num);
    }
}
