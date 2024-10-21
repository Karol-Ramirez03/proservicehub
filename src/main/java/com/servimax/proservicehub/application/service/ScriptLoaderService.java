// package com.servimax.proservicehub.application.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.Resource;
// import org.springframework.core.io.ResourceLoader;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Service;


// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// @Service
// public class ScriptLoaderService {

//     @Autowired
//     private JdbcTemplate jdbcTemplate;

//     @Autowired
//     private ResourceLoader resourceLoader;

//     @jakarta.annotation.PostConstruct
//     public void cargarProcedimientos() throws IOException {
//         Resource resource = resourceLoader.getResource("classpath:procedimientos.sql");

//         try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
//             StringBuilder sql = new StringBuilder();
//             String line;

//             while ((line = reader.readLine()) != null) {
//                 sql.append(line).append("\n");
//             }

//             jdbcTemplate.execute(sql.toString());
//         }
//     }
// }