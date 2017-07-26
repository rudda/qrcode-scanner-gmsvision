package com.github.beltrao.testeqrcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class QrcodeReader extends AppCompatActivity implements View.OnClickListener{

    private TextView result;
    private Button bt_scanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_reader);
        result = (TextView)findViewById(R.id.tv_result);
        bt_scanner = (Button) findViewById(R.id.bt_scanner);

        bt_scanner.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        Intent it = new Intent(this, QrCodeScanner.class);
        startActivityForResult(it, 100);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(resultCode == CommonStatusCodes.SUCCESS){

            if(requestCode == 100){

                if(data!= null){

                    Barcode barcode = data.getParcelableExtra("barcode");

                    result.setText("Resultado: "+barcode.displayValue);
                }else{

                    result.setText("Sem Resultado: ");

                }


            }


        }else

        super.onActivityResult(requestCode, resultCode, data);
    }
}
