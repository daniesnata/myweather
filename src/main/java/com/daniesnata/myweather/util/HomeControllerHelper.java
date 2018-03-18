package com.daniesnata.myweather.util;

import com.daniesnata.myweather.domain.view.HourlyView;
import com.daniesnata.myweather.domain.view.QueryModel;

import java.util.*;

/**
 * This class contains static method to help process
 * 		pagination, view, and loging in HomeController
 * @author danielsaldinata
 * @version 1.0
 */
public class HomeControllerHelper {

    public static boolean isDesc(String dir) {
        return "desc".equalsIgnoreCase(dir);
    }

    public static boolean isMetric(String scale) {
        return "metric".equalsIgnoreCase(scale);
    }

    public static boolean isImperial(String scale) {
        return "imperial".equalsIgnoreCase(scale);
    }

    public static int getMaxPage(int viewsSize, int itemsPerPage) {
        return (viewsSize / itemsPerPage) + (viewsSize % itemsPerPage == 0? 0 : 1);
    }

    /**
     * this method is used to make a subset list of original retrieved list
     * it is being used as the data displayed on View
     * @param original the original list
     * @param page current page parameter
     * @param size size of list in on a page
     * @return the subset list
     */
    public static List<HourlyView> getPagedView(List<HourlyView> original, Integer page, Integer size) {
        List<HourlyView> result = new ArrayList<>(size);

        int start = (page-1)*size;
        for (int i=start; i<start+size; i++) {
            if (i < original.size()) {
                HourlyView cur = original.get(i);
                cur.setIndex(i+1);
                result.add(cur);
            }
        }
        return result;
    }

   
    public static void sort(List<HourlyView> list, String column, boolean isMetric, boolean isDesc){

        // do nothing, just to avoid missing initialization. if failed, comparator is not used;
        Comparator<HourlyView> comparator = (x, y) -> { return 0; };
        boolean failed = false;

        if ("location".equalsIgnoreCase(column))
            comparator = Comparator.comparing(HourlyView::getLocation);

        else if ("condition".equalsIgnoreCase(column))
            comparator = Comparator.comparing(HourlyView::getCondition);

        else if ("feelsLike".equals(column) || "feels like".equalsIgnoreCase(column))
            comparator = Comparator.comparing(isMetric ? HourlyView::getFeelsLikeMetric : HourlyView::getFeelsLikeImperial);

        else if ("temp.".equalsIgnoreCase(column) || "temperature".equalsIgnoreCase(column) || "temp".equalsIgnoreCase(column))
            comparator = Comparator.comparing(isMetric ? HourlyView::getTempMetric : HourlyView::getTempImperial);

        else if ("precipitation".equalsIgnoreCase(column) || "precip".equalsIgnoreCase(column))
            comparator = Comparator.comparing(HourlyView::getPrecipitation);

        else if("amount".equalsIgnoreCase(column) && isMetric)
            comparator = Comparator.comparing(HourlyView::getAmountMetric);

        else if("amount".equalsIgnoreCase(column) && !isMetric)
            comparator = Comparator.comparing(HourlyView::getAmountImperial);

        else if("dew point".equalsIgnoreCase(column) || "dewpoint".equalsIgnoreCase(column))
            comparator = Comparator.comparing(isMetric ? HourlyView::getDewPointMetric : HourlyView::getDewPointImperial);

        else if("humidity".equalsIgnoreCase(column))
            comparator = Comparator.comparing(isMetric ? HourlyView::getHumidityMetric : HourlyView::getHumidityImperial);

        else if("wind".equalsIgnoreCase(column))
            comparator = Comparator.comparing(isMetric ? HourlyView::getWindSpeedMetric : HourlyView::getWindSpeedImperial);

        else if("pressure".equalsIgnoreCase(column) && isMetric)
            comparator = Comparator.comparing(HourlyView::getPressureMetric);

        else if("pressure".equalsIgnoreCase(column) && !isMetric)
            comparator = Comparator.comparing(HourlyView::getPressureImperial);

        else if ("time".equalsIgnoreCase(column))
            comparator =  Comparator.comparing(HourlyView::getHour);

        else
            failed = true;

        if (!failed) {

            if (isDesc)
                comparator = comparator.reversed();

            Collections.sort(list, comparator);
        }
    }

    public static String generateLog(String uri, String method, QueryModel model, Integer page, Integer size) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("uri:").append(uri).append(" ");
        stringBuffer.append("method:").append(method).append(" ");
        stringBuffer.append("param:[");
        stringBuffer.append("page:").append(page).append(" ");
        stringBuffer.append("size:").append(size).append(" ");
        stringBuffer.append("location:").append(model.getLocation()).append(" ");
        stringBuffer.append("sortedBy:").append(model.getSortedBy()).append(" ");
        stringBuffer.append("sortDir:").append(model.getSortDir()).append(" ");
        stringBuffer.append("scale:").append(model.getScale());
        stringBuffer.append("]");

        return stringBuffer.toString();
    }
}
