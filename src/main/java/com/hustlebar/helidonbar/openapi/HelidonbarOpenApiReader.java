package com.hustlebar.helidonbar.openapi;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASModelReader;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.info.Contact;
import org.eclipse.microprofile.openapi.models.info.Info;

public class HelidonbarOpenApiReader implements OASModelReader {
    @Override
    public OpenAPI buildModel() {
        return OASFactory.createOpenAPI()
                .info(info());
    }

    private Info info() {
        return OASFactory
                .createInfo()
                .title("Helidonbar")
                .description("Helidonbar API")
                .version("1.0")
                .contact(contact());
    }

    private Contact contact() {
        return OASFactory
                .createContact()
                .name("Tham")
                .url("http://blog.tham.fyi");
    }
}
