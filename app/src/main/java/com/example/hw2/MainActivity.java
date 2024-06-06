package com.example.hw2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.hw2.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TextView firstNameTextView, lastNameTextView, emailTextView, cityTextView, countryTextView, ageTextView;
    private ImageView userImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        cityTextView = findViewById(R.id.cityTextView);
        countryTextView = findViewById(R.id.countryTextView);
        ageTextView = findViewById(R.id.ageTextView);
        userImageView = findViewById(R.id.userImageView);

        binding.viewCollectionButton.setOnClickListener(v -> openUsersActivity());
        binding.nextUserButton.setOnClickListener(v -> fetchUser());

        fetchUser();
    }

    private void openUsersActivity() {
        Intent intent = new Intent(this, UsersActivity.class);
        startActivity(intent);
    }

    private void fetchUser() {
        Retrofit retrofit = UserAPIClient.getClient();
        UserService service = retrofit.create(UserService.class);
        Call<Users> callAsync = service.getUsers(null, null, null);
        callAsync.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(@NonNull Call<Users> call, @NonNull Response<Users> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Result> results = response.body().getResults();
                    if (!results.isEmpty()) {
                        Result user = results.get(0);
                        displayUser(user);
                    } else {
                        onFailure(call, new Throwable("Unsuccessful response"));
                    }
                } else {
                    onFailure(call, new Throwable("Unsuccessful response"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Users> call, @NonNull Throwable throwable) {
                firstNameTextView.setText("Error");
                lastNameTextView.setText("Error");
                emailTextView.setText("Email: Error");
                cityTextView.setText("City: Error");
                countryTextView.setText("Country: Error");
                ageTextView.setText("Age: Error");
                Glide.with(MainActivity.this)
                        .load(R.drawable.error) // Replace 'error' with the name of your error image file
                        .into(userImageView);
            }
        });
    }

    private void displayUser(Result user) {
        firstNameTextView.setText("First Name: " + user.getName().getFirst());
        lastNameTextView.setText("Last Name: " + user.getName().getLast());
        emailTextView.setText("Email: " + user.getEmail());
        cityTextView.setText("City: " + user.getLocation().getCity());
        countryTextView.setText("Country: " + user.getLocation().getCountry());
        ageTextView.setText("Age: " + user.getDob().getAge());


        Glide.with(this)
                .load(user.getPicture().getLarge())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(userImageView);
    }

}
