package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
//    List<Permission> listAllPermissions();
//    Permission addPermission(Permission permission);
//    Permission findPermissionById(Long id);
//    void removePermission(Long id);
//    void removePermission(Permission permission);
}
