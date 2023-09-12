package com.HrSystem.validator;

/**
 * @author hrqfly
 * #Description EmailRuleValidator
 * #Date: 2023/9/13 00:00
 */
public class EmailRuleValidator implements RuleValidator{
    private RuleValidator nextValidator;

    @Override
    public boolean validate(String data) {
        // 实现Email规则校验逻辑
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
