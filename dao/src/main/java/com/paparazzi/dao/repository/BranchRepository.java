package com.paparazzi.dao.repository;

import com.paparazzi.domain.BranchEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for {@link BranchEntity}.
 * 
 * @author Artem Arapov
 *
 */
public interface BranchRepository extends CrudRepository<BranchEntity, Long>{

}
