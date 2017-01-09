package com.geely.collapsemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainButton, button01, button02, button03;

    private boolean expanded = false;
    private Interpolator overshootInterpolator;
    private Interpolator anticipateInterpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overshootInterpolator = new OvershootInterpolator();
        anticipateInterpolator = new AnticipateInterpolator();

        mainButton = (Button) findViewById(R.id.mainButton);
        mainButton.setText("折叠");
        mainButton.setOnClickListener(this);

        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button03 = (Button) findViewById(R.id.button03);

        button01.setAlpha(0f);
        button02.setAlpha(0f);
        button03.setAlpha(0f);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainButton:
                if (expanded) {
                    //折叠
                    expanded = false;
                    mainButton.setText("折叠");

                    button01.animate().translationY(0).alpha(0.0f).setDuration(400).setInterpolator(anticipateInterpolator);
                    button02.animate().translationY(0).alpha(0.0f).setDuration(400).setInterpolator(anticipateInterpolator);
                    button03.animate().translationY(0).alpha(0.0f).setDuration(400).setInterpolator(anticipateInterpolator);
                } else {
                    //展开
                    expanded = true;
                    mainButton.setText("展开");

                    button01.animate().translationY(-150).alpha(1.0f).setDuration(400).setInterpolator(overshootInterpolator);
                    button02.animate().translationY(-300).alpha(1.0f).setDuration(400).setInterpolator(overshootInterpolator);
                    button03.animate().translationY(-450).alpha(1.0f).setDuration(400).setInterpolator(overshootInterpolator);
                }
                break;

            case R.id.button01:
                Toast.makeText(this, "click 01", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button02:
                Toast.makeText(this, "click 02", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button03:
                Toast.makeText(this, "click 03", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
}
