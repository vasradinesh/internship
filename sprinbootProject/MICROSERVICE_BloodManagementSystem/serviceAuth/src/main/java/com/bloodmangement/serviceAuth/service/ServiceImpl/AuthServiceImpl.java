package com.bloodmangement.serviceAuth.service.ServiceImpl;


import com.bloodmangement.serviceAuth.CustomException.NoUserFoundException;
import com.bloodmangement.serviceAuth.Domain.Users;
import com.bloodmangement.serviceAuth.JwtUtility.JwtUtil;
import com.bloodmangement.serviceAuth.Model.AuthReq;
import com.bloodmangement.serviceAuth.Model.AuthResp;
import com.bloodmangement.serviceAuth.Model.TokenRole;
import com.bloodmangement.serviceAuth.Proxy.UsersProxy;
import com.bloodmangement.serviceAuth.Repository.Usersrepo;
import com.bloodmangement.serviceAuth.Utility.Mapper;
import com.bloodmangement.serviceAuth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServiceImpl implements AuthService {


    @Autowired
    private Usersrepo userrepo;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private Mapper mapper;


    private Map<String,String> otpStorage = new HashMap<>();


    @Override
    public String register(UsersProxy usersProxy) {
        Optional<Users> byEmail = userrepo.findByEmail(usersProxy.getEmail());
        usersProxy.setStatus("INACTIVE");
        if(byEmail.isEmpty()){
            userrepo.save(mapper.mapper(usersProxy,Users.class));
        }else {
            throw new NoUserFoundException("your given email is already register", HttpStatus.NOT_ACCEPTABLE.toString());
        }
        return "saved";
    }



    @Override
    public AuthResp login(AuthReq authReq) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(authReq.getEmail(),authReq.getPassword());

        Authentication authentication = manager.authenticate(authenticationToken);

        if(authentication.isAuthenticated()){

            UserDetails userDetails = myUserDetailsService.loadUserByUsername(authReq.getEmail());

            String jwttoken = jwtUtil.generateToken(userDetails);

            Optional<Users> user = userrepo.findByEmail(authReq.getEmail());
            Users users = user.get();
            users.setId(users.getId());
            users.setStatus("Active");
            userrepo.save(users);


            return AuthResp.builder().email(authReq.getEmail())
                    .token(jwttoken).build();
        }
        throw new RuntimeException("you are not authenticated");
    }



    private String genrateOtp(){
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }


    @Override
    public String sendOtp(String email) {
        Optional<Users> user = userrepo.findByEmail(email);
        if (user.isEmpty()){
            throw new NoUserFoundException("there is no user of given email : " + email ,HttpStatus.NOT_FOUND.toString());
        }else {
            String otp = genrateOtp();
            otpStorage.put(email,otp);
            return otp;
        }
    }

    @Override
    public String verifyOtp(String email, String otp) {
        String storageotp = otpStorage.get(email);
        if(storageotp==null && !storageotp.equals(otp)){
            throw new RuntimeException("invalid otp");
        }else {
            return "correct otp";
        }
    }

    @Override
    public String resetPassword(String email, String newPassword) {
        Optional<Users> optionalUser = userrepo.findByEmail(email);

        if (optionalUser.isEmpty()){
            throw new NoUserFoundException("there is no user of given email : " + email ,HttpStatus.NOT_FOUND.toString());
        }else {
            Users user = optionalUser.get();
            user.setPassword(newPassword);
            userrepo.save(user);
            otpStorage.remove(email);
            return "succesfully updated";
        }

    }

    @Override
    public Boolean verifyToken(TokenRole jwttoken) {

        try{
            String jwtToken = jwttoken.getToken().trim().replace("\"","");

            if(jwtToken.startsWith("Bearer ")) {
                jwtToken = jwtToken.substring(7);
            }

            String username = jwtUtil.extractUsername(jwtToken);

            UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

            List<String> roles = jwtUtil.extractClaim(jwtToken, claims -> claims.get("roles", ArrayList.class));
            List<SimpleGrantedAuthority> list = roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .toList();

            if(jwtUtil.validateToken(jwtToken,userDetails)) {
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(username,null, list);

                SecurityContextHolder.getContext().setAuthentication(auth);

                if(roles.contains(jwttoken.getRole())) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // IMPORTANT DEBUG
            return false;
        }

        return false;
    }

    @Override
    public Users getUser(Long id) {
        Optional<Users> byId = userrepo.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }else {
            throw new NoUserFoundException("there is no user of given id",HttpStatus.BAD_REQUEST.toString());
        }
    }

    @Override
    public List<UsersProxy> getAllUsers() {
        return userrepo.findAll().stream().map(m->mapper.mapper(m, UsersProxy.class)).toList();
    }

}