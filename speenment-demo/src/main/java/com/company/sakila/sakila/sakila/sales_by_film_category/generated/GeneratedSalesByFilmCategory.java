package com.company.sakila.sakila.sakila.sales_by_film_category.generated;

import com.company.sakila.sakila.sakila.sales_by_film_category.SalesByFilmCategory;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.enterprise.datastore.runtime.field.DatastoreFields;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ComparableField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * The generated base for the {@link
 * com.company.sakila.sakila.sakila.sales_by_film_category.SalesByFilmCategory}-interface
 * representing entities of the {@code sales_by_film_category}-table in the
 * database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedSalesByFilmCategory {
    
    /**
     * This Field corresponds to the {@link SalesByFilmCategory} field that can
     * be obtained using the {@link SalesByFilmCategory#getCategory()} method.
     */
    StringField<SalesByFilmCategory, String> CATEGORY = DatastoreFields.createStringField(
        Identifier.CATEGORY,
        SalesByFilmCategory::getCategory,
        SalesByFilmCategory::setCategory,
        TypeMapper.identity(),
        false
    );
    /**
     * This Field corresponds to the {@link SalesByFilmCategory} field that can
     * be obtained using the {@link SalesByFilmCategory#getTotalSales()} method.
     */
    ComparableField<SalesByFilmCategory, BigDecimal, BigDecimal> TOTAL_SALES = DatastoreFields.createComparableField(
        Identifier.TOTAL_SALES,
        o -> OptionalUtil.unwrap(o.getTotalSales()),
        SalesByFilmCategory::setTotalSales,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the category of this SalesByFilmCategory. The category field
     * corresponds to the database column
     * sakila.sakila.sales_by_film_category.category.
     * 
     * @return the category of this SalesByFilmCategory
     */
    String getCategory();
    
    /**
     * Returns the totalSales of this SalesByFilmCategory. The totalSales field
     * corresponds to the database column
     * sakila.sakila.sales_by_film_category.total_sales.
     * 
     * @return the totalSales of this SalesByFilmCategory
     */
    Optional<BigDecimal> getTotalSales();
    
    /**
     * Sets the category of this SalesByFilmCategory. The category field
     * corresponds to the database column
     * sakila.sakila.sales_by_film_category.category.
     * 
     * @param category to set of this SalesByFilmCategory
     * @return         this SalesByFilmCategory instance
     */
    SalesByFilmCategory setCategory(String category);
    
    /**
     * Sets the totalSales of this SalesByFilmCategory. The totalSales field
     * corresponds to the database column
     * sakila.sakila.sales_by_film_category.total_sales.
     * 
     * @param totalSales to set of this SalesByFilmCategory
     * @return           this SalesByFilmCategory instance
     */
    SalesByFilmCategory setTotalSales(BigDecimal totalSales);
    
    enum Identifier implements ColumnIdentifier<SalesByFilmCategory> {
        
        CATEGORY    ("category"),
        TOTAL_SALES ("total_sales");
        
        private final String columnId;
        private final TableIdentifier<SalesByFilmCategory> tableIdentifier;
        
        Identifier(String columnId) {
            this.columnId        = columnId;
            this.tableIdentifier = TableIdentifier.of(    getDbmsId(), 
                getSchemaId(), 
                getTableId());
        }
        
        @Override
        public String getDbmsId() {
            return "sakila";
        }
        
        @Override
        public String getSchemaId() {
            return "sakila";
        }
        
        @Override
        public String getTableId() {
            return "sales_by_film_category";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<SalesByFilmCategory> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}