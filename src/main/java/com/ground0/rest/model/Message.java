package com.ground0.rest.model;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by zer0 on 4/2/17.
 */

@Entity
@Table(name = "strings")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)
    Long id;

    @Column(name = "value")
    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
