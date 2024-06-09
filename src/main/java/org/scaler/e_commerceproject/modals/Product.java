package org.scaler.e_commerceproject.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModal {

    private String title;
    private double price;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn
    private Category category;
}
