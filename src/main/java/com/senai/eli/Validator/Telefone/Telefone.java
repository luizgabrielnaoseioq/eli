package com.senai.eli.Validator.Telefone;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = TelefoneValidator.class)//Qual a classe da lógica da validação
@Target({ElementType.FIELD, ElementType.PARAMETER})//Qual lugar irá aceita a anotação
@Retention(RetentionPolicy.RUNTIME)//Onde vai ser executado
public @interface Telefone {

    //Mensagem padrão da validação do telefone
    String message() default "Telefone Inválido";

    //Permite agrupar validações
    Class<?>[] groups() default {};

    //Pemite ter mais informação de erro
    Class<? extends Payload>[] payload() default {};

    //Parametro com objetivo de 
    //definir se pode telefone fixo ou celular
    boolean apenasCelular() default false;

    //Parametro com objetivo de definir se é
    //obrigatório o preenchimento
    boolean required() default false;
}
