package ir.mostafa.semnani.energybill.common.creator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Developer {
    String developerName() default "Mosi" ;
    String creationDate() default "20/10/2020" ;
}
