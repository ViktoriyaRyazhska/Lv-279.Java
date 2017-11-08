package ua.softserve.academy.algorithms.linkedList.module2.Impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.algorithms.linkedList.module_2.Impl.InfixToPostfixImpl;

import java.util.List;

import static org.hamcrest.Matchers.is;

public class InfixToPostfixImplTest {
    InfixToPostfixImpl infixToPostfix;

    @Before
    public void setUp(){
        infixToPostfix = new InfixToPostfixImpl();
    }

    @Test
    public void transferTest(){
        List<String> list = infixToPostfix.transfer("(25 + 6) * 5 + 7 * 6");
        Assert.assertThat(list.get(list.size() - 1), is("+"));
        Assert.assertThat(list.get(list.size() - 2), is("*"));
        Assert.assertThat(list.get(list.size() - 3), is("6"));
    }
}
