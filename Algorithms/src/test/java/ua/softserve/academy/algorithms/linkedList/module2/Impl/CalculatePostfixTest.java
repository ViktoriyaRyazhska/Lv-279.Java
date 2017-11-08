package ua.softserve.academy.algorithms.linkedList.module2.Impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.algorithms.linkedList.module_2.Impl.CalculatePostfixImpl;
import ua.softserve.academy.algorithms.linkedList.module_2.Impl.InfixToPostfixImpl;

import java.util.List;

import static org.hamcrest.Matchers.is;

public class CalculatePostfixTest {
    CalculatePostfixImpl calculatePostfix;
    InfixToPostfixImpl infixToPostfix;
    @Before
    public void setUp(){
        calculatePostfix = new CalculatePostfixImpl();
        infixToPostfix = new InfixToPostfixImpl();
    }

    @Test
    public void calculationTest(){
        List<String> list = infixToPostfix.transfer("(25 + 5)*(23-8)+5+6*7");

        Assert.assertThat(calculatePostfix.calculate(list), is(497));
    }
}
