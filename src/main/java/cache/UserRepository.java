package cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

@Cacheable("byName")
public interface UserRepository extends CrudRepository<User, UUID> {

    User findByFirstName(String name);

    User findByLastName(String name);

}
