/**
 * ВАЖНО: Убедитесь, что вы используете правильное название пакета.
 * В этом примере используется имя пакета:
 * package com.example.android.justjava
 * Если вы получите ошибку при копировании этого кода в Android Studio, обновите его, чтобы он
 соответствовал найденному имени пакета
 * в проекте AndroidManifest.xml файл.
 **/
package com.lencodigitexer.justjava;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

//import android.support.v7.app.AppCompatActivity;

/**
 * Это приложение отображает форму заказа кофе.
 */
public class MainActivity extends AppCompatActivity {
    int NumberOfCups = 0; // переменная для количества чашек
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * Прибавляем к переменной и отображаем кол-во
     */
    public void increment(View view){
        Button submitText = (Button) findViewById(R.id.price_button_submit);
        submitText.setText("ЗАКАЗ!");
        NumberOfCups += 1;
        display(NumberOfCups);
        displayPrice(NumberOfCups * 5); // стоимость чашек
    }

    /**
     * Уменьшаем переменную и отображаем кол-во
     */
    public void decrement(View view){
        Button submitText = (Button) findViewById(R.id.price_button_submit);
        submitText.setText("ЗАКАЗ!");
        // если чашек нет, то не уменьшаем
        if(NumberOfCups == 0){
            display(NumberOfCups = 0) ;
            displayPrice(NumberOfCups * 5); // стоимость чашек
        }
        else{
            NumberOfCups -= 1 ;
            display(NumberOfCups); }
            displayPrice(NumberOfCups * 5); // стоимость чашек
    }



    /**
     * Этот метод вызывается при нажатии кнопки заказа.
     */
    public void submitOrder(View view) {
        display(NumberOfCups); // отобращаем кол-во чашек
        displayPrice(NumberOfCups * 5); // стоимость чашек
        Button submitText = (Button) findViewById(R.id.price_button_submit);
        if(NumberOfCups > 0){
            submitText.setText("Спасибо за заказ!");
        } else {
            submitText.setText("Сначала выберите заказ!");
        }


    }
    /**
     * Этот метод отображает заданное значение количества на экране.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * Этот метод отображает значение цены на экране.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}