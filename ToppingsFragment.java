package com.example.scarlettpizza;

/**
 * ToppingsFragment is the fragment for the pizza toppings
 * @author Selin Altiparmak, Libby Birenboim
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scarlettpizza.databinding.FragmentStoreOrdersBinding;
import com.example.scarlettpizza.databinding.FragmentToppingsBinding;
import com.example.scarlettpizza.models.ChicagoPizza;
import com.example.scarlettpizza.models.Pizza;
import com.example.scarlettpizza.models.Topping;

import java.util.ArrayList;

public class ToppingsFragment extends Fragment {

    private FragmentToppingsBinding binding;
    private ArrayList<Item> items = new ArrayList<>();
    private Pizza pizza;
    private ScarletPizzaController scarletPizzaController = ScarletPizzaController.getInstance();

    private int [] itemImages = {R.drawable.sausage, R.drawable.pepperoni, R.drawable.green_pepper,
            R.drawable.onion, R.drawable.mushroom, R.drawable.bbq_chicken, R.drawable.provolone,
            R.drawable.cheddar, R.drawable.beef, R.drawable.ham };

    /**
     * onCreateView method creates the view for the toppings activity fragment
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

        binding = FragmentToppingsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * onViewCreated method tells program what to do once the view for the toppings is created
     * @param view View
     * @param savedInstanceState Bundle
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pizza = scarletPizzaController.getPizza();
        RecyclerView rcview = binding.rcViewMenu;
        setupMenuItems(); //add the list of items to the ArrayList
        ItemsAdapter adapter = new ItemsAdapter(view.getContext(), items); //create the adapter
        rcview.setAdapter(adapter); //bind the list of items to the RecyclerView
        //use the LinearLayout for the RecyclerView
        rcview.setLayoutManager(new LinearLayoutManager(view.getContext()));

    }

    /**
     * onDestroyView method destroys the topping fragment view once the user is done with this
     *      activity
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Helper method to set up the data (the Model of the MVC).
     */
    private void setupMenuItems() {
        /*
         * Item names are defined in a String array under res/string.xml.
         * Your item names might come from other places, such as an external file, or the database
         * from the backend.
         */
        String [] itemNames = getResources().getStringArray(R.array.itemNames);
        /* Add the items to the ArrayList.
         * Note that I use hardcoded prices for demo purpose. This should be replace by other
         * data sources.
         */
        ScarletPizzaController scarletPizzaController = ScarletPizzaController.getInstance();
        int i=0;
        for (Topping t: Topping.values()) {
            items.add(new Item(t.toString(), itemImages[i], "$1.59", pizza, t));
            i++;
        }
    }
}
