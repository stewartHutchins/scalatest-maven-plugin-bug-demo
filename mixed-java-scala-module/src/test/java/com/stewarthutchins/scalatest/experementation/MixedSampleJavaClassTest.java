package com.stewarthutchins.scalatest.experementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MixedSampleJavaClassTest {

    @Test
    void test() {
        MixedSampleJavaClass mySampleClass = new MixedSampleJavaClass();
        String toString = mySampleClass.toString();

        assertTrue(toString.contains("MixedSampleJavaClass"));
    }

}
