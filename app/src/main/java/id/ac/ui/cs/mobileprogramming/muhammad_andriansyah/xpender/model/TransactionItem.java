package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Category;

@Entity(tableName = "transaction_item_table")
public class TransactionItem {
    @PrimaryKey(autoGenerate = true)
    private int itemId;

    @NonNull
    private String itemName;

    @NonNull
    private double itemPrice;

    @NonNull
    private Category itemCategory;

    @NonNull
    private int associatedTransactionId;

    public TransactionItem(@NonNull String itemName, @NonNull float itemPrice, @NonNull Category itemCategory, @NonNull int associatedTransactionId) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
        this.associatedTransactionId = associatedTransactionId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @NonNull
    public String getItemName() {
        return itemName;
    }

    public void setItemName(@NonNull String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    @NonNull
    public Category getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(@NonNull Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getAssociatedTransactionId() {
        return associatedTransactionId;
    }

    public void setAssociatedTransactionId(int associatedTransactionId) {
        this.associatedTransactionId = associatedTransactionId;
    }
}
