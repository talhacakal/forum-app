package main.Service.Abstract;

import main.Model.DTO.RoleDTO;
import org.springframework.http.ResponseEntity;

public interface RoleService {

    ResponseEntity getAll();
    ResponseEntity saveRole(String roleName);
    ResponseEntity updateRole(RoleDTO user);
    ResponseEntity deleteRole(String roleName);
}
