package com.example.ccei.fragmentbasictotal;

//import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ccei on 2016-07-12.
 */
public class FBundleFragment extends Fragment {
    //번들값을 받기 위한 키값 설정
    public static final String MESSAGE_KEY = "messageKey";
    public static final String DATA_KEY = "dataKey";


    /*
    직접 코딩하여 배치할 시에는 이렇게 생성자를 생성해 내는 factory같은 역할을 하는 메소드가
    필요하며 유연성이 뛰어나다. public 생성자 below
     */

    public FBundleFragment() {
    }

    public static FBundleFragment newInstance(String message, int data) {
        FBundleFragment f = new FBundleFragment();
        Bundle b = new Bundle();
        b.putString(MESSAGE_KEY, message);
        b.putInt(DATA_KEY, data);
        f.setArguments(b);

        return f;
    }

    //현재 프래그먼트에서 사용하는 필드 값
    String message;
    int data;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setArgument로 activty로부터 받은 인자를 프래그먼트에서 받아낸다
        Bundle b = getArguments();
        if(b != null){
            message = b.getString(MESSAGE_KEY);
            data = b.getInt(DATA_KEY);
        }
    }

    //    //callback 메소드 - 액티비티의 saveinstance를 받는역할
//    public void onCreate(Bundle bundle){
//        super.onCreate(bundle);
//    }

    TextView messageWD;
    EditText inputWD;

    // 여러개의 액티비티가 있다면 ?
    // Activity ownerActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fbundle, container, false);
        //ownerActivity = getActivity();
        messageWD = (TextView)v.findViewById(R.id.text_message);
        messageWD.setText(message);
        inputWD = (EditText)v.findViewById(R.id.edit_input);

        ((Button)v.findViewById(R.id.btn_send)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                messageWD.setText(inputWD.getText().toString().trim());
            }
        });

        ((Button)v.findViewById(R.id.intent_btn)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AnotherActivity.class));
                // 종료한다면 다음을 선언
                // getActivity().finish();
            }
        });

        return v;
    }
}
