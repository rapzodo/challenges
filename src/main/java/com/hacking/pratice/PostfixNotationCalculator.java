package com.hacking.pratice;

import com.sun.javadoc.Doclet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class PostfixNotationCalculator {

    private Map<String, BiFunction<Double, Double, Double>> operationsMap;

    public PostfixNotationCalculator() {
        initiateOperationsMapping();
    }

    public double calculate(String expression){
        expression = expression.trim().replace(" ","");
        Stack<Double> operands = new Stack<>();
        Arrays.stream(expression.split(""))
                .forEach(s -> {
                    final BiFunction<Double, Double, Double> operation = operationsMap.get(s);
                    if(operation != null){
                        final Double result = operation.apply(operands.pop(), operands.pop());
                        operands.push(result);

                    }else {
                        operands.push(Double.valueOf(s));
                    }
                });
        return operands.peek();
    }

    public void initiateOperationsMapping(){
        operationsMap = new HashMap<>();
        operationsMap.put("+", (a,b) -> b + a);
        operationsMap.put("-", (a,b) -> b - a);
        operationsMap.put("*", (a,b) -> b * a);
        operationsMap.put("/", (a,b) -> b / a);
    }
}
