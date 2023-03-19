package com.starzplay.payment.repository;

import com.starzplay.payment.model.PaymentMethod;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

  List<PaymentMethod> findByNameLikeIgnoreCase(String name);
}
