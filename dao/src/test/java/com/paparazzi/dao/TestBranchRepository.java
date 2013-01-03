package com.paparazzi.dao;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.paparazzi.dao.repository.BranchRepository;

@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "/spring/dao.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBranchRepository {

    @Autowired
    private BranchRepository repository;

    @Test
    public void testRepository() {
        assertNotNull(repository);
        assertFalse(repository.count() == 0);
    }
}
