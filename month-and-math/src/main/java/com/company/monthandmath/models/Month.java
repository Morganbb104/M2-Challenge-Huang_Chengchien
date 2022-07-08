package com.company.monthandmath.models;

import java.util.Objects;

public class Month {

    String number;
    String monthName;

    public Month(String number, String monthName) {
        this.number = number;
        this.monthName = monthName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Objects.equals(number, month.number) && Objects.equals(monthName, month.monthName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, monthName);
    }

    @Override
    public String toString() {
        return "Month{" +
                "number='" + number + '\'' +
                ", monthName='" + monthName + '\'' +
                '}';
    }
}
