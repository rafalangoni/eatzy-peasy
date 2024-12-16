package com.langoni.eatzy_peasy.repository;

import com.langoni.eatzy_peasy.model.Permission;

import java.util.List;

public interface PermissionRepository {
    List<Permission> listAllPermissions();
    Permission addPermission(Permission permission);
    Permission findPermissionById(Long id);
    void removePermission(Long id);
    void removePermission(Permission permission);
}
