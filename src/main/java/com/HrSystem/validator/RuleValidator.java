package com.HrSystem.validator;

/**
 * @author hrqfly
 * #Description RuleValidator
 * #Date: 2023/9/12 23:59
 */
public interface RuleValidator {
    boolean validate(String data);
    void setNextValidator(RuleValidator nextValidator);
    RuleValidator getNextValidator();
}
