package hu.bme.iemqra.mobsoft.mobsoft.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.R;
import hu.bme.iemqra.mobsoft.mobsoft.model.Exam;
import hu.bme.iemqra.mobsoft.mobsoft.ui.detailed.DetailedActivity;

public class ExamsAdapter extends RecyclerView.Adapter<ExamsAdapter.ViewHolder> {
    private Context context;
    private List<Exam> examsList;

    public ExamsAdapter(Context context, List<Exam> examsList) {
        this.context = context;
        this.examsList = examsList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_exam, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Exam exam = examsList.get(position);

        holder.tvDate.setText(exam.getDate());
        holder.tvTitle.setText(exam.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailedActivity.exam = exam;
                context.startActivity(new Intent(context, DetailedActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return examsList.size();
    }

    public Exam getItem(int position) {
        return examsList.get(position);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDate;
        public TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.exam_date);
            tvTitle = (TextView) itemView.findViewById(R.id.exam_title);
        }
    }
}
