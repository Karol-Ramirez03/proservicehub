package com.servimax.proservicehub.infrastructure.utils.enums;

import java.util.Arrays;
import java.util.List;

public enum Role {
    ROLE_ADMIN(Arrays.asList(
        RolePermission.READ_ALL_INSUMOS,
        RolePermission.READ_ONE_INSUMO,
        RolePermission.CREATE_ONE_INSUMO,
        RolePermission.UPDATE_ONE_INSUMO,
        RolePermission.DISABLE_ONE_INSUMO,

        RolePermission.READ_ALL_COMPRA,
        RolePermission.READ_ONE_COMPRA,
        RolePermission.CREATE_ONE_COMPRA,
        RolePermission.UPDATE_ONE_COMPRA,
        RolePermission.DISABLE_ONE_COMPRA,

        RolePermission.READ_MY_PROFILE
    )),
    ROLE_GERENTE(Arrays.asList(
        RolePermission.READ_ALL_INSUMOS,
        RolePermission.READ_ONE_INSUMO,
        RolePermission.UPDATE_ONE_INSUMO,
        RolePermission.DISABLE_ONE_INSUMO,

        RolePermission.READ_ALL_COMPRA,
        RolePermission.READ_ONE_COMPRA,
        RolePermission.UPDATE_ONE_COMPRA,
        RolePermission.DISABLE_ONE_COMPRA,

        RolePermission.READ_MY_PROFILE
    )),
    ROLE_CLIENTE(Arrays.asList(
        RolePermission.READ_ALL_INSUMOS,
        RolePermission.READ_ONE_INSUMO,

        RolePermission.READ_ALL_COMPRA,
        RolePermission.CREATE_ONE_COMPRA,
        RolePermission.READ_ONE_COMPRA,

        RolePermission.READ_MY_PROFILE
    ));

    private List<RolePermission> permissions;

    Role(List<RolePermission> permissions){
        this.permissions= permissions;
    }

    public List<RolePermission> getPermissions(){
        return permissions;
    }

    public void setPermissions(List<RolePermission> permisions){
        this.permissions=permisions;
    }
}
