package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.utility;

import android.app.Application;

import java.util.ArrayList;

import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.R;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.XpenderApp;
import id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender.model.Category;

public class Utils {
    private static ArrayList<Category> categories = new ArrayList<>();

    private static String[] defaultCategories = {
            (XpenderApp.getContext().getString(R.string.cat_food)),
            (XpenderApp.getContext().getString(R.string.cat_healthcare)),
            (XpenderApp.getContext().getString(R.string.cat_households)),
            (XpenderApp.getContext().getString(R.string.cat_housing)),
            (XpenderApp.getContext().getString(R.string.cat_insurance)),
            (XpenderApp.getContext().getString(R.string.cat_personal)),
            (XpenderApp.getContext().getString(R.string.cat_savings)),
            (XpenderApp.getContext().getString(R.string.cat_transportation)),
            (XpenderApp.getContext().getString(R.string.cat_utilities)),
            (XpenderApp.getContext().getString(R.string.cat_others))
    };

    public static ArrayList<Category> getDefaultCategories(){
        ArrayList<Category> recommendedCategories = new ArrayList<>();

        for(int i = 0; i < defaultCategories.length; i++){
            recommendedCategories.add(new Category(defaultCategories[i]));
        }

        return recommendedCategories;
    }

//    public static void initCategories(Application app){
//        Repository repository = Repository.getInstance(app);
//        rootCategories = repository.getCategories();
//        List<Subcategory> subcategories = repository.getSubcategories();
//
//        for(Category c : rootCategories){
//            subCategories.put(c, new ArrayList<>());
//            for(Subcategory s : subcategories){
//                if(s.getCategoryId() == c.getId() - 1){
//                    subCategories.get(c).add(s);
//                }
//            }
//        }
//    }

}
