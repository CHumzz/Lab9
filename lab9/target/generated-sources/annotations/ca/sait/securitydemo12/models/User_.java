package ca.sait.securitydemo12.models;

import ca.sait.securitydemo12.models.Note;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Role;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-11T13:17:26")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Role> role;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile ListAttribute<User, Note> noteList;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> resetPasswordUuid;

}