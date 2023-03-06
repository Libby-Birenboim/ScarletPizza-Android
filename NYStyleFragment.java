package com.example.scarlettpizza;

/**
 * the NYStyleFragment is the fragment class for the New York style pizza
 * @author Selin Altiparmak, Libby Birenboim
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.scarlettpizza.databinding.FragmentChicagostyleBinding;
import com.example.scarlettpizza.databinding.FragmentNystyleBinding;
import com.example.scarlettpizza.models.BbqChicken;
import com.example.scarlettpizza.models.BuildYourOwn;
import com.example.scarlettpizza.models.ChicagoPizza;
import com.example.scarlettpizza.models.Deluxe;
import com.example.scarlettpizza.models.Meatzza;
import com.example.scarlettpizza.models.NYPizza;
import com.example.scarlettpizza.models.Pizza;
import com.example.scarlettpizza.models.Size;

public class NYStyleFragment extends Fragment {

    private FragmentNystyleBinding binding;
    private Pizza pizza;
    private NYPizza nyPizza = new NYPizza();
    private ScarletPizzaController scarletPizzaController = ScarletPizzaController.getInstance();
    private ArrayAdapter<String> adapter_pizza_size;

    /**
     * onCreateView method creates the view for the NYStylePizza screen
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

        binding = FragmentNystyleBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * fillSize method creates the size options for the NYStyle pizza
     * @param adapterView AdapterView
     */
    private void fillSize(AdapterView<?> adapterView) {
        String s = adapterView.getSelectedItem().toString();
        switch (adapterView.getSelectedItem().toString()) {
            case "Small" :
                pizza.setSize(Size.SMALL);
                break;
            case "Medium" :
                pizza.setSize(Size.MEDIUM);
                break;
            case "Large" :
                pizza.setSize(Size.LARGE);
                break;
            default:
                pizza.setSize(Size.SMALL);
                break;
        }
    }

    /**
     * showInformation method shows the information about the NY style pizza to the user
     */
    private void showInformation(){
        TextView txtCrust =   getView().findViewById(R.id.text_crust);
        TextView txtPrice =  getView().findViewById(R.id.label_price);
        txtCrust.setText(pizza.getCrust().toString());
        txtPrice.setText(String.format("$%.2f", pizza.price()));

    }

    /**
     * onViewCreated method tells program what to do once the view for the NYStyle pizza has been created
     * @param view View
     * @param savedInstanceState Bundle
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View v = getView();
        if (scarletPizzaController.getPizza()!= null) {
            pizza = scarletPizzaController.getPizza();
        } else {
            pizza = nyPizza.createBuildYourOwn();
            pizza.setSize(Size.SMALL);
        }

        showInformation();

        String [] values_pizza_type =
                {"Build Your Own","Deluxe","BBQ Chicken","Meatzza",};
        Spinner spinner_pizza_type = (Spinner) v.findViewById(R.id.spinner_pizza_type);
        ArrayAdapter<String> adapter_pizza_type = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values_pizza_type);
        adapter_pizza_type.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_pizza_type.setAdapter(adapter_pizza_type);
        spinner_pizza_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * onItemSelected method tells program what to do when user selects different items for
             *      the different types of NY style pizzas that the user chooses
             * @param adapterView AdapterView
             * @param view View
             * @param i integer
             * @param l long
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //tv.setText(adapterView.getSelectedItem().toString());
                String selectedItem = adapterView.getSelectedItem().toString();
                ImageView image_pizza_type = getView().findViewById(R.id.image_pizza_type);
                switch (selectedItem) {
                    case "Build Your Own":
                        if (pizza instanceof BuildYourOwn) {
                            break;
                        }
                        image_pizza_type.setImageResource(R.drawable.ny_build_your_own);
                        pizza = nyPizza.createBuildYourOwn();
                        pizza.setSize(Size.SMALL);
                        binding.toppingsButton.setVisibility(View.VISIBLE);
                        showInformation();
                        break;
                    case "Deluxe":
                        if (pizza instanceof Deluxe) {
                            break;
                        }
                        image_pizza_type.setImageResource(R.drawable.ny_deluxe);
                        pizza = nyPizza.createDeluxe();
                        pizza.setSize(Size.SMALL);
                        binding.toppingsButton.setVisibility(View.GONE);
                        showInformation();
                        break;
                    case "BBQ Chicken":
                        if (pizza instanceof BbqChicken) {
                            break;
                        }
                        image_pizza_type.setImageResource(R.drawable.ny_bbq);
                        pizza = nyPizza.createBBQChicken();
                        pizza.setSize(Size.SMALL);
                        binding.toppingsButton.setVisibility(View.GONE);
                        showInformation();
                        break;
                    case "Meatzza":
                        if (pizza instanceof Meatzza) {
                            break;
                        }
                        image_pizza_type.setImageResource(R.drawable.ny_meatzza);
                        pizza = nyPizza.createMeatzza();
                        pizza.setSize(Size.SMALL);
                        binding.toppingsButton.setVisibility(View.GONE);
                        showInformation();
                        break;
                    default:
                        break;
                }

            }

            /**
             * onNothingSelected method tells program what to do if user doesn't select any item for their
             *      NYStyle pizza
             * @param adapterView AdapterView
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //tv.setText("");
            }
        });

        String [] values_pizza_size =
                {"Small","Medium","Large",};
        Spinner spinner_pizza_size = (Spinner) v.findViewById(R.id.spinner_pizza_size);
        adapter_pizza_size = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values_pizza_size);
        adapter_pizza_size.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_pizza_size.setAdapter(adapter_pizza_size);
        spinner_pizza_size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * onItemSelected method tells method what to do if items are selected by the user
             * @param adapterView AdapterView
             * @param view View
             * @param i integer
             * @param l long
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                fillSize(adapterView);
                showInformation();
            }

            /**
             * onNothingSelected method tells program what to do if no items were selected by the user
             * @param adapterView AdapterView
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //tv.setText("");
            }
        });

        binding.toppingsButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks something in the view
             * @param view View
             */
            @Override
            public void onClick(View view) {
                scarletPizzaController.setPizza(pizza);
                NavHostFragment.findNavController(NYStyleFragment.this)
                        .navigate(R.id.action_NYStyleFragment_to_ToppingsFragment);

            }
        });

        binding.buttonOrderPizza.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks something in the view
             * @param view View
             */
            @Override
            public void onClick(View view) {



                //NavHostFragment.findNavController(ChicagoStyleFragment.this)
                //      .navigate(R.id.action_ChicagoSTyleFragment_to_MPFragment);
                AlertDialog.Builder alertDialog =
                        new AlertDialog.Builder(getActivity());

                alertDialog.setMessage("Do you want to add pizza to order?")
                        .setCancelable(true)
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                            /**
                             * onClick method tells program what to do when user clicks something
                             * @param dialog DialogInterface
                             * @param which integer
                             */
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            /**
                             * onClick method tells program what to do when user clicks something
                             * @param dialog DialogInterface
                             * @param which integer
                             */
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                scarletPizzaController.addToOrder(pizza);
                                dialog.dismiss();
                            }
                        });
                alertDialog.create().show();
            }
        });



    }

    /**
     * onDestroyView method destroys the NYStyle pizza view once the user is done with this activity
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
