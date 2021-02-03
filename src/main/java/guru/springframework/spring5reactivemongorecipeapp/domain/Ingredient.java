package guru.springframework.spring5reactivemongorecipeapp.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Ingredient {

    private String id = UUID.randomUUID().toString();   //@Id won't work because it's an embedded elem in the recipe document
    private String description;
    private BigDecimal amount;

    private UnitOfMeasure uom;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }
}
