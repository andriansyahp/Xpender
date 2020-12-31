package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.repository.XpenderRepository;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Transaction;

public class TransactionViewModel extends AndroidViewModel {
    private XpenderRepository xpenderRepository;
    private LiveData<List<Transaction>> transanctions;

    public TransactionViewModel (Application application) {
        super(application);
        mRepository = new XpenderRepository(application);
        mAllTransactions = mRepository.getTransactions();
    }

    LiveData<List<Transaction>> getTransactions() { return mAllTransactions; }

    public void insert(Transaction transaction) { mRepository.insert(transaction); }
}
