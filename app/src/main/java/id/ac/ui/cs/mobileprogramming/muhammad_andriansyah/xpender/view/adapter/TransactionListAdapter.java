package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.view.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.TransactionViewHolder;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Transaction;

public class TransactionListAdapter extends ListAdapter<Transaction, TransactionViewHolder> {
    public TransactionListAdapter(@NonNull DiffUtil.ItemCallback<Transaction> diffCallback) {
        super(diffCallback);
    }

    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TransactionViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(TransactionViewHolder holder, int position) {
        Transaction current = getItem(position);
        holder.bind(current.getTransactionTitle());
    }

    static class TransactionDiff extends DiffUtil.ItemCallback<Transaction> {

        @Override
        public boolean areItemsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Transaction oldItem, @NonNull Transaction newItem) {
            return oldItem.getTransactionTitle().equals(newItem.getTransactionTitle());
        }
    }
}
