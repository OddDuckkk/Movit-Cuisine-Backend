package RPL.MovitCuisine.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long adminId) {
        return adminRepository.findById(adminId);
    }

    public Admin createAdmin(Admin admin) {
        // Perform any validation or business logic
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long adminId, Admin updatedAdmin) {
        // Perform any validation or business logic
        Optional<Admin> existingAdminOptional = adminRepository.findById(adminId);

        if (existingAdminOptional.isPresent()) {
            Admin existingAdmin = existingAdminOptional.get();
            // Update existingAdmin fields with updatedAdmin fields
            // ...

            return adminRepository.save(existingAdmin);
        } else {
            // Handle not found case
            return null;
        }
    }

    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }
}

