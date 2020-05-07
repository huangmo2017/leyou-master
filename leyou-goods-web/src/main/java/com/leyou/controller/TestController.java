package com.leyou.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @description:
 * @author: huangdaming
 * @Date: 2020-05-07 11:17
 */
@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = "/sleep/one", produces = "application/json")
    public ResponseEntity<Long> sleepOne(String systemNo){
        logger.info("模拟业务处理1分钟，请求参数：{}", systemNo);
        Long serverTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < serverTime + (60 * 1000)){
            logger.info("正在处理业务，当前时间：{}，开始时间：{}", System.currentTimeMillis(), serverTime);
        }
        ResponseEntity<Long> resultEntity = ResponseEntity.ok(serverTime);
        logger.info("模拟业务处理1分钟，响应参数：{}", resultEntity);
        return resultEntity;
    }
}
