package com.cybersoft.food_project.jwt;

import com.google.gson.Gson;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    private Gson gson = new Gson();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Cat header va lấy token
        String token = getTokenfromHeader(request);
        if (token != null){
            //Kiểm tra token có phải do hệ thống sinh ra không
            if (jwtTokenHelper.validateToken(token)){

                //Token hợp lệ
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("","", new ArrayList<>());
                String json = jwtTokenHelper.decodeToken(token);
                Map<String,Object> map = gson.fromJson(json, Map.class);
                System.out.println( json + " - " + map.get("type").toString());

                if(StringUtils.hasText("type") && !map.get("type").toString().equals("refresh")){
                    SecurityContext securityContext = SecurityContextHolder.getContext();
                    securityContext.setAuthentication(authenticationToken);
                }


            }

        }
        filterChain.doFilter(request,response);
    }

    private String getTokenfromHeader(HttpServletRequest request){
        String strToken = request.getHeader("Authorization");

        //Kiểm tra Header Authorization có giá trị và bắt đấu bằng bearer
        if(StringUtils.hasText(strToken) && strToken.startsWith("Bearer ") ){
            //Xử lý token hợp lệ
            //Cắt chuỗi strToken -> get Token: SubString()

            String finalToken = strToken.substring(7);
            return finalToken;
        }
        return null;
    }
}
