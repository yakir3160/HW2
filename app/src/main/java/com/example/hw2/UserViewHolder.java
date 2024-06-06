package com.example.hw2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public ImageView getImageViewUserIcon() {
        return imageViewUserIcon;
    }

    public void setImageViewUserIcon(ImageView imageViewUserIcon) {
        this.imageViewUserIcon = imageViewUserIcon;
    }

    public TextView getTextViewUserFirstName() {
        return textViewUserFirstName;
    }

    public void setTextViewUserFirstName(TextView textViewUserFirstName) {
        this.textViewUserFirstName = textViewUserFirstName;
    }

    public TextView getTextViewUserLastName() {
        return textViewUserLastName;
    }

    public void setTextViewUserLastName(TextView textViewUserLastName) {
        this.textViewUserLastName = textViewUserLastName;
    }

    public TextView getTextViewUserCountry() {
        return textViewUserCountry;
    }

    public void setTextViewUserCountry(TextView textViewUserCountry) {
        this.textViewUserCountry = textViewUserCountry;
    }

    public TextView getTextViewUserCity() {
        return textViewUserCity;
    }

    public void setTextViewUserCity(TextView textViewUserCity) {
        this.textViewUserCity = textViewUserCity;
    }

    private ImageView imageViewUserIcon;

    private TextView textViewUserFirstName;
    private TextView textViewUserLastName;
    private TextView textViewUserCountry;
    private TextView textViewUserCity;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewUserIcon = itemView.findViewById(R.id.userImageView);
        textViewUserFirstName = itemView.findViewById(R.id.textViewFname);
        textViewUserLastName = itemView.findViewById(R.id.textViewLname);
        textViewUserCountry = itemView.findViewById(R.id.textViewCountry);
        textViewUserCity = itemView.findViewById(R.id.textViewCity);
    }
}
