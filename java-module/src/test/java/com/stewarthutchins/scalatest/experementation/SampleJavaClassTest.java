package com.stewarthutchins.scalatest.experementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SampleJavaClassTest {

    @Test
    void test() {
        SampleJavaClass mySampleClass = new SampleJavaClass();
        String toString = mySampleClass.toString();

        assertTrue(toString.contains("SampleJavaClass"));
    }

}
