package com.rookie.im.user.validator;

import com.rookie.im.common.annotations.IsMobile;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @Author: Jokeer
 * @Description: TODO
 * @Date: 2024/4/23 14:33
 * @Version: 1.0
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    /**
     * 初始化
     * @param constraintAnnotation
     */
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return isMobile(value);
            }
        }
    }

    private boolean isMobile(String value) {
        // 校验手机号是否合法，此处仅为示例，具体正则表达式按实际需求编写
        String pattern = "^[1]([3-9])[0-9]{9}$";
        return Pattern.matches(pattern, value);
    }
}