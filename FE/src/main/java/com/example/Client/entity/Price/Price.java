package com.example.Client.entity.Price;


import com.example.Client.Enum.ApprovalStatus;
import com.example.Client.entity.BaseEntity;
import com.example.Client.entity.Tour.Tour;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "price")
public class Price extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Price_Id")
    private Long priceId;

    @Column(name = "Approval_Status")
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    @OneToOne(mappedBy = "price", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PriceDetail priceDetail;

    @OneToOne(mappedBy = "price", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PriceApproval priceApproval;

    @OneToOne
    @JoinColumn(name = "Tour_Code", referencedColumnName = "Tour_Code")
    private Tour tour;
}
