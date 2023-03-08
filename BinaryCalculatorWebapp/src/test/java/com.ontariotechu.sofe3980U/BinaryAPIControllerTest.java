package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // THREE MORE TEST CASES FOR BINARY API SERVICE

    @Test
    public void add3() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "000").param("operand2", "1110"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1110"));
    }

    @Test
    public void add4() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "000").param("operand2", "1110"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void add5() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "0").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void add6() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "0").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void add7() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "10").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("11"));
    }

    @Test
    public void add8() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "10").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // TEST CASES FOR OR OPERATION
    @Test
    public void OR() throws Exception {
        this.mvc.perform(get("/OR").param("operand1", "0").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void OR2() throws Exception {
        this.mvc.perform(get("/OR_json").param("operand1", "0").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("OR"));
    }

    @Test
    public void OR3() throws Exception {
        this.mvc.perform(get("/OR").param("operand1", "0").param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void OR4() throws Exception {
        this.mvc.perform(get("/OR_json").param("operand1", "0").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("OR"));
    }

    @Test
    public void OR5() throws Exception {
        this.mvc.perform(get("/OR").param("operand1", "1").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void OR6() throws Exception {
        this.mvc.perform(get("/OR_json").param("operand1", "1").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("OR"));
    }

    @Test
    public void OR7() throws Exception {
        this.mvc.perform(get("/OR").param("operand1", "1").param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void OR8() throws Exception {
        this.mvc.perform(get("/OR_json").param("operand1", "1").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("OR"));
    }

    // TEST CASES FOR AND OPERATION

    @Test
    public void AND() throws Exception {
        this.mvc.perform(get("/AND").param("operand1", "0").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void AND2() throws Exception {
        this.mvc.perform(get("/AND_json").param("operand1", "0").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("AND"));
    }

    @Test
    public void AND3() throws Exception {
        this.mvc.perform(get("/AND").param("operand1", "0").param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void AND4() throws Exception {
        this.mvc.perform(get("/AND_json").param("operand1", "0").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("AND"));
    }

    @Test
    public void AND5() throws Exception {
        this.mvc.perform(get("/AND").param("operand1", "1").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void AND6() throws Exception {
        this.mvc.perform(get("/AND_json").param("operand1", "1").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("AND"));
    }

    @Test
    public void AND7() throws Exception {
        this.mvc.perform(get("/AND").param("operand1", "1").param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void AND8() throws Exception {
        this.mvc.perform(get("/AND_json").param("operand1", "1").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("AND"));
    }

    // TEST CASES FOR MULTIPLY OPERATION

    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "0").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void multiply2() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "0").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void multiply3() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "0").param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void multiply4() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "0").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void multiply5() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "1").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void multiply6() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "1").param("operand2", "0"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void multiply7() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "1").param("operand2", "1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void multiply8() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "1").param("operand2", "1"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
}