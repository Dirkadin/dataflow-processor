package com.dirk.spring.dataflowprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableBinding({Processor.class})
public class DataflowProcessorApplication {

    Logger logger = LoggerFactory.getLogger(DataflowProcessorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DataflowProcessorApplication.class, args);
    }

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public List<TheData> addDiscountToProduct(List<TheData> datas) {
        List<TheData> updatedData = new ArrayList<>();
        for (TheData data : datas) {
            logger.info("Before discount: {}", data.getPrice());
            data.setPrice(data.getPrice() / 2);
            logger.info("After discount: {}", data.getPrice());
            updatedData.add(data);
        }
        return  updatedData;
    }

}