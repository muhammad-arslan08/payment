package com.starzplay.payment.service;

import com.starzplay.payment.dto.ListPaymentMethodResponse;
import com.starzplay.payment.model.PaymentMethod;
import lombok.NonNull;

public interface PaymentMethodService {

    ListPaymentMethodResponse listPaymentMethods();

    PaymentMethod filterPaymentMethodsById(@NonNull Long id);

    ListPaymentMethodResponse filterPaymentMethodsByName(@NonNull String name);

    PaymentMethod createPaymentMethod(PaymentMethod paymentMethod);

    PaymentMethod updatePaymentMethod(@NonNull Long id, PaymentMethod paymentMethod);
}
