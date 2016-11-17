package com.example.naty.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    EditText loginEditText;
    Button buscarButton;

    TextView nameTextView;
    TextView emailTextView;
    ImageView avatarImageView;

   ListView repositoryListView;
    RepositoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        loginEditText = (EditText) findViewById(R.id.editTextLogin);
        buscarButton = (Button)findViewById(R.id.buttonBuscar);

        nameTextView = (TextView) findViewById(R.id.textViewName);
        emailTextView = (TextView)findViewById(R.id.textViewEmail);

        avatarImageView =(ImageView)findViewById(R.id.imageView);
        repositoryListView=(ListView)findViewById(R.id.listViewRepository);


        buscarButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                if (loginEditText.getText().toString().equals("")){
                    loginEditText.setError("Complete el Login");
                    return;

                }
                //Consultar Red
                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com").build();

                UserService userService = restAdapter.create(UserService.class);

                userService.obtenerUsuario(loginEditText.getText().toString(), new Callback<User>() {
                    @Override
                    public void success(User user, Response response) {
                        Log.i("RESULTADO",user.toString());
                       /*if (user.getName()!=null){
                            nameTextView.setText(user.getName());
                        }*/

                        nameTextView.setText(user.getName()!=null ? user.getName():"");
                        emailTextView.setText(user.getEmail());
                        Picasso.with(getApplicationContext()).load(user.getAvatar_url()).into(avatarImageView);


                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.i("RSULTADO",error.getMessage());

                    }
                });
                userService.obtenerRespotorios(loginEditText.getText().toString(), new Callback<List<Repository>>() {
                    @Override
                    public void success(List<Repository> repositories, Response response) {

                        adapter = new RepositoryAdapter(getApplication(),repositories);
                        repositoryListView.setAdapter(adapter);

                        Log.i("Repositorios",repositories.toString());



                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e("Repositorios",error.getMessage());




                    }
                });

            }
        });


    }
}
