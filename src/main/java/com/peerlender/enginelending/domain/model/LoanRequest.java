package com.peerlender.enginelending.domain.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;
import java.util.Objects;


public final class LoanRequest {
    private long id;
    private int amount;
    private LoanUser borrower;
    private Duration repaymentTerm;
    private double interestRate;

    public LoanRequest() {
    }

    public LoanRequest(int amount, LoanUser borrower, Duration repaymentTerm, double interestRate) {
        this.amount = amount;
        this.borrower = borrower;
        this.repaymentTerm = repaymentTerm;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public LoanUser getBorrower() {
        return borrower;
    }

    public Duration getRepaymentTerm() {
        return repaymentTerm;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanRequest that = (LoanRequest) o;
        return amount == that.amount &&
                Double.compare(that.interestRate, interestRate) == 0 &&
                Objects.equals(borrower, that.borrower) &&
                Objects.equals(repaymentTerm, that.repaymentTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrower, repaymentTerm, interestRate);
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrower=" + borrower +
                ", repaymentTerm=" + repaymentTerm +
                ", interestRate=" + interestRate +
                '}';
    }
}
