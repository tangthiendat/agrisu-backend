package com.ttdat.agrisubackend.repository;

import com.ttdat.agrisubackend.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {

}
