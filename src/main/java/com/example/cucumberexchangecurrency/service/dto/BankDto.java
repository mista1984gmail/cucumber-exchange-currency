package com.example.cucumberexchangecurrency.service.dto;

import com.example.cucumberexchangecurrency.model.BankRate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
public class BankDto {

    private Long id;
    @NotBlank
    private String name;
    private Set<BankRate> bankRates;


}
