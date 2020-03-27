package BTEC.Management.Repository;

import BTEC.Management.Entities.AppUser;

import org.springframework.data.repository.CrudRepository;  
import org.springframework.stereotype.Repository;  

@Repository  
public interface UserRepository extends CrudRepository<AppUser, Long> {}