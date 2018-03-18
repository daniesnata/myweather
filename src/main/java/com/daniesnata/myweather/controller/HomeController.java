package com.daniesnata.myweather.controller;

import com.daniesnata.myweather.domain.view.HourlyView;
import com.daniesnata.myweather.domain.view.QueryModel;
import com.daniesnata.myweather.service.WeatherService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.daniesnata.myweather.util.HomeControllerHelper.*;

/**
 * The class is the only controller receiving and sending request
 * @author danielsaldinata
 * @version 1.0
 */
@Controller
@RequestMapping("/myweather")
public class HomeController {

    private final WeatherService service;
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    public HomeController(final WeatherService service) {
        this.service = service;
    }


    /**
     * This receive the GET request on uri /myweather/home
     * Fetches weather informations from WeatherService
     * @param model the default model used to passed attribute to View
     * @param queryModel custom model to support query from View
     * @param page current page from pagination feature
     * @return html filename representing the View
     */
    @RequestMapping("/home")
    public String home(Model model, QueryModel queryModel,
                       @RequestParam(value = "page", defaultValue = "1", required = false) Integer page
                       )
    {

        logger.debug(generateLog("/myweather/home", "get", queryModel, page, queryModel.getSize()));

        if (page == null || page < 1) page = 1;
        int itemsPerPage = queryModel.isSizeValid() ? queryModel.getSize() : 15;

        List<HourlyView> hourlyViews = this.service.getWeatherInformation();
        List<HourlyView> targetViews;

        if (queryModel.isLocationValid())
            targetViews = hourlyViews.stream()
                    .filter(v -> v.getLocation().toUpperCase().contains(queryModel.getLocation().trim().toUpperCase()))
                    .collect(Collectors.toList());
        else
            targetViews = Collections.unmodifiableList(hourlyViews);

        if (queryModel.isSorted())
            sort(targetViews, queryModel.getSortedBy(), isMetric(queryModel.getScale()), isDesc(queryModel.getSortDir()));

        List<HourlyView> result = getPagedView(targetViews, page, itemsPerPage);
        int maxPage = getMaxPage(targetViews.size(), itemsPerPage);

        model.addAttribute("datas", result);
        model.addAttribute("curPage", page);
        model.addAttribute("size", itemsPerPage);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("imperial", isImperial(queryModel.getScale()));
        model.addAttribute("queryModel", queryModel);

        return "index";
    }



}
