package ba.sum.fpmoz.mim.ui.fragments.classes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ba.sum.fpmoz.mim.R;
import ba.sum.fpmoz.mim.model.Class;
import ba.sum.fpmoz.mim.model.Subject;
import ba.sum.fpmoz.mim.ui.adapters.SubjectAdapter;
import ba.sum.fpmoz.mim.ui.adapters.SubjectListAdapter;


public class AddClassFragment extends Fragment {
    FirebaseDatabase db;
    DatabaseReference ref, ref1;
    SubjectListAdapter adapter;
    EditText classNameInp;
    RecyclerView subjectList;
    Button addClassBtn;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
        final View classAdminView = inflater.inflate(R.layout.activity_class_admin,container,false);
        this.subjectList=classAdminView.findViewById(R.id.subjectList);
        this.db = FirebaseDatabase.getInstance();
        this.ref = this.db.getReference("razredi");
        this.ref1=this.db.getReference("predmeti");
        this.subjectList.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Subject> options=new FirebaseRecyclerOptions.Builder<Subject>().setQuery(this.ref1, Subject.class).build();
        this.adapter=new SubjectListAdapter(options);
        this.subjectList.setAdapter(this.adapter);

        this.classNameInp = classAdminView.findViewById(R.id.classNameInp);
        this.addClassBtn = classAdminView.findViewById(R.id.AddClassBtn);

        addClassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String className = classNameInp.getText().toString();

                ref.push().setValue(
                        new Class(className)
                );
                classNameInp.setText("");

                Toast.makeText(classAdminView.getContext(),
                        "Uspješno ste dodali razred",Toast.LENGTH_LONG).show();

            }
        });
        return classAdminView;

    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
