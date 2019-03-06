package com.res.object;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@DynamicUpdate
@Data
public class OrderDetailPaid {
    @Id
    String id;
    String name;
    Integer price;
    Timestamp time;
    @Column(name="order_id")
    String orderId;
}
