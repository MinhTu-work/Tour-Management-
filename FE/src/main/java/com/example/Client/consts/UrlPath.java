package com.example.Client.consts;

public interface UrlPath {
    String BASE_URL = "/admin/v1";
    // PING
    String PING = BASE_URL + "/ping";

    // TOUR
    String TOUR_PAGE = BASE_URL + "/tour";
    String TOUR_DETAIL = BASE_URL + "/tourDetail";
    String HOME_TOUR = BASE_URL + "/home";
    //Cart
    String CART_INSERT_CART_ITEM = BASE_URL + "/tourDetail/cart";

    String CART_ITEM_FIND_ALL = BASE_URL + "/cart";
    //CUSTOMER
    String CUSTOMER_LOGIN = BASE_URL+"/login-customer";
    String CUSTOMER_REGISTER = BASE_URL+"/register-customer";
    String CUSTOMER_FORGOT_PASSWORD = BASE_URL+"/forgot-password-customer";
    String HOME_PAGE = BASE_URL + "/homePage";
    // ACCOUNT
    String ACCOUNT_INFO = BASE_URL + "/accountInfo";
    String UPDATE_FORM = BASE_URL + "/accountUpdateForm";
    String ACCOUNT_UPDATE = BASE_URL + "/accountUpdate";
    String ACCOUNT_DELETE = BASE_URL + "/accountDelete";

    //
    String UPLOAD_DIRECTORY = "C:/image/";
}
