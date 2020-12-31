package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.repository.XpenderRepository;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Transaction;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.TransactionItem;

public class TransactionItemViewModel extends AndroidViewModel {
    private XpenderRepository xpenderRepository;
    private LiveData<List<TransactionItem>> transactionItems;
    private LiveData<List<Transaction>> transactions;

    private static Transaction volatileTransaction;

    public TransactionItemViewModel(@NonNull Application application) {
        super(application);
        xpenderRepository = XpenderRepository.getInstance(application);
        transactionItems = xpenderRepository.getAllTransactionItemsLiveData();
        transactions = xpenderRepository.getAllTransactionsLiveData();
        volatileTransaction = null;
    }

    public LiveData<List<TransactionItem>> getTransactionItems(){ return transactionItems; }

    public LiveData<List<Transaction>> getTransactions() { return transactions; }

    public void addTransactionItemToVolatileTransaction(String expenseName, String itemName, String price, int expenseId, int category, long date){
        if(tempExpense == null){
            int dateAsInt = DateUtils.longDateToInt(date);
            tempExpense = new Expense.Builder(expenseId, category).name(expenseName).date(dateAsInt).build();
        }

        Item item = new Item(itemName, Double.parseDouble(price));
        tempExpense.addItem(item);
    }

    public void removeItemFromTemp(Item item) {
        if(tempExpense != null){
            tempExpense.removeItem(item);
        }
    }

    public void saveTempToStorage(){
        repository.insertExpense(tempExpense);

        for(Item item : tempExpense.getItems()){
            repository.insertItem(item);
        }

        tempExpense = null;
    }

    public void deleteExpense(Expense expense){
        repository.deleteExpense(expense);
    }

    public void addExpense(Expense expense){
        repository.insertExpense(expense);
    }

    public List<Item> getTempItems(){
        return tempExpense.getItems();
    }

    public Expense getTempExpense(){
        return tempExpense;
    }

    public void updateExpense(Expense expense){
        repository.updateExpense(expense);
    }

    public Repository getRepository(){
        return repository;
    }
}
