package com.template.spring_server.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("api/rolebased")
public class RoleController {

    @GetMapping("/anon")
    public @ResponseBody
    ResponseEntity<String> anon() {
        return ResponseEntity.ok("Anonymous request");
    }

    @RolesAllowed("user")
    @GetMapping("/user")
    public @ResponseBody
    ResponseEntity<String> user() {
        return ResponseEntity.ok("User request");
    }

    @RolesAllowed("admin")
    @GetMapping("/admin")
    public @ResponseBody
    ResponseEntity<String> admin() {
        return ResponseEntity.ok("Admin request");
    }
}
