package com.starzplay.payment.service.impl;

import com.starzplay.payment.dto.ListPaymentMethodResponse;
import com.starzplay.payment.model.PaymentMethod;
import com.starzplay.payment.repository.PaymentMethodRepository;
import com.starzplay.payment.service.PaymentMethodService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

  private final PaymentMethodRepository paymentMethodRepository;

  @Override
  public ListPaymentMethodResponse listPaymentMethods() {
    return ListPaymentMethodResponse.builder().paymentMethods(paymentMethodRepository.findAll())
        .build();
  }

  @Override
  public PaymentMethod filterPaymentMethodsById(@NonNull Long id) {
    return paymentMethodRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public ListPaymentMethodResponse filterPaymentMethodsByName(@NonNull String name) {
    return ListPaymentMethodResponse.builder()
        .paymentMethods(
            paymentMethodRepository.findByNameLikeIgnoreCase("%".concat(name.trim()).concat("%")))
        .build();
  }

  @Override
  public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
    paymentMethod.getPaymentPlans()
        .forEach(paymentPlan -> paymentPlan.setPaymentMethod(paymentMethod));
    return paymentMethodRepository.save(paymentMethod);
  }

  @Override
  public PaymentMethod updatePaymentMethod(@NonNull Long id, @NonNull PaymentMethod paymentMethod) {
    PaymentMethod existingPaymentMethod = paymentMethodRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    existingPaymentMethod.setName(paymentMethod.getName());
    existingPaymentMethod.setPaymentType(paymentMethod.getPaymentType());
    existingPaymentMethod.setDisplayName(paymentMethod.getDisplayName());
    existingPaymentMethod.getPaymentPlans().clear();
    paymentMethod.getPaymentPlans()
        .forEach(paymentPlan -> paymentPlan.setPaymentMethod(existingPaymentMethod));
    existingPaymentMethod.getPaymentPlans().addAll(paymentMethod.getPaymentPlans());
    return paymentMethodRepository.save(existingPaymentMethod);
  }
}
