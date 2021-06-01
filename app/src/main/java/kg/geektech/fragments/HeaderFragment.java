package kg.geektech.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kg.geektech.quizgame.R;

public class HeaderFragment extends Fragment {

    private Button btnLevel_1;
    private Button btnLevel_2;
    private Button btnLevel_3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_header, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        firstLevel();
        secondLevel();
        thirdLevel();
    }


    private void thirdLevel() {
        btnLevel_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(),R.id.fragment_container);
                navController.navigate(R.id.thirdFragment);
            }
        });
    }

    private void secondLevel() {
        btnLevel_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(),R.id.fragment_container);
                navController.navigate(R.id.secondFragment);

            }
        });
    }

    private void firstLevel() {
        btnLevel_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(requireActivity(),R.id.fragment_container);
                navController.navigate(R.id.firstFragment);
            }
        });
    }

    private void initViews(View view) {
        btnLevel_1 = view.findViewById(R.id.btn_level_1);
        btnLevel_2 = view.findViewById(R.id.btn_level_2);
        btnLevel_3 = view.findViewById(R.id.btn_level_3);
    }
}