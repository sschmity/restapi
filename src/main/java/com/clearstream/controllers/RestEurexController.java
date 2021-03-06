package com.clearstream.controllers;

import com.clearstream.processors.TestingInternalQueueProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.camel.CamelContext;

import java.util.Map;

@RestController
@RequestMapping("/restsvc")
public class RestEurexController {
    @Autowired
    CamelContext camelContext;
    TestingInternalQueueProcessor internalQueueProcessor;

    @GetMapping(path = "/eurex", produces = MediaType.APPLICATION_XML_VALUE)
    public String getShowEurex() {
        return "<Eurex/>";
    }

    @GetMapping(path = "/eurex2", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getShowEurex2() {
        return ResponseEntity.ok().body("<eurex><inx att='1'/></eurex>");
    }

    // Handler method to consume XML request and produce text response
    @PostMapping(path = "/post/xml", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> postXML(
        @RequestBody
            String body,
        @RequestHeader
            Map<String, String> headers)

    //        @RequestHeader(value = "MSG_TYP_ID", required = false) String headerMsgTypId,
    //        @RequestHeader(value = "Content-Type", required = false) String contentTypId)
    {
        System.out.println(body);
        headers.forEach((k,v)->System.out.println(k + " " + v));
        camelContext.createProducerTemplate().sendBody("seda:testingInternalQueue", body);
        return ResponseEntity.ok().header("MSG_TYP_ID", "MT535").body("Done");
    }
}
