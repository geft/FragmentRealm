package gerryjuans.fragmentrealm;

import io.realm.RealmObject;

/**
 * Created by gerryjuans on 6/2/16.
 */
public class User extends RealmObject {
    public String name;
    public String email;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
