package com.example.reviewandratings.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Review {

    //guys jo attributes yaha hy same to same restaurant and menu wale mey hy
    @Id
    private Long reviewId;
    private String userEmail;
    private String restaurantId;
    private String comment;
    private int rating;
    private Date timeStamp;
}
