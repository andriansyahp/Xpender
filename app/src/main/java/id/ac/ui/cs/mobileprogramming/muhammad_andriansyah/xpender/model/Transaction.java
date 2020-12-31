package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;

@Entity(tableName = "transaction_table")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int transactionId;

    @NonNull
    private String transactionTitle;

    private String transactionPlace;

    @NonNull
    private String transactionDate;

    private String transactionDescription;

    private double transactionPriceAmount;

    @NonNull
    private ArrayList<TransactionItem> transactionItems;

    public Transaction(@NonNull String transactionTitle, String transactionPlace, @NonNull String transactionDate, String transactionDescription, double transactionPriceAmount, @NonNull ArrayList<TransactionItem> transactionItems) {
        this.transactionTitle = transactionTitle;
        this.transactionPlace = transactionPlace;
        this.transactionDate = transactionDate;
        this.transactionDescription = transactionDescription;
        this.transactionPriceAmount = transactionPriceAmount;
        this.transactionItems = transactionItems;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @NonNull
    public String getTransactionTitle() {
        return transactionTitle;
    }

    public void setTransactionTitle(@NonNull String transactionTitle) {
        this.transactionTitle = transactionTitle;
    }

    public String getTransactionPlace() {
        return transactionPlace;
    }

    public void setTransactionPlace(String transactionPlace) {
        this.transactionPlace = transactionPlace;
    }

    @NonNull
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(@NonNull String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public double getTransactionPriceAmount() {
        return transactionPriceAmount;
    }

    public void setTransactionPriceAmount(double transactionPriceAmount) {
        this.transactionPriceAmount = transactionPriceAmount;
    }

    @NonNull
    public ArrayList<TransactionItem> getTransactionItems() {
        return transactionItems;
    }

    public void setTransactionItems(@NonNull ArrayList<TransactionItem> transactionItems) {
        this.transactionItems = transactionItems;
    }
}
