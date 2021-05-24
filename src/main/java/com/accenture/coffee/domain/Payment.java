package com.accenture.coffee.domain;

import com.accenture.coffee.config.DbConstants;
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

import static com.accenture.coffee.config.DbConstants.COLUMN_NAME_AMOUNT_IDENTIFIER;
import static com.accenture.coffee.config.DbConstants.COLUMN_NAME_USER_IDENTIFIER;
import static com.accenture.coffee.config.DbConstants.TABLE_NAME_PAYMENTS_IDENTIFIER;

/** The Payments Entity class
 * @author rahuljsr88@gmail.com
 */


@Entity
@Table(name = TABLE_NAME_PAYMENTS_IDENTIFIER)
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = COLUMN_NAME_USER_IDENTIFIER)
    private String user;

    @Column(name = COLUMN_NAME_AMOUNT_IDENTIFIER)
    private Double amount;
}

