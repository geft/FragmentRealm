package gerryjuans.fragmentrealm;

import io.realm.RealmObject;

/**
 * Created by gerryjuans on 6/2/16.
 */
public class User extends RealmObject {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
