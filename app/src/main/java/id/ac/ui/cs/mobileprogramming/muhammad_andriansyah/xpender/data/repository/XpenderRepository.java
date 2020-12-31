package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.dao.CategoryDao;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.dao.TransactionDao;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.dao.TransactionItemDao;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.database.XpenderRoomDatabase;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Category;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Transaction;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.TransactionItem;

public class XpenderRepository {
    private static XpenderRepository INSTANCE;

    private TransactionDao transactionDao;
    private TransactionItemDao transactionItemDao;
    private CategoryDao categoryDao;

    private LiveData<List<Transaction>> allTransactions;
    private LiveData<List<TransactionItem>> allTransactionItems;

    public XpenderRepository(Application application) {
        XpenderRoomDatabase db = XpenderRoomDatabase.getDatabase(application);
        transactionDao = db.transactionDao();
        transactionItemDao = db.transactionItemDao();
        categoryDao = db.categoryDao();

        allTransactions = transactionDao.getAllTransactionsLiveData();
        allTransactionItems = transactionItemDao.getAllTransactionItemsLiveData();
    }

    public static XpenderRepository getInstance(Application app){
        if(INSTANCE == null){
            INSTANCE = new XpenderRepository(app);
        }
        return INSTANCE;
    }

    /*
    Public APIs to access the DB from the ViewModel.
    Only the ViewModel should hold a reference to the Repository!
    The ViewModel should access the DB only trough these APIs
     */

    public void insertTransaction(Transaction transaction){
        new InsertTransactionAsyncTask(transactionDao).execute(transaction);
    }

    public void updateTransaction(Transaction transaction){
        new UpdateTransactionAsyncTask(transactionDao).execute(transaction);
    }

    public void deleteTransaction(Transaction transaction){
        new DeleteTransactionItemsByTransactionIdAsyncTask(transactionItemDao).execute(transaction.getTransactionId());
        new DeleteTransactionAsyncTask(transactionDao).execute(transaction);
    }

    public LiveData<List<Transaction>> getAllTransactionsLiveData(){
        return allTransactions;
    }

    public List<Transaction> getAllTransactions(){ return transactionDao.getAllTransactions(); }

    //Items

    public void insertTransactionItem(TransactionItem transactionItem){
        new InsertTransactionItemAsyncTask(transactionItemDao).execute(transactionItem);
    }

    public LiveData<List<TransactionItem>> getAllTransactionItemsLiveData(){
        return allTransactionItems;
    }

    public List<TransactionItem> getAllTransactionItems() { return transactionItemDao.getAllTransactionItems(); }

    //Categories

    public List<Category> getAllCategories() {
        try {
            return new GetAllCategoriesAsyncTask(categoryDao).execute().get();
        }catch (ExecutionException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return null;
    }

    /*
    Static AsyncTaskClasses to be added here. Their purpose is to access the DB on
    a background thread and execute the above mentioned queries. Please make sure to add
    them in the same order as the methods above are added.
     */


    /*
    AsyncTasks for the Expense Class:
     */

    private static class InsertTransactionAsyncTask extends AsyncTask<Transaction, Void, Void> {
        private TransactionDao transactionDao;

        InsertTransactionAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.insertTransaction(transactions[0]);
            return null;
        }
    }

    private static class UpdateTransactionAsyncTask extends AsyncTask <Transaction, Void, Void> {
        private TransactionDao transactionDao;

        UpdateTransactionAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.updateTransaction(transactions[0]);
            return null;
        }
    }

    private static class DeleteTransactionAsyncTask extends AsyncTask <Transaction, Void, Void> {
        private TransactionDao transactionDao;

        DeleteTransactionAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.deleteTransaction(transactions[0]);
            return null;
        }
    }


    /*
    AsyncTasks for the Item class:
     */

    private static class InsertTransactionItemAsyncTask extends AsyncTask <TransactionItem, Void, Void> {
        private TransactionItemDao transactionItemDao;

        InsertTransactionItemAsyncTask(TransactionItemDao transactionItemDao) {
            this.transactionItemDao = transactionItemDao;
        }

        @Override
        protected Void doInBackground(TransactionItem... transactionItems) {
            transactionItemDao.insertTransactionItem(transactionItems[0]);
            return null;
        }
    }

    private static class DeleteTransactionItemsByTransactionIdAsyncTask extends AsyncTask<Integer, Void, Void>{
        private TransactionItemDao transactionItemDao;

        DeleteTransactionItemsByTransactionIdAsyncTask(TransactionItemDao transactionItemDao) {
            this.transactionItemDao = transactionItemDao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            transactionItemDao.deleteTransactionByTransactionId(integers[0]);
            return null;
        }
    }

    private static class DeleteTransactionItemAsyncTask extends AsyncTask<TransactionItem, Void, Void>{
        private TransactionItemDao transactionItemDao;

        DeleteTransactionItemAsyncTask(TransactionItemDao transactionItemDao) {
            this.transactionItemDao = transactionItemDao;
        }

        @Override
        protected Void doInBackground(TransactionItem... transactionItems) {
            transactionItemDao.deleteTransactionItem(transactionItems[0]);
            return null;
        }
    }

    //Categories

    private static class GetAllCategoriesAsyncTask extends AsyncTask<Void, Void, List<Category>>{
        private CategoryDao categoryDao;

        GetAllCategoriesAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected List<Category> doInBackground(Void... voids) {
            return categoryDao.getAllCategories();
        }
    }

    private static class GetCategoryByIdAsyncTask extends AsyncTask<Integer, Void, Category>{
        private CategoryDao categoryDao;

        GetCategoryByIdAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Category doInBackground(Integer... integers) {
            return categoryDao.getCategoryById(integers[0]);
        }
    }
}
