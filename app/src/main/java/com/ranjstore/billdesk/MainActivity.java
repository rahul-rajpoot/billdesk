package com.ranjstore.billdesk;

import static com.ranjstore.billdesk.Config.SecretKey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button paymentBilldesk;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paymentBilldesk =  findViewById(R.id.payment);

        paymentBilldesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billdesk();
            }
        });


    }



    public void billdesk(){




        Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
          Checkout checkout = new Checkout();


           checkout.setKeyID(SecretKey);

            try {

                JSONObject options = new JSONObject();
              //  Toast.makeText(getApplicationContext(),"Suscesd",Toast.LENGTH_LONG).show();

                options.put("mercid",Config.merchantID);
                options.put("name", "BillTest");
               // options.put("orderdate","2020-08-17T15:19:00+0530");
                options.put("description", "Reference No. #123456");
                //options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
                // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
              //  options.put("theme.color", "#3399cc");
                options.put("currency", "INR");
                options.put("amount", "30000");//300 X 100
                options.put("prefill.email", "pramod.kumar@gmail.com");
                options.put("prefill.contact","9717194480");
              //  checkout.open(activity, options);

            }catch(JSONException e){

                Log.e("TAG", "Error in starting Razorpay Checkout", e);

            }

        }


    public void onPaymentSuccess(String s)
    {
       textView.setText("Successful payment ID :"+s);
    }


    public void onPaymentError(int i, String s) {
        textView.setText("Failed and cause is :"+s);
    }
    }
