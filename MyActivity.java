package nmmu.wrap302.Task01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    public Connection con = null;
    // object used to issue SQL commands
    private Statement statement = null;
    Students studController = new Students();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainact);
        //onRegClicked();



        connectToDB();

        //After all methods
        //
        //

        Button btnreg = (Button) findViewById(R.id.buttonReg);
        if(btnreg!=null) {

            btnreg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRegClicked();
                }
            });
        }
        else
            System.out.println("Button is null");

        disconnectDB();
    }
    private void onRegClicked()
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }



    /**
     * Establish a connection to the database. Cannot do <b>anything</b> until a connection
     * is established.
     * Have to fix username and password issues
     */
    public void connectToDB() {
        System.out.println("Establishing connection to database...");

        System.out.println("   Loading JDBC driver for MS SQL Server database...");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.printf("   Unable to load JDBC driver... '%s'\n", e.getMessage());
            return;
        }

        System.out.println("   Use driver to connect to MS SQL Server (OPENBOX\\WRR)...");
        if (true) {
            try {
                System.out.println("   Locate database to open (using connection string)...");

                String connectionString = "jdbc:sqlserver://OPENBOX\\WRR;databaseName=MC01";
                System.out.println("      Connection string = " + connectionString);

                // create connection to DB, including username & password
                // NEVER, EVER, include a username and password in your code!!!!
                con = DriverManager.getConnection(connectionString, "MC01User", "fIW1DabR");

                // create statement object for manipulating DB
                //stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            } catch (Exception e) {
                System.out.printf("   Unable to connect to DB... '%s'\n", e.getMessage());
            }

            System.out.println();
        }
    }

    public void RegisterStudent()
    {
        final TextView nameTV = (TextView) findViewById(R.id.NameText);
        String name = (String) nameTV.getText();
        String sname = (String) ((TextView) findViewById(R.id.sNameText)).getText();
        String sNr = ((String)((TextView) findViewById(R.id.SNrText)).getText());
        //String res = (String) ((TextView)findViewById(R.id.))



        studController.registerStudent(con, sNr,name, sname, "res",false);






    }
    public void Login()
    {

    }
    public void showRoutes()
    {

    }

    public void viewAllRoutes()
    {
        String sql = "SELECT * FROM ROUTE";
    }

    public void disconnectDB() {
        System.out.println("Disconnecting from database...");

        try {
            //Important to close connection (same as with files)
            con.close();
        } catch (Exception ex) {
            System.out.println("   Unable to disconnect from database");
        }
    }
}
