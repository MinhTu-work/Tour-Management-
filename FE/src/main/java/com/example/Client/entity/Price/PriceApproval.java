package com.example.Client.entity.Price;

import com.example.Client.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "price_approval")
public class PriceApproval extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Approval_Price_Id")
    private Long approvalPriceId;

    @Column(name = "Create_Date")
    private Date createDate;

    @OneToOne
    @JoinColumn(name = "Price_Id")
    private Price price;

}
