package com.stewarthutchins.scalatest.experementation;

public class MixedSampleJavaClass {

    @Override
    public String toString() {
        return "This String has come from: " + this.getClass().getName();
    }

}
