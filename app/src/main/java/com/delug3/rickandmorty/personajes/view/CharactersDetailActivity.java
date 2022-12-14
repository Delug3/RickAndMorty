package com.delug3.rickandmorty.personajes.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.delug3.rickandmorty.R;

public class CharactersDetailActivity extends AppCompatActivity {

    TextView tvEpisodeCode, tvEpisodeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_details_activity);

        tvEpisodeCode = (TextView) findViewById(R.id.tvEpisodeCodeDetail);
        tvEpisodeName = (TextView) findViewById(R.id.tvEpisodeNameDetail);

        Intent i = getIntent();
        Toast.makeText(CharactersDetailActivity.this, i.getIntExtra("EPISODIO_ID", 0) + "", Toast.LENGTH_SHORT).show();

        String code, name;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                code = null;
                name = null;
            } else {
                code = extras.getString("EPISODIO_CODIGO");
                name = extras.getString("EPISODIO_NOMBRE");

                tvEpisodeCode.setText(code);
                tvEpisodeName.setText(name);

            }
        } else {
            code = (String) savedInstanceState.getSerializable("EPISODIO_CODIGO");
            name = (String) savedInstanceState.getSerializable("EPISODIO_NOMBRE");
        }

    }


}
