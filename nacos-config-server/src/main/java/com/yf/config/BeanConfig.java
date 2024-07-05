package com.yf.config;
import com.yzzg.TestBean1;
import com.yzzg.TestBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: BeanConfig
 ** @author: yangfeng
 ** @date: 2024/6/26 15:45
 ** @version: 1.0.0
 *********************************************************/
@Configuration
public class BeanConfig {
    @Bean
    public TestBean1 testBean1(){
        return new TestBean1();
    }
    @Bean
    public TestBean2 testBean2(){
        return new TestBean2();
    }

}
