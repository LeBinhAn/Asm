package BTEC.Management.service.Impl;

import org.hibernate.type.descriptor.sql.BigIntTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BTEC.Management.Entities.AppUser;
import BTEC.Management.Repository.UserRepository;
import BTEC.Management.service.UserService;

import java.util.List;
import java.util.Optional;  

@Service  
public class UserServiceImpl implements UserService {  
  @Autowired private UserRepository userRepository;  

  @Override  
  public List<AppUser> getAllUser() {  
    return (List<AppUser>) userRepository.findAll();  
  }  

  @Override  
  public void saveUser(AppUser user) {  
    userRepository.save(user);  
  }  

  @Override  
  public void deleteUser(Long id) {  
    userRepository.deleteById(id);  
  }  

  @Override  
  public Optional<AppUser> findUserById(Long id) {  
    return userRepository.findById(id);  
  }  
}