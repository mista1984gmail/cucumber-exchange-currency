package com.example.cucumberexchangecurrency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "bank_rate_id")
    private BankRate bankRate;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name="amount")
    private Double amount;

    @Column(name="code")
    private String code;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="trade_action")
    private TradeAction tradeAction;

    public Order(BankRate bankRate, Customer customer, Double amount, String code, TradeAction tradeAction) {
        this.bankRate = bankRate;
        this.customer = customer;
        this.amount = amount;
        this.code = code;
        this.tradeAction = tradeAction;
    }
}
