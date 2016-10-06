package com.salmannazir.namelist.fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.salmannazir.namelist.R;
import com.salmannazir.namelist.interfaces.OnPersonAddDialogResult;
import com.salmannazir.namelist.models.Person;

import org.json.JSONObject;

/**
 * Created by salmannazir on 04/10/2016.
 */

public class PersonNameFragmentDialog extends DialogFragment implements View.OnClickListener{

    private EditText mEtFirstName,mEtLastName;
    private OnPersonAddDialogResult mDialogResult; // the callback

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_fragment_person_name, container,
                false);
        getDialog().setTitle(getResources().getString(R.string.add_person_dialog_title));

        initViews(rootView);
        return rootView;
    }

    private void initViews(View rootView) {

        mEtFirstName=(EditText)rootView.findViewById(R.id.et_first_name);
        mEtLastName=(EditText)rootView.findViewById(R.id.et_last_name);
        rootView.findViewById(R.id.add_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_button:
                if (isNameValid()){

                    Person mEnteredPerson = getEnteredPerson();
                    mDialogResult.finish(mEnteredPerson);

                    dismiss();
                }

                break;

            default:
                break;
        }

    }

    private Person getEnteredPerson() {

        String enteredFirstName = mEtFirstName.getText().toString();
        String enteredLastName = mEtLastName.getText().toString();

        Person mPerson= null;
        try{
            JSONObject obj = new JSONObject();

            obj.put("first_name", capitalizeName(enteredFirstName));
            obj.put("last_name",  capitalizeName(enteredLastName));
            mPerson= new Person(obj);

        }catch (Exception e){
            e.printStackTrace();
        }

        return mPerson;
    }

    private Boolean isNameValid() {
        String firstName= mEtFirstName.getText().toString();
        String lastName = mEtLastName.getText().toString();


        if(firstName.isEmpty()){
            mEtFirstName.setError("Please Enter First Name");
            return false;
        }
        if(lastName.isEmpty()){
            mEtFirstName.setError("Please Enter Last Name");
            return false;
        }


        return true;
    }

    public void setDialogResultListener(OnPersonAddDialogResult dialogResult){
        mDialogResult = dialogResult;
    }

    public String capitalizeName(String name){

        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return name;

    }

}
