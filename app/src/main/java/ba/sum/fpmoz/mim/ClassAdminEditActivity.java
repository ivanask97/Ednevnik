package ba.sum.fpmoz.mim;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ba.sum.fpmoz.mim.model.Class;

public class ClassAdminEditActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;

    EditText classNameEdt;


    Button classEditBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_admin_edit);


        this.classNameEdt=findViewById(R.id.classNameEdt);


        this.classEditBtn=findViewById(R.id.classEditBtn);

        final String key=getIntent().getStringExtra("CLASS_ID");
        this.db=FirebaseDatabase.getInstance();
        this.ref=this.db.getReference("razredi/").child(key);

        this.classEditBtn.setOnClickListener((v) ->{
            Class c=new Class();

            c.name=classNameEdt.getText().toString();


            ref.setValue(c);


        } );
        this.ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Class klass=snapshot.getValue(Class.class);
                assert klass!=null;

                classNameEdt.setText(klass.name);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
