package br.com.visalario.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Coluna {

    String nome();

    int tamanho() default 255;

    int precisao() default 0;

    int escala() default 0;

    boolean obrigatorio() default false;
}
