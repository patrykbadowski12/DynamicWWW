package com.studia.backend.entity;

import com.studia.backend.util.BookCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "encyclopedia")
public class EncyclopediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @CollectionTable(name = "encyclopedia_relation")
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(targetClass = EncyclopediaRegistrationEntity.class)
    private List<EncyclopediaRegistrationEntity> registration;

    public EncyclopediaEntity(String title){
        this.title = title;
    }

}
