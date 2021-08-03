package br.com.daluz.ConsultationOfCitiesInBrazilApi.utils;

public class Utils {

    public static final String UNIT_KM = "kilometers";
    public static final String UNIT_M = "meters";
    public static final String UNIT_MI = "miles";

    public static String response(
            String cityNameFrom,
            String cityUfFrom,
            String cityNameTo,
            String cityUfTo,
            Double distance,
            String unit) {

        return "<h1>Distance between cities</h1><br /><h3>Distance between "
                + cityNameFrom + "/"
                + cityUfFrom + " and "
                + cityNameTo + "/"
                + cityUfTo + "<br />"
                + formatDouble(distance) + " "
                + unit + "</h3>";
    }

    private static String formatDouble(Double distance) {
        return String.format("%.3f", distance);
    }
}
