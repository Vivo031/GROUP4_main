package com.main.psoos.model;

import com.main.psoos.dto.OrderDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "price")
    private double price;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "jo_id")
    private String joId;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "status")
    private String status;

    @Lob
    @Column(name = "barcode")
    byte[] barcode;

    @Column(name = "order_status")
    String orderStatus;
    @Column(name = "worker")
    String worker;
    @Column(name = "worker_notes")
    String workerNotes;
    @Column(name = "expected_finish_date")
    private String finishDate;


    public Order(OrderDTO order){
        //this.id = order.getOrderId();
        this.customerId = order.getCustomerId();
        this.joId = order.getJoId();
        this.status = order.getStatus();
        this.totalPrice = order.getTotalPrice();
        this.barcode = order.getBarcode();
        this.worker = order.getWorker();
        this.workerNotes = order.getWorkerNotes();
        this.orderStatus = order.getOrderStatus();
        this.finishDate = (order.getFinishDate() == null) ? "" : order.getFinishDate().toString();
    }
}