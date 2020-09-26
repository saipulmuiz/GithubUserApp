package id.muiz.githubuserapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<User> userList = new ArrayList<>();

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_row_user, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        User user = (User) getItem(i);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        // private TextView txtUsername;
        private TextView txtCompany;
        private TextView txtLocation;
        // private TextView txtRepository;
        // private TextView txtFollower;
        // private TextView txtFollowing;
        private CircleImageView imgAvatar;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.tv_item_name);
            // txtUsername = view.findViewById(R.id.tv_username);
            txtCompany = view.findViewById(R.id.tv_item_company);
            txtLocation = view.findViewById(R.id.tv_item_location);
            // txtRepository = view.findViewById(R.id.jml_repository);
            // txtFollower = view.findViewById(R.id.jml_followers);
            // txtFollowing = view.findViewById(R.id.jml_following);
            imgAvatar = view.findViewById(R.id.img_foto_user);
        }

        void bind(User user) {
            txtName.setText(user.getName());
            // txtUsername.setText(user.getUsername());
            txtCompany.setText(user.getCompany());
            txtLocation.setText(user.getLocation());
            // txtRepository.setText(user.getRepository());
            // txtFollower.setText(user.getFollower());
            // txtFollowing.setText(user.getFollowing());
            imgAvatar.setImageResource(user.getAvatar());
        }
    }
}
