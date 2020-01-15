/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz3.IT355PZ3.interceptor;

import com.pz3.IT355PZ3.entities.Korisnik;
import com.pz3.IT355PZ3.entities.Uloga;
import com.pz3.IT355PZ3.service.KorisnikService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lenovo
 */
@Component
public class MojePorudzbineInterceptor implements HandlerInterceptor{
    
     @Autowired
    private KorisnikService korisnikService;
    
     @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        String email = request.getHeader("email");
        String sifra = request.getHeader("sifra");

      
        //provera kada se u headeru kontrolise da li je korisnicko ime admin 
//        if (username.equals("admin") && password != null) {
//            return true;
//        } else {
//            response.sendError(HttpStatus.UNAUTHORIZED.value(), "ACCESS DENIED!");
//        }

        //provera kada se u headeru unese email i sifra korisnika
         if (email != null && sifra != null) {
            Korisnik korisnik = korisnikService.findKorisnikByEmail(email);
//            Uloga uloga = korisnik.getUloga();
//            String u = uloga.getUlogaNaziv();
            if (korisnik != null && sifra.equals(korisnik.getSifra())) {
                return true;
            }
        } else {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "ACCESS DENIED!");
        }
        return false;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception exception) throws Exception {
    }
}
