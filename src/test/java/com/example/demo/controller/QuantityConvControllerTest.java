package com.example.demo.controller;

import com.example.demo.service.QuantityConvService;

import com.example.demo.service.QuantityUnits;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
@AutoConfigureMockMvc
public class QuantityConvControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    QuantityConvService quantityConvService;
    Gson gson = new Gson();
    List<String> quantity = new ArrayList<>();

    public QuantityConvControllerTest() {
        quantity.add("abc");
        quantity.add("1234");
    }

    @Test
    void whenQuantityConversion_GetQuantityReq_shouldReturnListOfQuantity() throws Exception {
        when(quantityConvService.getQuantity()).thenReturn(this.quantity);
        MvcResult mvcResult = this.mockMvc.perform(get("/quantity")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        String quantityList = mvcResult.getResponse().getContentAsString();
        List<String> quantity = gson.fromJson(quantityList, new TypeToken<ArrayList<String>>(){
        }.getType());
        Assert.assertEquals(2, quantity.size());
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }
}
