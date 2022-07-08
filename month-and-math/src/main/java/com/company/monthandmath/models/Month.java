package com.company.monthandmath.models;

import java.util.Objects;

public class Month {

    int number;
    String name;

    public Month(int number, String monthName) {
        this.number = number;
        this.name = monthName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMonthName() {
        return name;
    }

    public void setMonthName(String monthName) {
        this.name = monthName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Objects.equals(number, month.number) && Objects.equals(name, month.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        return "Month{" +
                "number='" + number + '\'' +
                ", monthName='" + name + '\'' +
                '}';
    }
}
