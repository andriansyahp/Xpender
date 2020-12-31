package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TransactionViewHolder extends RecyclerView.ViewHolder {
    private final TextView transactionsItemView;

    private TransactionViewHolder(View itemView) {
        super(itemView);
        transactionsItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        transactionsItemView.setText(text);
    }

    public static TransactionViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new TransactionViewHolder(view);
    }
}
