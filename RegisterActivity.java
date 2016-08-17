package nmmu.wrap302.Task01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * Created by s214252914 on 2016/08/16.
 */
public class RegisterActivity extends Activity{
    Students students = new Students();
    MyActivity act = new MyActivity();
    String res = "Non-Res";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Intent intent = getIntent();

        if(intent!= null)
        {
            Bundle extras = intent.getExtras();
            System.out.println("Intent found");
        }

        String sname = ((EditText) findViewById(R.id.sNameText)).getText().toString();
        String name = ((EditText)findViewById(R.id.NameText)).getText().toString();
        String snr =((EditText)findViewById(R.id.SNrText)).getText().toString();
        RadioGroup rbgres = (RadioGroup) findViewById(R.id.RBGRes);
        EditText editText= (EditText) findViewById(R.id.resText);

        rbgres.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case(R.id.RBYes):
                        editText.setClickable(true);
                        break;
                    case(R.id.RBNo):
                        editText.setClickable(false);
                        break;
                }
            }
        });
        if(editText.isClickable()) {
            res = ((EditText) findViewById(R.id.resText)).getText().toString();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });




        Button btnOk = (Button) findViewById(R.id.btnRegOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Connection con = act.con;
                if(con!=null)
                    students.registerStudent(con,snr,name,sname,res,false);
                else
                    builder.create();
            }
        });
    }
    /*private Connection getCon()
    {
//        System.out.println("   Loading JDBC driver for MS SQL Server database...");
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (Exception e) {
//            System.out.printf("   Unable to load JDBC driver... '%s'\n", e.getMessage());
//            return null;
//        }
//        System.out.println("   Use driver to connect to MS SQL Server (OPENBOX\\WRR)...");
        Connection con = null;
        if (true) {
            try {
                System.out.println("   Locate database to open (using connection string)...");

                String connectionString = "jdbc:sqlserver://OPENBOX\\WRR;databaseName=MC01";
                System.out.println("      Connection string = " + connectionString);

                // create connection to DB, including username & password
                // NEVER, EVER, include a username and password in your code!!!!
                con = DriverManager.getConnection(connectionString, "MC01User", "fIW1DabR");


            } catch (Exception e) {
                System.out.printf("   Unable to connect to DB... '%s'\n", e.getMessage());
            }

            System.out.println();
        }
        return con;
    }*/
}
