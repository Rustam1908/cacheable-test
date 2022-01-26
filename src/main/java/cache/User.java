package cache;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID userId;

    private String firstName;

    private String lastName;

    @Override
    public String toString() {
        return userId + " " +  firstName + " " + lastName;
    }
}
