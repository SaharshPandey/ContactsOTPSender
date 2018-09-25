package info.androidhive.materialtabs.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;
import info.androidhive.materialtabs.R;
import info.androidhive.materialtabs.fragments.OneFragment;
import info.androidhive.materialtabs.fragments.TwoFragment;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>{

    private String data;
    private JSONArray jsonArray;
    private JSONObject jsonObject;
    public ContactsAdapter(String data){
        this.data = data;

        try {
            jsonArray = new JSONArray(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.all_contact_list,parent,false);
        return new ContactsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {

        try {
            jsonObject = jsonArray.getJSONObject(position);
            holder.name.setText(jsonObject.getString("name"));
            holder.contact.setText(jsonObject.getString("phone"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView name;
        TextView contact;
        public ContactsViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name =  itemView.findViewById(R.id.name);
            contact = itemView.findViewById(R.id.contact);

        }
    }
}
