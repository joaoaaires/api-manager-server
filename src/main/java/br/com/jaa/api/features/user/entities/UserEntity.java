package br.com.jaa.api.features.user.entities;

import br.com.jaa.api.features.shared.entities.DefaultEntity;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends DefaultEntity {

    private String email;
    private String password;

}