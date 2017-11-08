package ua.softserve.academy.algorithms.linkedList.module2.Impl;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.algorithms.linkedList.module_2.Impl.StackImpl;
import ua.softserve.academy.algorithms.linkedList.module_2.Stack;

public class StackTest {
    Stack<Integer> stack;
    @Before
    public void setUp(){
        stack = new StackImpl<Integer>();
    }

    @Test
    public void pushTestInt(){
        stack.push(5);
        Assert.assertThat(5, Matchers.is(stack.pop()));
    }

    @Test
    public void peakTestString(){
        Stack<String> stack = new StackImpl<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        Assert.assertThat("C", Matchers.is(stack.peak()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void peakTestNull(){
        Assert.assertThat("C", Matchers.is(stack.peak()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void popTest_exception_expected(){
        Assert.assertThat(5, Matchers.is(stack.pop()));
    }

    @Test
    public void containsTest(){
        stack.push(5);
        Assert.assertThat(true, Matchers.is(stack.contains(5)));
    }

    @Test
    public void containsTest5Elements(){
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(7);
        stack.push(7);


        Assert.assertThat(false, Matchers.is(stack.contains(8)));
    }

    @Test
    public void containsTest_empty_list(){
        Assert.assertThat(false, Matchers.is(stack.contains(5)));
    }

    @Test
    public void popTest(){
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        Assert.assertThat(6, Matchers.is(stack.pop()));
    }

    @Test
    public void sizeTest(){
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);

        Assert.assertThat(4, Matchers.is(stack.size()));
    }

    @Test
    public void sizeTest_after_pop(){
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.pop();

        Assert.assertThat(3, Matchers.is(stack.size()));
    }

    @Test
    public void toStringTest(){
        Stack<String> stack = new StackImpl<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        Assert.assertThat("Stack: {{C}{B}{A}}", Matchers.is(stack.toString()));
    }
}
