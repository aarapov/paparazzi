package com.paparazzi.services.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.paparazzi.services.BranchService;


/**
 * Test cases for {@link BranchService}.
 * 
 * @author Artem Arapov
 *
 */
@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "/spring/service.xml", "classpath*:/spring/dao.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class BranchServiceTest {

    @Autowired
    private BranchService service;
    
    @Test
    public void testFindAll() {
        assertNotNull(service);
        assertFalse(service.findAll().isEmpty());
    }
}
