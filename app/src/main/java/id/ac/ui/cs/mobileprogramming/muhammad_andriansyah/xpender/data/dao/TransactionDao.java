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

@Dao
public interface TransactionDao {
    @Insert
    void insertTransaction(Transaction transaction);

    @Update
    void updateTransaction(Transaction transaction);

    @Delete
    void deleteTransaction(Transaction transaction);

    @Query("DELETE FROM transaction_table")
    void deleteAllTransactions();

    @Query("SELECT * FROM transaction_table")
    List<Transaction> getAllTransactions();

    @Query("SELECT * FROM transaction_table")
    LiveData<List<Transaction>> getAllTransactionsLiveData();

    @Query("SELECT * FROM transaction_table WHERE transactionId LIKE :id")
    Transaction getTransactionById(int id);

    @Query("SELECT * FROM transaction_table WHERE transactionDate > :date")
    LiveData<List<Transaction>> getTransactionByDate(int date);

//    @RawQuery(observedEntities = Expense.class)
//    LiveData<List<Expense>> queryFilterSort(SupportSQLiteQuery query);
}
