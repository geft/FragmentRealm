package gerryjuans.fragmentrealm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by gerryjuans on 6/2/16.
 */
public class RealmHelper {

    public static final String NAME = "name";
    public static final String EMAIL = "email";

    public RealmHelper(Context context) {
        RealmConfiguration configuration = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(configuration);
    }

    private Realm getInstance() {
        return Realm.getDefaultInstance();
    }

    public void addUser(User user) {
        Realm realm = getInstance();
        realm.beginTransaction();
        realm.copyToRealm(user);
        realm.commitTransaction();
    }

    public User getUser(String field, String match) {
        Realm realm = getInstance();
        RealmResults<User> results = realm.where(User.class).equalTo(field, match).findAll();
        return results.get(0);
    }
}
