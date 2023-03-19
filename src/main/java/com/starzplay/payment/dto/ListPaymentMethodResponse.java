package com.starzplay.payment.dto;

import com.starzplay.payment.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListPaymentMethodResponse {

    private List<PaymentMethod> paymentMethods;
}
