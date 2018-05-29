package e.kaari.passwordvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.*;


public class PasswordInputActivity extends AppCompatActivity  {
    EditText editPassword;
    TextView strengthView;
    Validator validate;
    String pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_input);

        validate = new Validator();
        editPassword = (EditText) findViewById(R.id.editPassword);
        strengthView = (TextView) findViewById(R.id.strengthView);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pw = editPassword.getText().toString();
                if (validate.validate(pw) == 5) {
                    strengthView.setText(R.string.success_message);
                } else {
                    strengthView.setText(R.string.pending_success_message);
                }

            }
        };
        editPassword.addTextChangedListener(watcher);
    }

    //cannot submit unless 5 tests passed.
    //message in view to be : "_/5 passrequirments met"
    //on successful pw view message : "all requirements met, submit pw"
    //another activity: "password submitted, thank you"
}
