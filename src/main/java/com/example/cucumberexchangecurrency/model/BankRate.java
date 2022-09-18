package com.example.cucumberexchangecurrency.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_rate")
public class BankRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="time_bank_rate")
    private LocalDateTime timeBankRate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="currency_pair")
    private PairCurrency pairCurrency;

    @Column(name="rate")
    private Double rate;

    public BankRate(LocalDateTime timeBankRate, PairCurrency pairCurrency, Double rate) {
        this.timeBankRate = timeBankRate;
        this.pairCurrency = pairCurrency;
        this.rate = rate;
    }
}
