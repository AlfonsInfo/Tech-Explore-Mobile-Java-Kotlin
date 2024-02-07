package group.learn.listviewadapter.components.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import group.learn.listviewadapter.R;
import org.jetbrains.annotations.NotNull;


public class FirstFragment extends Fragment {

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(
            @NonNull @NotNull LayoutInflater inflater,
            @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
            @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState
    ) {
        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        Button firstBtn = view.findViewById(R.id.sayHelloButtonFirstFragment);

        firstBtn.setOnClickListener(v -> Toast.makeText(getActivity(),"Hello You", Toast.LENGTH_SHORT).show());
        return view;
    }
}