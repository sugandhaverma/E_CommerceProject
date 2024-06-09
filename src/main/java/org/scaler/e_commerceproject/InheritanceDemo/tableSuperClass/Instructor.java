package org.scaler.e_commerceproject.InheritanceDemo.tableSuperClass;


import jakarta.persistence.Entity;
import lombok.Data;


@Data
@Entity(name="TPC_INSTRUCTOR")
public class Instructor extends User {

    private String specialization;
    
}
