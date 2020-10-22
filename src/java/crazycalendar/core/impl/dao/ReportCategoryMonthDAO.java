/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core.impl.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import crazycalendar.domain.Category;
import crazycalendar.domain.DomainEntity;
import crazycalendar.domain.Month;
import crazycalendar.domain.ReportCategoryDaily;
import crazycalendar.domain.ReportCategoryMonth;
import crazycalendar.domain.ReportValueMonth;

/**
 *
 * @author Luiz
 */
public class ReportCategoryMonthDAO extends AbstractJdbcDAO{
     public ReportCategoryMonthDAO()
    {
        super("tb_report","id");
    }
    
    public void save(DomainEntity entity)
    {
        
    }
    
    public DomainEntity view (DomainEntity entity)
    {
       return null;
    }
    
    public List<DomainEntity> consult (DomainEntity entity)
    {
        
        PreparedStatement pst =null;
        String sql = null;
        ReportCategoryMonth rp = (ReportCategoryMonth)entity;
        ResultSet reset;
        ReportCategoryMonth report = new ReportCategoryMonth();
        ReportCategoryDaily reportDay = new ReportCategoryDaily();
        List<Month> monthes = new ArrayList<>();
        try
        {
            openConnection();
            Category category;
            List<Category> innercategory = new ArrayList<>();
            
            sql = "SELECT id,name FROM tb_category";
            pst = connection.prepareStatement(sql);
            reset  = pst.executeQuery();
            List<Category> categories = new ArrayList<>();
            List<DomainEntity> entities = new ArrayList<>();
            report.initMonths();
            monthes = report.getMonths();
            while(reset.next())
            {
                category = new Category();
                category.setName(reset.getString("name"));
                category.setId(reset.getInt("id"));
                category.setValue(0);
                categories.add(category);
            }
            
            
            sql = null;
            pst = null;
            for (int i = 1; i <= 12; i++) {
                sql = " SELECT catego.id,"
                        + "catego.name AS category,"
                        + "product.name,SUM(prod_ord.quantity) AS quantity,"
                        + "month(orde.dt_reg) AS month FROM (tb_prod_ord AS prod_ord) "
                        + "INNER JOIN (tb_order AS orde) ON orde.id = prod_ord.id_order "
                        + "INNER JOIN(tb_product AS product) ON prod_ord.id_product = product.id  "
                        + "INNER JOIN(tb_category AS catego) ON product.id_category = catego.id "
                        + "WHERE month(orde.dt_reg) = ? GROUP BY (category) ORDER BY catego.id ;";

            pst = connection.prepareStatement(sql);
            pst.setInt(1,i );
            reset  = pst.executeQuery();
            
            
            innercategory = new ArrayList<>();
            for(Category ct : categories)
            {
                category = new Category();
                category.setName(ct.getName());
                category.setValue(0);
                innercategory.add(category);
            }
            
             
            while(reset.next())
            {
                category = new Category();
                category = innercategory.get(reset.getInt("catego.id") -1);
                category.setValue(reset.getInt("quantity"));
                innercategory.set(reset.getInt("catego.id") -1 , category);
            }
            report.getMonths().get(i-1).setCategories(innercategory);
            
            sql=null;
            pst=null;
        }
                               
        report.setMonths(monthes);
        
        report.setContent("Vendas por categoria x mes");
        
        entities.add(report);
            
        sql =null;
        pst=null;
        
        
        sql = "SELECT catego.id,catego.name AS category,product.name,SUM(prod_ord.quantity) AS quantity FROM (tb_prod_ord AS prod_ord) "
                + "INNER JOIN (tb_order AS orde) ON orde.id = prod_ord.id_order INNER JOIN(tb_product AS product) ON prod_ord.id_product = product.id  "
                + "INNER JOIN(tb_category AS catego) ON product.id_category = catego.id WHERE orde.dt_reg = CURDATE() "
                + "GROUP BY (category) ORDER BY catego.id";
            pst = connection.prepareStatement(sql);
            reset  = pst.executeQuery();
            List<Category> categoriesDaily = new ArrayList<>();
            
            for(Category cat : categories)
            {
                Category cato = new Category();
                cato.setName(cat.getName());
                cato.setValue(0);
                categoriesDaily.add(cato);
            }
            
            
            while(reset.next())
            {
                category = new Category();
                category = categoriesDaily.get(reset.getInt("catego.id") -1);
                category.setValue(reset.getInt("quantity"));
                categoriesDaily.set(reset.getInt("catego.id") -1, category);
            }
            reportDay.setCategories(categoriesDaily);
            reportDay.setName("Venda por categoria Hoje!");
            
            
            
            entities.add(reportDay);
            
            
                    
            sql = null;
            pst = null;
            sql = "SELECT id,name FROM tb_category";
            pst = connection.prepareStatement(sql);
            reset  = pst.executeQuery();
            categories = new ArrayList<>();
            ReportValueMonth valRep = new ReportValueMonth();
            valRep.initMonths();
            monthes = valRep.getMonths();
            while(reset.next())
            {
                category = new Category();
                category.setName(reset.getString("name"));
                category.setId(reset.getInt("id"));
                category.setValue(0);
                categories.add(category);
            }
            
            
            sql = null;
            pst = null;
            for (int i = 1; i <= 12; i++) {
                sql = " SELECT catego.id,"
                        + "catego.name AS category,"
                        + "product.name,SUM(prod_ord.price) AS value,"
                        + "month(orde.dt_reg) AS month FROM (tb_prod_ord AS prod_ord) "
                        + "INNER JOIN (tb_order AS orde) ON orde.id = prod_ord.id_order "
                        + "INNER JOIN(tb_product AS product) ON prod_ord.id_product = product.id  "
                        + "INNER JOIN(tb_category AS catego) ON product.id_category = catego.id "
                        + "WHERE month(orde.dt_reg) = ? GROUP BY (category) ORDER BY catego.id ;";

            pst = connection.prepareStatement(sql);
            pst.setInt(1,i );
            reset  = pst.executeQuery();
            
            
            innercategory = new ArrayList<>();
            for(Category ct : categories)
            {
                category = new Category();
                category.setName(ct.getName());
                category.setPrice(0);
                innercategory.add(category);
            }
            
             
            while(reset.next())
            {
                category = new Category();
                category = innercategory.get(reset.getInt("catego.id") -1);
                category.setPrice(reset.getDouble("value"));
                innercategory.set(reset.getInt("catego.id") -1 , category);
            }
            valRep.getMonths().get(i-1).setCategories(innercategory);
            
            sql=null;
            pst=null;
        }
                               
        valRep.setMonths(monthes);
            
            entities.add(valRep); 
            
        
            return entities;
            
            
            
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    public void change(DomainEntity entity)
    {
        
    }
}
