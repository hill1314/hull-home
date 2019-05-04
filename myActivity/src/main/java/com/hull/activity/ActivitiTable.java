package com.hull.activity;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

/**
 *
 *
 * @author
 * @create 2019-04-29 21:10
 **/

public class ActivitiTable {

    /**
     * 创建Activiti流的相关的数据库表
     */
    @Test
    public void creatTable(){
        ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
                .buildProcessEngine();
    }

}
