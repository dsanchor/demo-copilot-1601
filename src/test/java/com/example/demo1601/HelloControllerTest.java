package com.example.demo1601;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World IAM"));
    }

    @Test
    public void testReverseString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("olleh"));
    }

    @Test
    public void testReverseStringWithEmptyString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testReverseStringWithSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", "hello!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("!olleh"));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels").param("input", "Hello World"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hll Wrld"));
    }

    @Test
    public void testRemoveVowelsWithEmptyString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testRemoveVowelsWithSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/remove-vowels").param("input", "Hello World!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hll Wrld!"));
    }


    @Test
    public void testIsPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome").param("input", "racecar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    @Test
    public void testIsPalindromeWithNonPalindromeString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome").param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

    @Test
    public void testIsPalindromeWithEmptyString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/is-palindrome").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

}