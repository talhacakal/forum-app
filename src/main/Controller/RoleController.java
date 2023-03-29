package main.Controller;

import main.Model.DTO.RoleDTO;
import main.Service.Abstract.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dev/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public ResponseEntity getAll() {
        return this.roleService.getAll();
    }
    @PostMapping("")
    public ResponseEntity saveRole(@RequestParam String roleName) {
        return this.roleService.saveRole(roleName);
    }
    @PutMapping("")
    public ResponseEntity updateRole(@RequestBody RoleDTO user) {
        return this.roleService.updateRole(user);
    }
    @DeleteMapping("")
    public ResponseEntity deleteRole(@RequestParam String roleName) {
        return this.roleService.deleteRole(roleName);
    }
}
