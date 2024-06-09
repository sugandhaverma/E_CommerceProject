package org.scaler.e_commerceproject.InheritanceDemo.SingleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity(name="St_instructor")

@DiscriminatorValue(value = "1")
public class Instructor extends User {


    private String specialization;
    
}
