package com.example.scarlettpizza;

/**
 * MainPageFragment extends Fragment and is the fragment for the main page that the user will see
 * @author Selin Altiparmak, Libby Birenboim
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.scarlettpizza.databinding.FragmentMainPageBinding;

public class MainPageFragment extends Fragment {

    private FragmentMainPageBinding binding;
    private ScarletPizzaController scarletPizzaController = ScarletPizzaController.getInstance();

    /**
     * onCreateView method creates the view for this class
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return View
     */
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMainPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * onViewCreated method tells program what to do after the view has been created
     * @param view View
     * @param savedInstanceState Bundle
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        scarletPizzaController.setPizza(null);


        binding.imageNyStylePizza.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks something in the view
             * @param view View
             */
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainPageFragment.this)
                        .navigate(R.id.action_MPFragment_to_NYStyleFragment);
            }
        });

        binding.imageChicagoStylePizza.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks something in the view
             * @param view View
             */
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainPageFragment.this)
                        .navigate(R.id.action_MPFragment_to_ChicagoStyleFragment);
            }
        });
        binding.imageCurrentOrder.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks something in the view
             * @param view View
             */
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainPageFragment.this)
                        .navigate(R.id.action_MPFragment_to_CurrentOrderFragment);
            }
        });
        binding.imageStoreOrders.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user click something in the view
             * @param view View
             */
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainPageFragment.this)
                        .navigate(R.id.action_MPFragment_to_StoreOrdersFragment);
            }
        });

    }

    /**
     * onDestroyView method destroys the view once the user is finished with that activity
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}