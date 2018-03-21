package edu.moravian.mathcs.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by meotm01 on 3/21/18.
 */

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private TextView txvEmail;
    private TextView txvName;

    public StudentViewHolder(View itemView) {
        super(itemView);
        txvEmail = itemView.findViewById(R.id.txvEmail);
        txvName = itemView.findViewById(R.id.txvName);
    }

    public TextView getTxvEmail() {
        return txvEmail;
    }

    public TextView getTxvName() {
        return txvName;
    }
}
