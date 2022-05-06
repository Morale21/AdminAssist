package com.example.adminassist.ui.organizationProfile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.adminassist.databinding.FragmentOrganizationProfileBinding;
import com.example.adminassist.databinding.FragmentTasksForMeBinding;
import com.example.adminassist.ui.tasksForMe.TasksForMeViewModel;

public class OrganizationProfileFragment extends Fragment {
    private FragmentOrganizationProfileBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        OrganizationProfileViewModel tasksForMeViewModel =
                new ViewModelProvider(this).get(OrganizationProfileViewModel.class);

        binding = FragmentOrganizationProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
