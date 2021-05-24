package com.accenture.coffee.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.accenture.coffee.config.DbConstants.COLUMN_NAME_DRINK_IDENTIFIER;
import static com.accenture.coffee.config.DbConstants.COLUMN_NAME_SIZE_IDENTIFIER;
import static com.accenture.coffee.config.DbConstants.COLUMN_NAME_USER_IDENTIFIER;
import static com.accenture.coffee.config.DbConstants.TABLE_NAME_ORDERS_IDENTIFIER;

/** The Orders Entity class
 * @author rahuljsr88@gmail.com
 */


@Entity
@Table(name = TABLE_NAME_ORDERS_IDENTIFIER)
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = COLUMN_NAME_USER_IDENTIFIER)
    private String user;

    @Column(name = COLUMN_NAME_DRINK_IDENTIFIER)
    private String drink;

    @Column(name = COLUMN_NAME_SIZE_IDENTIFIER)
    private String size;

    private Double orderBill;
}
