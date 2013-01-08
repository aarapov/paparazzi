package com.paparazzi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.paparazzi.dao.repository.BranchRepository;
import com.paparazzi.domain.BranchEntity;

/**
 * @author Artem Arapov
 *
 */
@Service("branchService")
@Transactional
@Repository
public class BranchServiceImpl implements BranchService {

    @Autowired
    protected BranchRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<BranchEntity> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    @Transactional
    public BranchEntity save(BranchEntity branch) {
        return repository.save(branch);
    }

    @Override
    @Transactional(readOnly = true)
    public BranchEntity findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public void delete(BranchEntity branch) {
        repository.delete(branch);
    }

}
