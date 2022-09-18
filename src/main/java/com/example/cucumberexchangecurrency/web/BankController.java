package com.example.cucumberexchangecurrency.web;

import com.example.cucumberexchangecurrency.model.Bank;
import com.example.cucumberexchangecurrency.service.BankService;
import com.example.cucumberexchangecurrency.service.dto.BankDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/banks")
public class BankController {
    private final BankService bankService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BankDto> findAll() {
        return bankService.findAll();
    }
}
