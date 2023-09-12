package com.HrSystem.validator;

/**
 * @author hrqfly
 * #Description TestValidatorChainDemo
 * #Date: 2023/9/13 00:06
 */
public class TestValidatorChainDemo {
    public static void main(String[] args) {
        // 创建规则校验器链
        RuleValidatorChain validatorChain = new RuleValidatorChain();

        // 创建规则校验器实例
        RuleValidator emailValidator = new EmailRuleValidator();
        RuleValidator lengthValidator = new LengthRuleValidator();

        // 将校验器添加到校验器链中
        validatorChain.addValidator(emailValidator);
        validatorChain.addValidator(lengthValidator);

        // 创建规则校验服务实例，并传入校验器链
        RuleValidationService validationService = new RuleValidationService(validatorChain);

        // 要校验的数据
        String data = "example@example.com";

        // 执行校验
        boolean isValid = validationService.validateData(data);

        // 输出校验结果
        if (isValid) {
            System.out.println("数据通过校验。");
        } else {
            System.out.println("数据未通过校验。");
        }
    }
}
