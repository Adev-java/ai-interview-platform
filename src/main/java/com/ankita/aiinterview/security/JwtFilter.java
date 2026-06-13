package com.ankita.aiinterview.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ankita.aiinterview.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @SuppressWarnings("unused")
   JwtFilter(JwtUtil jwtUtil) {
      this.jwtUtil = jwtUtil;
   }

   @Override
protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain filterChain)
        throws ServletException, IOException {

    String path = request.getServletPath();

    // Swagger endpoints skip
    if (path.startsWith("/swagger-ui")
            || path.startsWith("/v3/api-docs")) {

        filterChain.doFilter(request, response);
        return;
    }
        
    String authHeader = request.getHeader("Authorization");

    if (authHeader != null && authHeader.startsWith("Bearer ")) {

        String token = authHeader.substring(7);

        boolean isValid = jwtUtil.validateToken(token);

        if (!isValid) {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid JWT Token");
            return;
        }
    }

      filterChain.doFilter(request, response);
        
if (path.startsWith("/swagger-ui")
        || path.startsWith("/v3/api-docs")) {

    filterChain.doFilter(request, response);
}
}}

   

