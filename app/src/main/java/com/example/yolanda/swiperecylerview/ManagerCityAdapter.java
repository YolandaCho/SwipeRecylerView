package com.example.yolanda.swiperecylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class ManagerCityAdapter extends RecyclerView.Adapter {
	private Context mContext;
	private LayoutInflater mInflater;
	private List<String> stringList;
	private MyViewHolder myViewHolder;

	public ManagerCityAdapter(Context context, List<String> stringList) {
		this.mContext = context;
		this.stringList = stringList;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = mInflater.inflate(R.layout.item_recycler, parent, false);
		myViewHolder = new MyViewHolder(view);
		return myViewHolder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		myViewHolder = (MyViewHolder) holder;
	}

	@Override
	public int getItemCount() {
		return stringList != null ? stringList.size() : 0;
	}

	public void removeItem(int position) {
		stringList.remove(position);
		notifyDataSetChanged();
	}

	class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
			, View.OnLongClickListener {
		private TextView mBmp;
		private View main;
		private View delete;


		public MyViewHolder(View itemView) {
			super(itemView);
			mBmp = (TextView) itemView.findViewById(R.id.bmp);
			main = itemView.findViewById(R.id.main);
			main.setOnClickListener(this);
			main.setOnLongClickListener(this);

			delete = itemView.findViewById(R.id.delete);
			delete.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.main:
					Toast.makeText(v.getContext(), "click item : " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
					break;
				case R.id.delete:
					int pos = getAdapterPosition();
					stringList.remove(pos);
					notifyItemRemoved(pos);
					break;
			}
		}

		@Override
		public boolean onLongClick(View v) {
			switch (v.getId()) {
				case R.id.main:
					Toast.makeText(mContext, "long click : " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
					break;
			}
			return false;
		}
	}
}
