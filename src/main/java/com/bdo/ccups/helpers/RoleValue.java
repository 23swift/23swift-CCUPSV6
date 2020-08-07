package com.bdo.ccups.helpers;

public final class RoleValue {
    
    // private final String role;
    // @org.springframework.beans.factory.annotation.Value("${application.role.user}")
    // private String role_user;
    public final static  String ROLE_USER="ROLE_USER";

    public final static String ROLE_ADMIN ="ROLE_ADMIN";
    public final static String ROLE_REQUESTOR ="ROLE_REQUESTOR";
    public final static String ROLE_APPROVER ="ROLE_APPROVER";

 
    
     public final static  String PostAuthorize_ROLE_USER= "hasRole('ROLE_USER')";

    public final static String PostAuthorize_ROLE_ADMIN ="hasRole('ROLE_ADMIN')";
    public final static String PostAuthorize_ROLE_REQUESTOR ="hasRole('ROLE_REQUESTOR')";
    public final static String PostAuthorize_ROLE_APPROVER ="hasRole('ROLE_APPROVER')";
    
}