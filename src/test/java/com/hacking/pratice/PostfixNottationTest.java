package com.hacking.pratice;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostfixNottationTest {

    private PostfixNotationCalculator postfixNotationCalculator = new PostfixNotationCalculator();

    @Test
    public void shouldSum(){
        String input = "43+";
        assertThat(postfixNotationCalculator.calculate(input)).isEqualTo(7);
    }

    @Test
    public void shouldMultiply() {
        String input = "43*";
        assertThat(postfixNotationCalculator.calculate(input)).isEqualTo(12);
    }

    @Test
    public void shouldDivide() {
        String input = "42/";
        assertThat(postfixNotationCalculator.calculate(input)).isEqualTo(2);
    }

    @Test
    public void shouldSubtract(){
        String input = "43-";
        assertThat(postfixNotationCalculator.calculate(input)).isEqualTo(1);
    }

    @Test
    public void shouldSubtractAndReturnNegative(){
        String input = "34-";
        assertThat(postfixNotationCalculator.calculate(input)).isEqualTo(-1);
    }

    @Test
    public void shouldSumMultipleOperands() {
        String input = "343++";
        assertThat(postfixNotationCalculator.calculate(input)).isEqualTo(10);
    }

    @Test
    public void shouldPerformMultipleOperations() {
        String input = "4572+-*";
        assertThat(postfixNotationCalculator.calculate(input)).isEqualTo(-16);
        assertThat(postfixNotationCalculator.calculate("34+2*7/")).isEqualTo(2);
        assertThat(postfixNotationCalculator.calculate("5 7 + 6 2 -  *")).isEqualTo(48);
        assertThat(postfixNotationCalculator.calculate("4 2 3 5 1 - + * +")).isEqualTo(18);
        assertThat(postfixNotationCalculator.calculate("4 2 + 3 5 1 -  * +")).isEqualTo(18);
    }
}
