package gerryjuans.fragmentrealm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
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
    public User addUser() {
        User user = new User(getNameString(), getEmailString());

        if (!isNameEmpty() && !isEmailEmpty()) {
            realmHelper.addUser(user);
        }

        clearFields();

        return user;
    }

    @Override
    public User loadUser() {
        User user = new User();

        if (isNameEmpty() && !isEmailEmpty()) {
            user = getUserByEmail(getEmailString());
        } else if (!isNameEmpty()) {
            user = getUserByName(getNameString());
        }

        if (user != null) {
            getNameEditText().setText(user.name);
            getEmailEditText().setText(user.email);
        }

        return user;
    }

    private void clearFields() {
        getNameEditText().getText().clear();
        getEmailEditText().getText().clear();
    }

    public User getUserByName(String name) {
        return realmHelper.getUser(RealmHelper.NAME, name);
    }

    public User getUserByEmail(String email) {
        return realmHelper.getUser(RealmHelper.EMAIL, email);
    }

    private String getNameString() {
        return getNameEditText().getText().toString();
    }

    private EditText getNameEditText() {
        return (EditText) getActivity().findViewById(R.id.editTextName);
    }

    private String getEmailString() {
        return getEmailEditText().getText().toString();
    }

    private EditText getEmailEditText() {
        return (EditText) getActivity().findViewById(R.id.editTextEmail);
    }

    private boolean isNameEmpty() {
        return TextUtils.isEmpty(getNameString());
    }

    private boolean isEmailEmpty() {
        return TextUtils.isEmpty(getEmailString());
    }
}
