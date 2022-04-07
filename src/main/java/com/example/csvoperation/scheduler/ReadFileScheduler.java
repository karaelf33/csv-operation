package com.example.csvoperation.scheduler;

import com.example.csvoperation.service.impl.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReadFileScheduler {


    FileServiceImpl fileServiceImpl;

    public ReadFileScheduler(FileServiceImpl fileServiceImpl) {
        this.fileServiceImpl = fileServiceImpl;
    }

    private static final Logger logger = LoggerFactory.getLogger(ReadFileScheduler.class);

    @Scheduled(cron = "0 * * * * *")
    public void getHeadValue() {
        logger.info("Created File {}",fileServiceImpl.createFile());
        logger.info("Read File: {}" , fileServiceImpl.readXLSFile());
    }

}
