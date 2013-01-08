package com.paparazzi.services;

import java.util.List;

import com.paparazzi.domain.BranchEntity;

/**
 * Service api for Brunch.
 * 
 * @author Artem Arapov
 *
 */
public interface BranchService {

    public List<BranchEntity> findAll();
    public BranchEntity save(BranchEntity branch);
    public BranchEntity findOne(Long id);
    public void delete(BranchEntity branch);
}
