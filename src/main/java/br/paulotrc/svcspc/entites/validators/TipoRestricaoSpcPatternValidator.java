package br.paulotrc.svcspc.entites.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class TipoRestricaoSpcPatternValidator implements ConstraintValidator<TipoRestricaoSpcValidator, Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(TipoRestricaoSpcValidator annotation) {
        try {
            pattern = Pattern.compile(annotation.regexp());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (null == value) {
            return false;
        }

        Matcher m = pattern.matcher(value.name());
        return m.matches();
    }
}
