package com.case_study.dto;

import com.case_study.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private Integer customerId;
    @NotBlank
    @Pattern(regexp = "^(KH)-[0-9]{4}$", message = "Please re-enter in the format : KH-XXXX (X: 0-9)")
    private String customerCode;
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!")
    private String customerName;
    private String customerBirthday;
    private Integer customerGender;
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Please re-enter in the format: XXXXXXXXX or XXXXXXXXXXXX (X: 0-9)")
    private String customerIdCard;
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Please re-enter in the format: 090xxxxxxx or 091xxxxxxx " +
                    "or (84)+90xxxxxxx or (84)+91xxxxxxx (x: 0-9)")
    private String customerPhone;
    @NotBlank
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",
            message = "Please re-enter in the format: abc@gmail.com or abc@gmail.com.vn")
    private String customerMail;
    @NotBlank
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Please capitalize the first letter of each word!")
    private String customerAddress;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
