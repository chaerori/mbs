package mbs.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import mbs.domain.model.User;
import mbs.domain.repository.user.UserRepository;

@Service
public class BookingUserDetailsService implements UserDetailsService {
	@Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findOne(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + " is not found.");
        }
        return new BookingUserDetails(user);
    }
}
