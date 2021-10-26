package com.webdev.tourapp.TransportCompany.Company.Infrastructure.Controllers;

import com.webdev.tourapp.TransportCompany.Company.Application.Create.CompanyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Company")
public class CreateCompanyPostController {

    @Autowired
    CompanyCreator creator;

    @PostMapping("/")
    ResponseEntity execute(@RequestBody CompanyRequest request) {
        this.creator.execute(request.getId(), request.getName(), request.getUrl(),
                request.getCellphone(), request.getPrice());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }


    static class CompanyRequest {
        private String id;
        private String name;
        private String url;
        private String cellphone;
        private Double price;

        public CompanyRequest() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCellphone() {
            return cellphone;
        }

        public void setCellphone(String cellphone) {
            this.cellphone = cellphone;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}
