package com.example.ecommerce.dao;

import com.example.ecommerce.modules.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons, Long> {

}
