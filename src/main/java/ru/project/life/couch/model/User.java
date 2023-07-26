package ru.project.life.couch.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(name = "describe_service")
    private String describeService;

    @JoinColumn(name = "product_id")
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Product products;
}
