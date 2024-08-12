package com.example.Client.entity.Tour;

import com.example.Client.entity.Price.Price;
import com.example.Client.entity.departure.DepartureDate;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "tour")
public class Tour {
    @Id
    @Column(name = "Tour_Code")
    private String tourCode;

    @Column(name = "Tour_Name")
    private String tourName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Maximum_Size")
    private Integer maximumSize;


    @ManyToOne
    @JoinColumn(name = "Tour_Request_Id")
    private TourRequest tourRequest;

    @Column(name = "Img1")
    private String tourImg1;

    @Column(name = "Img2")
    private String tourImg2;

    @OneToOne(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private Price price;

    @OneToMany(mappedBy = "tour")
    private List<DepartureDate> departureDateList;
}
