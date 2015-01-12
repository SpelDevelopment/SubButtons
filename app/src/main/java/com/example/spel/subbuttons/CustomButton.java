package com.example.spel.subbuttons;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class CustomButton extends LinearLayout {

    private Button mainButton, subButton;
    private int normalSize, bigSize, subSize;
    private Context context;
    private OnClickListener subListener;


    public CustomButton(Context context) {
        super(context);
        mainButton = new Button(context);
        this.context = context;
        setOrientation(VERTICAL);

        bigSize = getResources().getDimensionPixelSize(R.dimen.bigSize);
        normalSize = getResources().getDimensionPixelSize(R.dimen.mainSize);
        subSize = getResources().getDimensionPixelSize(R.dimen.subSize);
        deactivate();
        mainButton.setText("TEXT");
        addView(mainButton);

    }

    public void activate(){
        mainButton.setLayoutParams(new LinearLayout.LayoutParams(bigSize, bigSize));
        mainButton.setBackgroundColor(getResources().getColor(R.color.activateColor));

    }

    public void deactivate(){
        mainButton.setLayoutParams(new LinearLayout.LayoutParams(normalSize, normalSize));
        mainButton.setBackgroundColor(getResources().getColor(R.color.mainColor));
    }

    public void showSubButton(boolean show){

        if(show){
            subButton = new Button(context);
            subButton.setLayoutParams(new ViewGroup.LayoutParams(subSize, subSize));
            subButton.setBackgroundColor(getResources().getColor(R.color.mainColor));
            if(subListener != null){
                subButton.setOnClickListener(subListener);
            }
            addView(subButton);
        }else{
            try{
                removeView(subButton);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public void setSubListener(OnClickListener subListener){
        this.subListener = subListener;
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        mainButton.setOnClickListener(l);
    }
}
