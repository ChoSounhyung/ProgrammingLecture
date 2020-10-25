package kr.hs.mirim.room_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText mTodoEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTodoEditText = findViewById(R.id.todo_edit);
        mResultTextView = findViewById(R.id.result_text);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        //UI 갱신
        viewModel.getAll().observe(this, todos -> {
            //데이터가 변경 될 때마다 수행
            mResultTextView.setText(todos.toString());
        });

        //버튼 클릭 시 DB에 insert
        findViewById(R.id.add_button).setOnClickListener(view -> {
            viewModel.insert(new Todo(mTodoEditText.getText().toString()));
        });
    }


}