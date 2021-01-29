package ba.sum.fpmoz.mim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import ba.sum.fpmoz.mim.ui.fragments.classes.ListClassFragment;

public class HomeNavigationProfesorActivity extends AppCompatActivity {
  private CardView classCardId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_profesor);
        setTitle("Dobrodošli profesore");

        this.classCardId=findViewById(R.id.classCardId);
        this.classCardId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), TabbedClassesActivity.class);
                startActivity(i);
            }
        });
    }
}
