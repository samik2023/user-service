package com.inventory.management.demo.repository;

import com.inventory.management.demo.entity.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRecord, Long> {

}
