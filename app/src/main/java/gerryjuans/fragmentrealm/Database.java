package gerryjuans.fragmentrealm;

/**
 * Created by gerryjuans on 6/2/16.
 */
interface Database {

    void addUser();

    User getUserByName(String name);

    User getUserByEmail(String email);
}
