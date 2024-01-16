package com.example.demo1601;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Entrada: Ninguna");
        String output = "Hello World IAM";
        System.out.println("Salida: " + output);
        return output;
    }

    @GetMapping("/reverse")
    public String reverseString(@RequestParam("input") String input) {
        System.out.println("Entrada: " + input);
        StringBuilder reversed = new StringBuilder(input);
        String output = reversed.reverse().toString();
        System.out.println("Salida: " + output);
        return output;
    }

    // operación para borrar vocales de un string
    @GetMapping("/remove-vowels")
    public String removeVowels(@RequestParam("input") String input) {
        System.out.println("Entrada: " + input);
        String output = input.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Salida: " + output);
        return output;
    }

    @GetMapping("/is-palindrome")
    public boolean isPalindrome(@RequestParam String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }
    
}
