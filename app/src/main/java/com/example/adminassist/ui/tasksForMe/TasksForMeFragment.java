package com.example.adminassist.ui.tasksForMe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.adminassist.databinding.FragmentTasksForMeBinding;
import com.example.adminassist.databinding.FragmentUserListBinding;
import com.example.adminassist.ui.userList.UserListViewModel;

public class TasksForMeFragment extends Fragment {
    private FragmentTasksForMeBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TasksForMeViewModel tasksForMeViewModel =
                new ViewModelProvider(this).get(TasksForMeViewModel.class);

        binding = FragmentTasksForMeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
