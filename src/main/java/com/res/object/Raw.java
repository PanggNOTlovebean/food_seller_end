package com.res.object;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate
public class Raw {
    @Id
    Integer id;
    String name;
    Float number;
    String unit;
    Float min;
    Float max;
}
