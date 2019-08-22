package com.example.demo.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by zhenglongfei on 2019/7/24
 *
 * @VERSION 1.0
 */
@Component
@Slf4j
public class DynamicJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {


        switch (shardingContext.getShardingItem()) {
            case 0:
                log.info("【0】 is running");
                break;
            case 1:
                log.info("【1】 is running");
                break;
        }
    }
}
