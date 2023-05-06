package xxw.template.login.backend.loginbackend.service;

import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xxw.template.login.backend.loginbackend.entity.Account;
import xxw.template.login.backend.loginbackend.repository.AccountRepository;

@Service
public class AuthorizeService implements UserDetailsService {

    @Resource
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findAccountByUsername(username).orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
        return User.withUsername(username).password(account.getPassword())
                .roles("user")
                .build();
    }
}
