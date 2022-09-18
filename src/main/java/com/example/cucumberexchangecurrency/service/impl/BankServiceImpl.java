package com.example.cucumberexchangecurrency.service.impl;

import com.example.cucumberexchangecurrency.repository.BankRepository;
import com.example.cucumberexchangecurrency.service.BankService;
import com.example.cucumberexchangecurrency.service.dto.BankDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BankDto> findAll() {
        log.info("Find all bank");
        return bankRepository.findAll().stream()
                .map(bank -> modelMapper.map(bank, BankDto.class))
                .collect(toList());
    }
}
