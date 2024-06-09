package org.scaler.e_commerceproject.modals;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModal {

    private String title;

}
