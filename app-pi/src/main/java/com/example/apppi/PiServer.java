package com.example.apppi;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class PiServer {

  // @Cacheable("pi")
  public double calculatePi(double n) {
    double pi = 0;
    for (int i = 1; i < n; i++) {
      pi += Math.pow(-1, i + 1) / (2 * i - 1);
    }
    return 4 * pi;
  }
}