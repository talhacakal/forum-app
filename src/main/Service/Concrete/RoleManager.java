package main.Service.Concrete;

import main.Model.DTO.RoleDTO;
import main.Model.Role;
import main.Repository.RoleRepository;
import main.Service.Abstract.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleManager implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.ok(this.roleRepository.findAll());
    }
    @Override
    public ResponseEntity saveRole(String roleName) {
        return ResponseEntity.ok(this.roleRepository.save(new Role(roleName)));
    }
    @Override
    public ResponseEntity updateRole(RoleDTO user) {
        Optional<Role> optionalRole = this.roleRepository.findById(user.getId());
        if (optionalRole.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Role Not Found");
        optionalRole.get().setRole(user.getRole());
        return ResponseEntity.ok(this.roleRepository.save(optionalRole.get()));
    }
    @Override
    public ResponseEntity deleteRole(String roleName) {
        Optional<Role> optionalRole = this.roleRepository.findByRole(roleName);
        if (optionalRole.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Role Not Found");
        this.roleRepository.delete(optionalRole.get());
        return ResponseEntity.ok("Role deleted");
    }
}
