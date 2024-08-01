package app;

import java.util.ArrayList;

class TempConv {
    static ArrayList<Double> ConvCelsius(double temperature){
        ArrayList<Double> convertedCelsius = new ArrayList<>(2);
        double kelvin=temperature+273.15;
        double fahrenheit=(9.0/5.0)*temperature+32;
        convertedCelsius.add(kelvin);
        convertedCelsius.add(fahrenheit);
        return convertedCelsius;
    }
    static ArrayList<Double> ConvKelvin(double temperature){
        ArrayList<Double> convertedKelvin = new ArrayList<>(2);
        double celsius=Math.round(temperature-273.15);
        double fahrenheit=Math.round((temperature-273.15)*(9.0/5.0)+32);
        convertedKelvin.add(celsius);
        convertedKelvin.add(fahrenheit);
        return convertedKelvin;
    }
    static ArrayList<Double> ConvFahrenheit(double temperature){
        ArrayList<Double> convertedFahrenheit = new ArrayList<>(2);
        double celsius=Math.round((temperature-32)*(5.0/9.0));
        double kelvin=Math.round((temperature-32)*(5.0/9.0)+273.15);
        convertedFahrenheit.add(celsius);
        convertedFahrenheit.add(kelvin);
        return convertedFahrenheit;
    }
}