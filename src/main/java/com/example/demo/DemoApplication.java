package com.example.demo;

import com.cxytiandi.elasticjob.annotation.EnableElasticJob;
import com.cxytiandi.elasticjob.dynamic.bean.Job;
import com.cxytiandi.elasticjob.dynamic.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableElasticJob
@ComponentScan(basePackages = {"com.cxytiandi", "com.example.demo"})
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private JobService jobService;

    @Override
    public void run(String... args) throws Exception {
        Job job1 = new Job();
        job1.setJobName("job1");
        job1.setCron("0/10 * * * * ? ");
        job1.setJobType("SIMPLE");
        job1.setJobClass("com.example.demo.job.DynamicJob");
        job1.setShardingItemParameters("");
        job1.setShardingTotalCount(2);
        jobService.addJob(job1);
        Job job2 = new Job();
        job2.setJobName("job2");
        job2.setCron("0/10 * * * * ? ");
        job2.setJobType("SIMPLE");
        job2.setJobClass("com.example.demo.job.DynamicJob");
        job2.setShardingItemParameters("0=A,1=B");
        job2.setShardingTotalCount(2);
        jobService.addJob(job2);
    }
}
