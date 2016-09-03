package com.example.user.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mainList;
    private String[] texts = { "Lorem","ipsum","dolor","sit","amet",
                    "consectetur","adipisicing","elit","sed","do","eiusmod",
                    "tempor","incididunt","ut","labore","et","dolare","magna",
                    "aliqua","Ut","enim","ad","minim","veniam","quis","nosturd",
                    "exercitation","ullamco","laboris","nisi","ut","aliqui","ex",
                    "ea","commodo","consequat","Duis","aute","irure","dolor",
                    "in","reprehenderit","in","voluptate","velit","esse",
                    "cillum","dolore","eu","fugiat","nulla","pariatur",
                    "Excepteur","sint","occaecat","cupidatat","non","proident",
                    "sunt","in","culpa","qui","officia","doserunt","mollit",
                    "anim","id","est","laborum"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);
        mainList = (ListView) findViewById(R.id.listView);
        mainList.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));
        new MyTask().execute();
    }

    class MyTask extends AsyncTask<Void, String, Void>
    {
        private int count =0;
        private ArrayAdapter<String> adapter;
        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>) mainList.getAdapter();
            setProgressBarIndeterminate(false);
            setProgressBarVisibility(true);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(String item : texts) {
                publishProgress(item);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count ++;
            setProgress((int)((double)count/texts.length)*10000);
        }

        @Override
        protected void onPostExecute(Void result) {
            setProgressBarVisibility(false);
            L.s(MainActivity.this,"All items were added successfully");
        }
    }
}
