package com.yf.xxlJobTask;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleJobHandler {

    @XxlJob("sampleJobHandler")
    public void execute() throws Exception {
        log.info("first xxl-job excute");
    }
}