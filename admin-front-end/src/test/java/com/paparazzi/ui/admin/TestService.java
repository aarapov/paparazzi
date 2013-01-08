package com.paparazzi.ui.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.paparazzi.services.BranchService;


@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "/spring/admin.xml", "classpath*:/spring/service.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestService {

    @Autowired
    private BranchService branchService;
    
    @Test
    public void testService() {
        
    }
}
