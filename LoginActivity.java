package nmmu.wrap302.Task01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by s214252914 on 2016/08/16.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Intent
        Intent intent = getIntent();
        if(intent!=null)
        {

        }


    }
    public void loginStudent()
    {
        String username = ((TextView)findViewById(R.id.userNameInput)).toString(); //Check if username exists
        String pass = ((TextView)findViewById(R.id.PasswordInput)).toString(); //Check if password matches username

        String sql = "SELECT password FROM Students"+"WHERE username = ?";

    }


}
