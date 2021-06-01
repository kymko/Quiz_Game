package kg.geektech.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kg.geektech.quizgame.R;

public class FirstFragment extends Fragment {

    private Button btnFirst;
    private Button btnSecond;
    private Button btnThird;
    private Button btnFourth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

        showDialog();
        btnFirstWrongDialog();
        btnSecondWrongDialog();
        btnThirdWrongDialog();

    }


    private void btnThirdWrongDialog() {
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.sample_uncorrect, null);
                alert.setTitle("Мимо!");
                final TextView textAlert = mView.findViewById(R.id.text_alert);
                final Button btnAlert = mView.findViewById(R.id.btn_alert);

                AlertDialog dialog = alert.create();
                dialog.setView(mView);
                dialog.show();
                alert.setNegativeButton(getContext().getString(R.string.app_name), null);
                btnAlert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Вы не угадали, попробуйте еще раз!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void btnSecondWrongDialog() {
        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.sample_uncorrect, null);
                alert.setTitle("Мимо!");
                final TextView textAlert = mView.findViewById(R.id.text_alert);
                final Button btnAlert = mView.findViewById(R.id.btn_alert);

                AlertDialog dialog = alert.create();
                dialog.setView(mView);
                dialog.show();
                alert.setNegativeButton(getContext().getString(R.string.app_name), null);
                btnAlert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Вы не угадали, попробуйте еще раз!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void btnFirstWrongDialog() {
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.sample_uncorrect, null);
                alert.setTitle("Мимо!");
                final TextView textAlert = mView.findViewById(R.id.text_alert);
                final Button btnAlert = mView.findViewById(R.id.btn_alert);

                AlertDialog dialog = alert.create();
                dialog.setView(mView);
                dialog.show();
                alert.setNegativeButton(getContext().getString(R.string.app_name), null);
                btnAlert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Вы не угадали, попробуйте еще раз!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }


    private void showDialog() {
        btnFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                View mView = getLayoutInflater().inflate(R.layout.sample, null);
                alert.setTitle("Правильно!!!");
                final TextView textAlert = mView.findViewById(R.id.text_alert);
                final Button btnAlert = mView.findViewById(R.id.btn_alert);

                AlertDialog dialog = alert.create();
                dialog.setView(mView);
                dialog.show();
                alert.setNegativeButton(getContext().getString(R.string.app_name), null);
                btnAlert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavController navController = Navigation.findNavController(requireActivity(),R.id.fragment_container);
                        navController.navigate(R.id.secondFragment);
                        Toast.makeText(getContext(), "Вы угадали!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }


    private void initViews(View view) {
        btnFirst = view.findViewById(R.id.btn_first);
        btnSecond = view.findViewById(R.id.btn_second);
        btnThird = view.findViewById(R.id.btn_third);
        btnFourth = view.findViewById(R.id.btn_fourth);
    }
}