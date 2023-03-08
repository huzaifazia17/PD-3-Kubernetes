package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    // THREE MORE TEST CASES FOR BINARY WEB APPLICATION

    @Test
    public void getParameter2() throws Exception {
        this.mvc.perform(get("/").param("operand1", "1111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "1111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1111").param("operator", "+").param("operand2", "1111"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11110"))
                .andExpect(model().attribute("operand1", "1111"));
    }

    @Test
    public void getParameter3() throws Exception {
        this.mvc.perform(get("/").param("operand1", "1110"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "1110"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1110").param("operator", "+").param("operand2", "1110"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11100"))
                .andExpect(model().attribute("operand1", "1110"));
    }

    @Test
    public void getParameter4() throws Exception {
        this.mvc.perform(get("/").param("operand1", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "110"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter4() throws Exception {
        this.mvc.perform(post("/").param("operand1", "110").param("operator", "+").param("operand2", "110"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1100"))
                .andExpect(model().attribute("operand1", "110"));
    }

    // TEST CASES FOR NEWLY IMPLEMENTED OPERATIONS (&, |, *)

    // & TEST CASES

    @Test
    public void getParameter5() throws Exception {
        this.mvc.perform(get("/").param("operand1", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "0"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter5() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "&").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    @Test
    public void getParameter6() throws Exception {
        this.mvc.perform(get("/").param("operand1", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "0"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter6() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "&").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    @Test
    public void getParameter7() throws Exception {
        this.mvc.perform(get("/").param("operand1", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "1"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter7() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1").param("operator", "&").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "1"));
    }

    @Test
    public void getParameter8() throws Exception {
        this.mvc.perform(get("/").param("operand1", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "1"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter8() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1").param("operator", "&").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1"))
                .andExpect(model().attribute("operand1", "1"));
    }

    // | TEST CASES

    @Test
    public void getParameter9() throws Exception {
        this.mvc.perform(get("/").param("operand1", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "0"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter9() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "|").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    @Test
    public void getParameter10() throws Exception {
        this.mvc.perform(get("/").param("operand1", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "0"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter10() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "|").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1"))
                .andExpect(model().attribute("operand1", "0"));
    }

    @Test
    public void getParameter11() throws Exception {
        this.mvc.perform(get("/").param("operand1", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "1"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter11() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1").param("operator", "|").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1"))
                .andExpect(model().attribute("operand1", "1"));
    }

    @Test
    public void getParameter12() throws Exception {
        this.mvc.perform(get("/").param("operand1", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "1"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter12() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1").param("operator", "|").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1"))
                .andExpect(model().attribute("operand1", "1"));
    }

    // * TEST CASES

    @Test
    public void getParameter13() throws Exception {
        this.mvc.perform(get("/").param("operand1", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "0"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter13() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "*").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    @Test
    public void getParameter14() throws Exception {
        this.mvc.perform(get("/").param("operand1", "0"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "0"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter14() throws Exception {
        this.mvc.perform(post("/").param("operand1", "0").param("operator", "*").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    @Test
    public void getParameter15() throws Exception {
        this.mvc.perform(get("/").param("operand1", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "1"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter15() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1").param("operator", "*").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "1"));
    }

    @Test
    public void getParameter16() throws Exception {
        this.mvc.perform(get("/").param("operand1", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "1"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter16() throws Exception {
        this.mvc.perform(post("/").param("operand1", "1").param("operator", "*").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1"))
                .andExpect(model().attribute("operand1", "1"));
    }

}