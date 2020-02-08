package com.hacking.pratice;

import com.google.common.collect.ImmutableMap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class PostfixNotationCalculator {

    private static final Map<String, DoubleBinaryOperator> operationsMap = initiateOperationsMapping();

    public double calculate(String expression){
        expression = expression.trim().replace(" ","");
        ArrayDeque<Double> operands = new ArrayDeque<>();
        Arrays.stream(expression.split(""))
                .forEach(s -> {
                    final DoubleBinaryOperator operation = operationsMap.get(s);
                    if(operation != null){
                        final Double result = operation.applyAsDouble(operands.pop(), operands.pop());
                        operands.push(result);

                    }else {
                        operands.push(Double.valueOf(s));
                    }
                });
        return operands.peek();
    }

    private static Map<String, DoubleBinaryOperator> initiateOperationsMapping(){
        return ImmutableMap.<String, DoubleBinaryOperator>builder()
                .put("+", (a,b) -> b + a)
                .put("-", (a,b) -> b - a)
                .put("*", (a,b) -> b * a)
                .put("/", (a,b) -> b / a)
                .build();
    }
}
