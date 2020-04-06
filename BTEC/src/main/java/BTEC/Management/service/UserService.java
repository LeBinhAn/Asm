package BTEC.Management.service;

import BTEC.Management.Entities.AppUser;

import java.util.List;  
import java.util.Optional;  

public interface UserService {  
  List<AppUser> getAllUser();  

  List<AppUser> getTrainerOnly(Long RoleId);  

  void saveUser(AppUser user);  

  void deleteUser(Long id);  

  Optional<AppUser> findUserById(Long id);  
}