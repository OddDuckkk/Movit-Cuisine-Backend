package RPL.MovitCuisine.auth;

import RPL.MovitCuisine.admin.Admin;
import RPL.MovitCuisine.admin.AdminRepository;
import RPL.MovitCuisine.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private AuthResponse buildResponse(Admin admin) {
        var jwt = jwtService.generateToken(admin);
        return AuthResponse
                .builder()
                .token(jwt)
                .username(admin.getAdminName())
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        var admin = Admin.builder()
                .adminName(request.getUsername())
                .adminEmail(request.getEmail())
                .adminPass(passwordEncoder.encode(request.getPassword()))
                .build();
        adminRepository.save(admin);

        return buildResponse(admin);
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var admin = adminRepository.findByAdminName(request.getUsername()).orElseThrow();

        return buildResponse(admin);
    }
}

