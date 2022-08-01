package kr.hs.emirim.xodusguckhan.mirim_project_0801_01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] btnIds = {R.id.btn_dial, R.id.btn_hompage, R.id.btn_map, R.id.btn_search, R.id.btn_sms, R.id.btn_camera};
        Button[] btns = new Button[btnIds.length];
        for (int i = 0; i < btns.length; i++){
            btns[i] = findViewById(btnIds[i]);
            btns[i].setOnClickListener(btnListener);
        }
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = null; //정수는 초기화할때 null 참조변수는 초기화할때 null
            Uri uri = null;//참조변수임
            switch (view.getId()){
                case R.id.btn_dial:
                    uri = Uri.parse("tel:/01033337777");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.btn_hompage:
                    uri = Uri.parse("htts://e-mirim.hs.kr");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_map:
                    uri = Uri.parse("http://maps.google.co,kr/maps?q=37.4789211,126.954465&z=15");//q는 파라미터(값을 전달할때 사용) z는 zoom확대
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "미림정보과학고");
                    break;
                case R.id.btn_sms:
                    uri = Uri.parse("smsto:"+Uri.encode("010-3333-7777"));
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "안녕하세요~");
                    intent.setData(uri);
                    break;
                case R.id.btn_camera:
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}