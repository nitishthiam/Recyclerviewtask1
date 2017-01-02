package com.tripgallery.recyclerviewtask1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button b1;
    RecyclerView rv;
    ArrayList<Movies> al;
    MyRecyclerAdapter myRecyclerviewAdapter;
    int count = 0; // for tracking serial number in lustview

    public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>{

        public class MyViewHolder extends  RecyclerView.ViewHolder{
            TextView tv1, tv2, tv3;
            public MyViewHolder(View itemView) {
                super(itemView);

                tv1 = (TextView) findViewById(R.id.textView1);
                tv2 = (TextView) findViewById(R.id.textView3);
                tv3 = (TextView) findViewById(R.id.textView3);

            }
        }

        @Override
        public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = getLayoutInflater().inflate(R.layout.row, null);

            MyViewHolder myViewHolder = new MyViewHolder(v);

            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(MyRecyclerAdapter.MyViewHolder holder, int position) {

            Movies myMovie = al.get(position);

            holder.tv1.setText(myMovie.getSno());
            holder.tv2.setText(myMovie.getMovie());
            holder.tv3.setText(myMovie.getActor());
        }

        @Override
        public int getItemCount() {
            return al.size();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button1);

        rv = (RecyclerView) findViewById(R.id.recyclerView);

        al = new ArrayList<Movies>();


        myRecyclerviewAdapter = new MyRecyclerAdapter();
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rv.setLayoutManager(llm);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                count++;
                String actor = et1.getText().toString();
                String movie = et2.getText().toString();

                Movies m1 = new Movies();
                m1.setSno(""+count);
                m1.setMovie(movie);
                m1.setActor(actor);

                al.add(m1);
                myRecyclerviewAdapter.notifyItemInserted(al.size()-1);

                et1.setText("");
                et2.setText("");
                et1.requestFocus();

            }
        });
    }
}