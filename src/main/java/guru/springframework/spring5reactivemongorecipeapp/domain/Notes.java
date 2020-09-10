package guru.springframework.spring5reactivemongorecipeapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Notes {

    @Id
    private String id;  //Why @Id works for Notes (embedded elem in Recipe)?
    private String recipeNotes;
}
