package com.HrSystem.validator;

/**
 * @author hrqfly
 * #Description LengthRuleValidator
 * #Date: 2023/9/13 00:02
 */
public class LengthRuleValidator implements RuleValidator {
    private RuleValidator nextValidator;

    @Override
    public boolean validate(String data) {
        // 实现长度规则校验逻辑
        // 返回true或false
        return true;
    }

    @Override
    public void setNextValidator(RuleValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public RuleValidator getNextValidator() {
        return nextValidator;
    }
}
