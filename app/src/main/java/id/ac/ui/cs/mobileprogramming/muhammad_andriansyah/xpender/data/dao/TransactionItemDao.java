package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Transaction;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.TransactionItem;

@Dao
public interface TransactionItemDao {
    @Insert
    void insertTransactionItem(TransactionItem transactionItem);

    @Update
    void updateTransactionItem(TransactionItem transactionItem);

    @Delete
    void deleteTransactionItem(TransactionItem transactionItem);

    @Query("SELECT * FROM transaction_item_table WHERE associatedTransactionId LIKE :transactionId")
    LiveData<List<TransactionItem>> getTransactionItemsByTransactionId(int transactionId);

    @Query("DELETE FROM transaction_item_table WHERE associatedTransactionId LIKE :transactionId")
    void deleteTransactionByTransactionId(int transactionId);

    @Query("DELETE FROM transaction_item_table WHERE itemId LIKE :itemId")
    void deleteTransactionItemByItemId(int itemId);

    @Query("DELETE FROM transaction_item_table")
    void deleteAllTransactionItems();

    @Query("SELECT * FROM transaction_item_table")
    List<TransactionItem> getAllTransactionItems();

    @Query("SELECT * FROM transaction_item_table")
    LiveData<List<TransactionItem>> getAllTransactionItemsLiveData();
}
