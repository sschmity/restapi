package com.clearstream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A bean that returns a message when you call the {@link #saySomething()} method.
 * <p/>
 * Uses <tt>@Component("myBean")</tt> to register this bean with the name <tt>myBean</tt>
 * that we use in the Camel route to lookup this bean.
 */
//@Component("myBean")
public class SampleBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleBean.class);

//    @Value("${greeting}")
    private String say;

    public SampleBean(String aSay) {
        say = aSay;
    }
    public SampleBean() {}

    public String saySomething() {
        LOGGER.info("Testing logger information");
        return say;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String aSay) {
        say = aSay;
    }
}