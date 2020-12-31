package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.dao.CategoryDao;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.dao.TransactionDao;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.dao.TransactionItemDao;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Category;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Transaction;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.TransactionItem;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.utility.Utils;

@Database(entities = {Transaction.class, TransactionItem.class, Category.class}, version = 1, exportSchema = false)
public abstract class XpenderRoomDatabase extends RoomDatabase {
    public abstract TransactionDao transactionDao();
    public abstract TransactionItemDao transactionItemDao();
    public abstract CategoryDao categoryDao();

    private static XpenderRoomDatabase INSTANCE;

    public static synchronized XpenderRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    XpenderRoomDatabase.class, "transaction_database")
                    .build();
        }
        return INSTANCE;
    }

    private static XpenderRoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CategoryDao categoryDao;

        private PopulateDbAsyncTask(XpenderRoomDatabase db){
            this.categoryDao = db.categoryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Category> recommendedCategories = Utils.getDefaultCategories();
            for(Category category : recommendedCategories){
                categoryDao.insertCategory(category);
            }

            return null;
        }
    }
}
