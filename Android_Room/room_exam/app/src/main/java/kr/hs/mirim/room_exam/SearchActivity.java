package kr.hs.mirim.room_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private List<String> items = Arrays.asList("어벤져스", "배트맨", "배트맨2", "배구", "슈퍼맨");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchView searchView = findViewById(R.id.search_view);
        TextView resultTextView = findViewById(R.id.textView);
        resultTextView.setText(getResult());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {    //작성하고 키보드에서 검색 누르면 호출됨
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {        //검색어를 실시간으로 찾을 때
                resultTextView.setText(search(s));
                return true;
            }
        });
    }

    private String search(String query) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<items.size(); i++) {
            String item = items.get(i);
            if(item.toLowerCase().contains(query.toLowerCase())) {
                sb.append(item);
                if(i != items.size() - 1) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<items.size(); i++) {
            String item = items.get(i);
            sb.append(item);
            if(i != items.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}