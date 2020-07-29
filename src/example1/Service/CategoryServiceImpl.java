package example1.Service;

import example1.Dao.ICategory;
import example1.Entity.Category;

import java.util.List;


public class CategoryServiceImpl implements CategoryService {

    ICategory iCategory;
    @Override
    public List<Category> list() {
        return iCategory.list();
    }
}
