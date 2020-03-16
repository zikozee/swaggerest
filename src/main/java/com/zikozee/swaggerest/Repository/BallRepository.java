package com.zikozee.swaggerest.Repository;

import com.zikozee.swaggerest.model.Ballers;
import org.springframework.data.repository.CrudRepository;

public interface BallRepository extends CrudRepository<Ballers, Integer> {
}
