package com.langoni.eatzy_peasy.infra.repository.implementation;

import com.langoni.eatzy_peasy.domain.model.Permission;
import com.langoni.eatzy_peasy.domain.repository.PermissionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
//public class PermissionRepositoryImpl implements PermissionRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Permission> listAllPermissions() {
//        TypedQuery<Permission> query = entityManager.createQuery("select p from Permission p", Permission.class);
//        return query.getResultList();
//    }
//
//    @Override
//    @Transactional
//    public Permission addPermission(Permission permission) {
//        entityManager.persist(permission);
//        return permission;
//    }
//
//    @Override
//    public Permission findPermissionById(Long id) {
//        return entityManager.find(Permission.class, id);
//    }
//
//    @Override
//    @Transactional
//    public void removePermission(Long id) {
//        entityManager.remove(findPermissionById(id));
//    }
//
//    @Override
//    @Transactional
//    public void removePermission(Permission permission) {
//        entityManager.remove(findPermissionById(permission.getId()));
//    }
//}
