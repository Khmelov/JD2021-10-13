package by.it.karpovich.jd02_04.examples;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void testGetVar() {
        assertEquals("Ошибка в Parser.GetVar", -123, Parser.GetVar("-123"));
    }

    @Test
    public void testGetVar2() {
        assertEquals("Ошибка в Parser.GetVar", 123, Parser.GetVar("123"));
    }
}