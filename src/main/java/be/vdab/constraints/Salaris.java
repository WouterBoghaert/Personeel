package be.vdab.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

@Retention(RUNTIME)
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@DecimalMin("0")
@Digits(integer=10, fraction=2)
public @interface Salaris {
	@OverridesAttribute.List({
		@OverridesAttribute(constraint = DecimalMin.class, name="message"),
		@OverridesAttribute(constraint = Digits.class, name="message")
	}) 
	String message() default "{be.vdab.constraints.Salaris}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
}
