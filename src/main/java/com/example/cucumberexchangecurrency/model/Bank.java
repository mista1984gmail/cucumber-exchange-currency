package com.example.cucumberexchangecurrency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "bank_bank_rate",
            joinColumns = { @JoinColumn(name = "bank_id") },
            inverseJoinColumns = { @JoinColumn(name = "bank_rate_id") }
    )
    Set<BankRate> bankRates;

/*    public Bank(String name, Set<BankRate> bankRates) {
        this.name = name;
        this.bankRates = bankRates;
    }*/
}
