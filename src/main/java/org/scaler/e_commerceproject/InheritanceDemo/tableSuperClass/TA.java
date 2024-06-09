package org.scaler.e_commerceproject.InheritanceDemo.tableSuperClass;


import jakarta.persistence.Entity;
import lombok.Data;


@Data
@Entity(name="TPC_TA")
public class TA extends User {

    private int noOfSession;
    private double rating;

}
