package com.agroexpress.service;

import com.agroexpress.model.Seller;
import com.agroexpress.model.SellerReport;

public interface SellerReportService {
    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport( SellerReport sellerReport);

}


