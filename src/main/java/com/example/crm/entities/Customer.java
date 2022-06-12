package com.example.crm.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name ="customer")

public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )


    private Long Id;
    private String firstName;
    private String lastName;
    private String email;

}
