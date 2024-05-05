package com.mayank.RatingApplication.entities;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="ratings")
public class Rating {

    @Id
    @SequenceGenerator(
            name = "rating_id",
            sequenceName = "rating_id"
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rating_id"
    )
    private Integer ratingId;

    private String userId;
    private String hotelId;
    private Integer rating;
    private String feedback;
}
