package ba.sum.fpmoz.mim.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import ba.sum.fpmoz.mim.R;
import ba.sum.fpmoz.mim.model.Subject;

public class SubjectListAdapter extends FirebaseRecyclerAdapter<Subject, SubjectListAdapter.SubjectViewHolder1> {
    public SubjectListAdapter(@NonNull FirebaseRecyclerOptions<Subject> options) { super(options); }

    @Override
    protected void onBindViewHolder(@NonNull SubjectListAdapter.SubjectViewHolder1 holder, int position, @NonNull Subject model) {
        holder.subjectContent.setText(model.getName());

    }

    @NonNull
    @Override
    public SubjectViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_subject_to_class_admin,parent,false);
        SubjectViewHolder1 viewHolder1=new SubjectListAdapter.SubjectViewHolder1(view);
        viewHolder1.setOnClickListener(new Adapter.ClickListener() {
            @Override
            public void OnClickListener(View v, int position) {

            }

            @Override
            public void OnLongClickListener(View v, int position) {

            }
        }); {

        }

        return viewHolder1;

    }

  public class SubjectViewHolder1 extends RecyclerView.ViewHolder{
        TextView subjectContent;
        Adapter.ClickListener clickListener;




      public void setOnClickListener(Adapter.ClickListener clickListener) {
          this.clickListener=clickListener;
      }
      public SubjectViewHolder1(@NonNull final View itemView) {
          super(itemView);
            subjectContent=itemView.findViewById(R.id.subjectContent);
            itemView.setOnClickListener((v) -> clickListener.OnClickListener(v, getAdapterPosition()));
            itemView.setOnLongClickListener((v)-> {
                clickListener.OnClickListener(v,getAdapterPosition());
                return true;
            } );
      }
  }
}