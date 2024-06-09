package org.scaler.e_commerceproject.InheritanceDemo.JoinedTable;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "jt_instructor")
@Data
public class Instructor extends User{

    private String specialization;

}
