package com.HrSystem.validator;

/**
 * @author hrqfly
 * #Description RuleValidationService
 * #Date: 2023/9/13 00:05
 */
public class RuleValidationService {
    private RuleValidatorChain validatorChain;

    public RuleValidationService(RuleValidatorChain validatorChain) {
        this.validatorChain = validatorChain;
    }

    public boolean validateData(String data) {
        return validatorChain.validateData(data);
    }
}
