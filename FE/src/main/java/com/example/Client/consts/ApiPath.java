package com.example.Client.consts;

public interface ApiPath {
    String API = "http://localhost:8080/api/v1";


    // TOUR
    String TOUR_CREATE  = "/tour/create";
    String DEPARTURE_DATE_GET_ALL_LIST = API + "/tour/create-date-get-all-list";
    String TOUR_GET_BY_TOUR_CODE = API + "/tour";
    String TOUR_UPDATE = "/tour/update";
    String TOUR_DELETE = "/tour/delete";
    String HOME_TOUR_DETAIL = API + "/tour/home-tour-detail";
    // TOUR DETAIL
    String DEPARTURE_DATE_GET_BY_ID = API + "/tour/get-by-id";
    //Cart
    String CART_FIND_BY_ID = API + "/cart/find-by-id";
    String ADD_CART_ITEM_INTO_CART = API + "/cart/add-cart-item-into-cart";
    //customer
    String CUSTOMER_LOGIN = API+"/login-customer";
    String CUSTOMER_REGISTER=API+"/register-customer";
    String CUSTOMER_FORGOT_PASSWORD = API+"/forgot-password-customer";

    //Account Detail
    String ACCOUNT_DETAIL_CREATE = API + "/accountDetail/create";
    String ACCOUNT_DETAIL_FIND_ALL = API + "/accountDetail/findAll";
    String ACCOUNT_DETAIL_FIND_BY_ID = API + "/accountDetail/findById";
    String FIND_BY_ID_UPDATE = API + "/accountDetail/findByIdUpdate";
    String ACCOUNT_DETAIL_UPDATE = API + "/accountDetail/update";
    String ACCOUNT_DETAIL_DELETE = API + "/accountDetail/delete";
}
