package org.scaler.e_commerceproject.InheritanceDemo.JoinedTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name="jt_TA")
@Data

public class TA extends User{

    private int noOfSession;
    private double rating;

}
