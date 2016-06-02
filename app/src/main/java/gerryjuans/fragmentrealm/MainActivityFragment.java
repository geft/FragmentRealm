package gerryjuans.fragmentrealm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements Database {

    RealmHelper realmHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realmHelper = new RealmHelper(this.getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void addUser() {
        User user = new User(getNameString(), getEmailString());
        realmHelper.addUser(user);

    }

    @Override
    public User getUserByName(String name) {
        return realmHelper.getUser(RealmHelper.NAME, name);
    }

    @Override
    public User getUserByEmail(String email) {
        return realmHelper.getUser(RealmHelper.EMAIL, email);
    }

    private String getNameString() {
        EditText editText = (EditText) getActivity().findViewById(R.id.editTextName);
        return editText.getText().toString();
    }

    private String getEmailString() {
        EditText editText = (EditText) getActivity().findViewById(R.id.editTextEmail);
        return editText.getText().toString();
    }
}
