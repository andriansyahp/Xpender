package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Category;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Transaction;

@Dao
public interface CategoryDao {
    @Insert
    void insertCategory(Category category);

    @Update
    void updateCategory(Category category);

    @Delete
    void deleteCategory(Category category);

    @Query("SELECT * FROM category_table")
    List<Category> getAllCategories();

    @Query("SELECT * FROM category_table WHERE categoryId LIKE :id")
    Category getCategoryById(int id);
}
