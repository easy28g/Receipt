package com.example.ecommerce.dao;

import com.example.ecommerce.modules.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
