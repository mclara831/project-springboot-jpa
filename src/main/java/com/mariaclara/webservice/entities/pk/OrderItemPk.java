package com.mariaclara.webservice.entities.pk;

import java.io.Serializable;

import com.mariaclara.webservice.entities.Order;
import com.mariaclara.webservice.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class OrderItemPk implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
}
