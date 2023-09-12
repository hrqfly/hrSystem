package com.HrSystem.validator;

/**
 * @author hrqfly
 * #Description RuleValidatorChain
 * #Date: 2023/9/13 00:04
 */
public class RuleValidatorChain {
    private RuleValidator firstValidator;

    public void addValidator(RuleValidator validator) {
        if (firstValidator == null) {
            firstValidator = validator;
        } else {
            RuleValidator currentValidator = firstValidator;
            while (currentValidator.getNextValidator() != null) {
                currentValidator = currentValidator.getNextValidator();
            }
            currentValidator.setNextValidator(validator);
        }
    }

    public boolean validateData(String data) {
        if (firstValidator != null) {
            RuleValidator currentValidator = firstValidator;
            while (currentValidator != null) {
                if (!currentValidator.validate(data)) {
                    return false;
                }
                currentValidator = currentValidator.getNextValidator();
            }
            return true;
        }
        return false;
    }
}
