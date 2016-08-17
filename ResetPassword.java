import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import nmmu.wrap302.Task01.R;

/**
 * Created by s214252914 on 2016/08/17.
 */
public class ResetPassword extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.respassfrag, container, false);

        String pass = ((TextView) view.findViewById(R.id.passOld)).toString();
        String con =((TextView) view.findViewById(R.id.conPass)).toString();

        Button btnOk = (Button) view.findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.equals(con))
                {
                    Toast.makeText(getContext(),"Succesful",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getContext(),"Fail",Toast.LENGTH_SHORT).show();

            }
        });
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return view;
    }
}