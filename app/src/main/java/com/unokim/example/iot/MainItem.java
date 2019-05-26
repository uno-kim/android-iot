package com.unokim.example.iot;

import androidx.annotation.NonNull;

public class MainItem {

    private int icon;

    private int power;

    @NonNull
    private String title;

    @NonNull
    private String description;

    public MainItem(int icon, int power, @NonNull String title, @NonNull String description) {
        this.icon = icon;
        this.power = power;
        this.title = title;
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }
}
