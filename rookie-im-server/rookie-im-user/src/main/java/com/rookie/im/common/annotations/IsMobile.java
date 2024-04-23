package com.rookie.im.common.annotations;


import com.rookie.im.user.validator.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MobileValidator.class)
public @interface IsMobile {

    String message() default "Invalid mobile number"; // 校验失败时的默认消息

    boolean required() default true; // 是否必须有

    Class<?>[] groups() default {}; // 用于分组校验

    Class<? extends Payload>[] payload() default {}; // 用于客户端消息传递

}
