package com.starzplay.payment.api.v1;

import static com.starzplay.payment.api.v1.PaymentMethodController.BASE_API_PATH_V1;

import com.starzplay.payment.dto.ListPaymentMethodResponse;
import com.starzplay.payment.model.PaymentMethod;
import com.starzplay.payment.service.PaymentMethodService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BASE_API_PATH_V1 + "/configuration/")
@RequiredArgsConstructor
@Log4j2
public class PaymentMethodController {

  public static final String BASE_API_PATH_V1 = "/api/v1.0";

  private final PaymentMethodService paymentMethodService;

  @GetMapping("payment-methods")
  @ApiOperation(value = "Get All Payment Methods")
  public ResponseEntity<ListPaymentMethodResponse> getAllPaymentMethods() {
    log.info("Request to get all payment methods");
    return ResponseEntity.ok(paymentMethodService.listPaymentMethods());
  }

  @GetMapping("payment-methods/filter/by-id")
  @ApiOperation(value = "Filter Payment Methods By ID")
  public ResponseEntity<PaymentMethod> filterPaymentMethodsById(
      @RequestParam(name = "id") Long id) {
    log.info("Request to filter payment methods by id {}", id);
    return ResponseEntity.ok(paymentMethodService.filterPaymentMethodsById(id));
  }

  @GetMapping("payment-methods/filter/by-name")
  @ApiOperation(value = "Filter Payment Methods By Name")
  public ResponseEntity<ListPaymentMethodResponse> filterPaymentMethodsByName(
      @RequestParam(name = "name") String name) {
    log.info("Request to filter payment methods by name {}", name);
    return ResponseEntity.ok(paymentMethodService.filterPaymentMethodsByName(name));
  }

  @PostMapping("payment-methods")
  @ApiOperation(value = "Create Payment Method")
  public ResponseEntity<PaymentMethod> createPaymentMethod(
      @RequestBody PaymentMethod paymentMethod) {
    log.info("Request to create payment method");
    return ResponseEntity.ok(paymentMethodService.createPaymentMethod(paymentMethod));
  }

  @PutMapping("payment-methods")
  @ApiOperation(value = "Update Payment Method")
  public ResponseEntity<PaymentMethod> updatePaymentMethod(
      @RequestParam(name = "id") Long id,
      @RequestBody PaymentMethod paymentMethod) {
    log.info("Request to update payment method by id {}", id);
    return ResponseEntity.ok(paymentMethodService.updatePaymentMethod(id, paymentMethod));
  }
}
