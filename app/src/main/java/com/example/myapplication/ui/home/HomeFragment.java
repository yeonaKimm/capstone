package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView; // SearchView를 가져와야 합니다.
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private SearchView searchView; // SearchView 객체 선언

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // SearchView 초기화
        searchView = binding.searchView;

        // SearchView에 대한 이벤트 리스너 설정
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 검색 버튼을 누를 때 호출됨
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null && !query.isEmpty()) {
                    // 검색어를 사용하여 작업 수행
                }
                return true; // 이벤트가 처리되었음을 반환
            }

            // 검색어가 변경될 때 호출됨
            @Override
            public boolean onQueryTextChange(String newText) {
                // newText를 사용하여 필요한 작업을 수행
                return false;
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
