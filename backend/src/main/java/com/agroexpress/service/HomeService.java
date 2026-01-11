package com.agroexpress.service;

import com.agroexpress.model.Home;
import com.agroexpress.model.HomeCategory;
import java.util.List;

public interface HomeService {

    Home creatHomePageData(List<HomeCategory> categories);

}


