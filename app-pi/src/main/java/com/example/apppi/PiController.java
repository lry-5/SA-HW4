package com.example.apppi;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PiController {

    private PiServer server;

    public PiController(PiServer caculator) {
        this.server = caculator;
    }

    @GetMapping("/login")
    ResponseEntity<Boolean> login(HttpSession session) {
        System.out.println("login " + session.getId());
        session.setAttribute("login", Boolean.TRUE);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @GetMapping("/pi")
    ResponseEntity<Long> pi(HttpSession session) {
        System.out.println("pi " + session.getId());
        if (session.getAttribute("login") == null || !(boolean) (session.getAttribute("login"))) {
            return new ResponseEntity<Long>(-1L, HttpStatus.UNAUTHORIZED);
        }

        long startTime = System.currentTimeMillis();
        this.server.calculatePi(10_000_000);
        long endTime = System.currentTimeMillis();

        System.out.println("time used:"+Long.valueOf(endTime - startTime));
        return ResponseEntity.ok(Long.valueOf(endTime - startTime));
    }

}