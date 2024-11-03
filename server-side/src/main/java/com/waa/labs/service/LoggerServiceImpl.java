package com.waa.labs.service;

import com.waa.labs.entity.Logger;
import com.waa.labs.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoggerServiceImpl implements LoggerService {
    private final LoggerRepository loggerRepository;
    private static final String FAKE_USER = "staticUser"; // Define a fake static user

    @Autowired
    public LoggerServiceImpl(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    @Override
    public void logOperation(String operation) {
        Logger logEntry = new Logger(LocalDateTime.now(), FAKE_USER, operation);
        loggerRepository.save(logEntry);
    }
}
