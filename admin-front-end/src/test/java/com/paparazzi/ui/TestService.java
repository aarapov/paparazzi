package com.paparazzi.ui;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.paparazzi.services.api.BranchService;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "/spring/ui.xml", "classpath*:/spring/service.xml", "classpath*:/spring/dao.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestService {

    @Autowired
    private BranchService service;

    @Test
    public void testService() {
        Assert.assertNotNull(service);
    }
}
