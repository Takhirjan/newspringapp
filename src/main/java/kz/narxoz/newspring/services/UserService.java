package kz.narxoz.newspring.services;

import kz.narxoz.newspring.entities.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

         public interface UserService extends UserDetailsService {
       Users getUserByEmail(String email);

      Users createUser(Users user);
}
