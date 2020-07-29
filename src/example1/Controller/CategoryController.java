package example1.Controller;


import example1.Service.CategoryService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import example1.Entity.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

class CategoryController {

    CategoryService categoryService;

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        Category category = new Category();

        /**
         * add
         */
       /* category.setId(4);
        category.setName("新增的category4");
        session.insert("addCategory",category);*/
        /**
         * delete
         */
        /*category.setId(4);
        session.delete("deleteCategory",category);*/
        /**
         * update
         */
        Category c= session.selectOne("getCategory",4);
        c.setName("修改了的Category名称2020");
        session.update("updateCategory",c);
        listAll(session);

        session.commit();
        session.close();
    }

    private static void listAll(SqlSession session) {

        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getId()+":"+c.getName());
        }
    }

}
