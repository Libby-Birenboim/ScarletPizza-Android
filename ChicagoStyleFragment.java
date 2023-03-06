package com.example.scarlettpizza;

/**
 * this class is the Fragment for the ChicagoStyle pizza
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
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.scarlettpizza.databinding.FragmentChicagostyleBinding;
import com.example.scarlettpizza.models.BbqChicken;
import com.example.scarlettpizza.models.BuildYourOwn;
import com.example.scarlettpizza.models.ChicagoPizza;
import com.example.scarlettpizza.models.Deluxe;
import com.example.scarlettpizza.models.Meatzza;
import com.example.scarlettpizza.models.Pizza;
import com.example.scarlettpizza.models.Size;

public class ChicagoStyleFragment extends Fragment {

    private FragmentChicagostyleBinding binding;
    private Pizza pizza;
    private ChicagoPizza chicagoPizza = new ChicagoPizza();
    private ScarletPizzaController scarletPizzaController = ScarletPizzaController.getInstance();
    private ArrayAdapter<String> adapter_pizza_size;

    /**
     * onCreateView method creates the view layout for the chicago style pizza
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return the View
     */
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentChicagostyleBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * fillSize fills the size of the layout for the chicago style pizza
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
     * showInformation method shows information about the crust, price, and general info about the pizza
     */
    private void showInformation(){
        TextView txtCrust =   getView().findViewById(R.id.text_crust);
        TextView txtPrice =  getView().findViewById(R.id.label_price);
        txtCrust.setText(pizza.getCrust().toString());
        txtPrice.setText(String.format("$%.2f", pizza.price()));

    }

    /**
     * onViewCreated method sets the view after it has been created
     * @param view View
     * @param savedInstanceState Bundle
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View v = getView();
        if (scarletPizzaController.getPizza()!= null) {
            pizza = scarletPizzaController.getPizza();
        } else {
            pizza = chicagoPizza.createBuildYourOwn();
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
             * onItemSelected method tells the program what to do when the user chooses their different
             *      types of pizza
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
                        image_pizza_type.setImageResource(R.drawable.chicago_build_your_own);
                        pizza = chicagoPizza.createBuildYourOwn();
                        pizza.setSize(Size.SMALL);
                        binding.toppingsButton.setVisibility(View.VISIBLE);
                        showInformation();
                        break;
                    case "Deluxe":
                        if (pizza instanceof Deluxe) {
                            break;
                        }
                        image_pizza_type.setImageResource(R.drawable.chicago_deluxe);
                        pizza = chicagoPizza.createDeluxe();
                        pizza.setSize(Size.SMALL);
                        binding.toppingsButton.setVisibility(View.GONE);
                        showInformation();
                        break;
                    case "BBQ Chicken":
                        if (pizza instanceof BbqChicken) {
                            break;
                        }
                        image_pizza_type.setImageResource(R.drawable.chicago_bbq);
                        pizza = chicagoPizza.createBBQChicken();
                        pizza.setSize(Size.SMALL);
                        binding.toppingsButton.setVisibility(View.GONE);
                        showInformation();
                        break;
                    case "Meatzza":
                        if (pizza instanceof Meatzza) {
                            break;
                        }
                        image_pizza_type.setImageResource(R.drawable.chicago_meatzza);
                        pizza = chicagoPizza.createMeatzza();
                        pizza.setSize(Size.SMALL);
                        binding.toppingsButton.setVisibility(View.GONE);
                        showInformation();
                        break;
                    default:
                        break;
                }

            }

            /**
             * onNothingSelected tells the probram what to do when the user doesn't select any pizza type
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
             * onItemSelected tells the program what to do when items are selected for the pizza
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
             * onNothingSelected just sets the stage if user doesn't select anything for their pizza
             * @param adapterView AdapterView
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //tv.setText("");
            }
        });

        binding.toppingsButton.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick tells program controller what to do on user click
             * @param view View
             */
            @Override
            public void onClick(View view) {
                scarletPizzaController.setPizza(pizza);
                NavHostFragment.findNavController(ChicagoStyleFragment.this)
                        .navigate(R.id.action_ChicagoStyleFragment_to_ToppingsFragment);

            }
        });

        binding.buttonOrderPizza.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks different things
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
                             * onClick method tells program what to do when user clicks
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
                             * onClick method tells program what to do when the user clicks something
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
     * onDestroyView closes the Chicago Style pizza view
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
