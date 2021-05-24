package com.accenture.coffee.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import java.util.Map;

import static com.accenture.coffee.config.DbConstants.COLUMN_NAME_COST_IDENTIFIER;
import static com.accenture.coffee.config.DbConstants.COLUMN_NAME_DRINK_NAME_IDENTIFIER;
import static com.accenture.coffee.config.DbConstants.COLUMN_NAME_QUANTITY_IDENTIFIER;
import static com.accenture.coffee.config.DbConstants.TABLE_NAME_PRODUCTS_IDENTIFIER;

/** The Products Entity class
 * @author rahuljsr88@gmail.com
 */

@Entity
@Table(name = TABLE_NAME_PRODUCTS_IDENTIFIER)
@Getter
@Setter
public class Product {

    @Id
    @Column(name = COLUMN_NAME_DRINK_NAME_IDENTIFIER)
    private String drink_name;

    @ElementCollection
    @MapKeyColumn(name  = COLUMN_NAME_QUANTITY_IDENTIFIER)
    @Column(name = COLUMN_NAME_COST_IDENTIFIER)
    private Map<String, Double> prices;

}
