package com.example.transactionl.models.view;
import java.util.Set;

public class UserFinancialInformationViewModel {

    private double income;
    private double expense;
    private Set<TransactionViewModel> receivedTransactions;
    private Set<TransactionViewModel> sentTransactions;

    public UserFinancialInformationViewModel() {
    }

    public double getIncome() {
        for (TransactionViewModel receivedTransaction : this.receivedTransactions) {
            this.income+=receivedTransaction.getAmount();
        }
        return income;
    }

    public UserFinancialInformationViewModel setIncome(double income) {
        this.income = income;
        return this;
    }

    public double getExpense() {
        for (TransactionViewModel sentTransaction : this.getSentTransactions()) {
            this.expense+=sentTransaction.getAmount();
        }
        return expense;
    }

    public UserFinancialInformationViewModel setExpense(double expense) {
        this.expense = expense;
        return this;
    }

    public Set<TransactionViewModel> getReceivedTransactions() {
        return receivedTransactions;
    }

    public UserFinancialInformationViewModel setReceivedTransactions(Set<TransactionViewModel> receivedTransactions) {
        this.receivedTransactions = receivedTransactions;
        return this;
    }

    public Set<TransactionViewModel> getSentTransactions() {
        return sentTransactions;
    }

    public UserFinancialInformationViewModel setSentTransactions(Set<TransactionViewModel> sentTransactions) {
        this.sentTransactions = sentTransactions;
        return this;
    }
}
