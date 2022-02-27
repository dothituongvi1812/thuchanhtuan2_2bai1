package com.example.thuchanhtuan2_2bai1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtTaiKhoan=findViewById(R.id.edtTaiKhoan);
        EditText edtMatKhau=findViewById(R.id.edtMatKhau);
        TextView tv_TbTK=findViewById(R.id.tvTb_TK);
        TextView tv_TbMK=findViewById(R.id.tvTb_MK);
        Button btnDangNhap=findViewById(R.id.buttonDangNhap);
        Button btnThoat=findViewById(R.id.buttonThoat);
        CheckBox chkLuu=findViewById(R.id.chkLuuThongTin);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taikhoan = edtTaiKhoan.getText().toString();
                String matkhau=edtMatKhau.getText().toString(); // lỗi chổ này khi ko nhập nó là null mà null.toString() là lỗi
               Log.i("log","log");
                Log.i("taikhoan",taikhoan.toString());
                Log.i("matkhau",matkhau);
//               cái terminal log đâu
                if(taikhoan.trim().equals("")){
                    tv_TbTK.setText("Vui lòng nhập tài khoản");
                    edtMatKhau.setFocusable(true);
                    return;
                }
                if( matkhau.trim().equals("")){
                    tv_TbMK.setText("Vui lòng nhập mật khẩu");
                    edtMatKhau.setFocusable(true);
                    return;

                }
                tv_TbTK.setText("");
                tv_TbMK.setText("");

                if(chkLuu.isChecked()){
                    Toast.makeText(MainActivity.this,"Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu",Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    Toast.makeText(MainActivity.this,"Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                builder.setIcon(R.drawable.announcement);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát không ?").setCancelable(false)
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.this.finish();
                            }
                        }).setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });
    }
}