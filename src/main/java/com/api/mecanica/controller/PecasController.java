package com.api.mecanica.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author [cristian.baptistella]
 * @since 2020-06-20
 */
@RestController
@CrossOrigin(origins="*")
@Api(value="API REST Pecas")
@RequestMapping("/api/pecas")
public class PecasController implements RestService{

	
}
