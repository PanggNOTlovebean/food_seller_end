package com.res.object;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@DynamicUpdate
@Data
public class OrderPaid {
    @Id
    String id;
    Integer price;
    Timestamp date;
}
