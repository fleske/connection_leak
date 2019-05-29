package com.fleske.leak;

import java.math.BigInteger;

public class TestEntityDto {

    private BigInteger counter;
    private String name;
    private String last;

    public TestEntityDto() {
    }


    public TestEntityDto(BigInteger counter, String name, String last) {
        this.counter = counter;
        this.name = name;
        this.last = last;
    }

    public TestEntityDto(Long counter, String name, String last) {
        this.counter = new BigInteger(counter.toString());
        this.name = name;
        this.last = last;
    }

    public BigInteger getCounter() {
        return counter;
    }

    public void setCounter(BigInteger counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
